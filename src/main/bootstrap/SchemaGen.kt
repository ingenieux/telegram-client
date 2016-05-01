import net.htmlparser.jericho.Element
import net.htmlparser.jericho.Source
import net.htmlparser.jericho.Tag
import java.io.File
import java.util.*

fun parse(inputFile: String): Source {
    val sourceContent = File(inputFile).readText()

    return Source(sourceContent)
}

fun main(args: Array<String>) {

    val content = parse("api.html")

    val tags = content.fullSequentialParse()

    val listIterator = content.allStartTags.filter { it.name == "h4" }.listIterator()

    val result: MutableList<String> = ArrayList()

    result.add("package io.ingenieux.telegram.model\n")
    result.add("import com.fasterxml.jackson.annotation.JsonCreator")
    result.add("import com.fasterxml.jackson.annotation.JsonIgnoreProperties")
    result.add("import com.fasterxml.jackson.annotation.JsonProperty")
    result.add("import com.fasterxml.jackson.databind.annotation.JsonDeserialize")
    result.add("import java.util.*\n")

    val requestResult: MutableList<String> = ArrayList(result)

    do {
        val firstTag = listIterator.next()
        val firstElement = content.getNextElement(firstTag.begin)
        val secondElement = content.getNextElement(1 + firstElement.end)
        var thirdElement = content.getNextElement(1 + secondElement.end)

        val isAnH4 = (firstTag.name === "h4")
        val isAnP = (secondElement.name === "p")
        val isATable = (thirdElement.name === "table")

        val isValid = isAnH4 && isAnP && isATable

        if (isValid) {
            val isObject = firstElement.textExtractor.toString().elementAt(0).isUpperCase()

            if (isObject) {
                val pair = generateObject(firstElement, secondElement, thirdElement)

                result.add(pair.second)
            } else {
                val pair = generateRequest(firstElement, secondElement, thirdElement)

                if (!pair.component1().equals("GetFileRequest")) {
                    requestResult.add(pair.second)
                }
            }

            //if (pair.first[0].isLowerCase()) {
            //    println("Ignoring element: " + pair.component1() + ": " + pair.component2())
            //    continue;
            //}
        }

    } while (listIterator.previousIndex() < (tags.size - 3) && listIterator.hasNext())

    arrayOf("Telegram", "TelegramRequests").forEach {
        File("src/main/java/${it}.kt").delete()
    }

    File("src/main/java/Telegram.kt").appendText(result.joinToString(separator = "\n\n\n"))
    File("src/main/java/TelegramRequests.kt").appendText(requestResult.joinToString(separator = "\n\n\n"))
}

data class Field(
        val name: String,
        val type: String,
        val desc: String
) {
    private val DATE_FIELDS = setOf<String>("date", "forward_date")

    override fun toString(): String {
        val builder = StringBuilder()

        val fieldName = name.toLowerCase().replace(Regex("_(\\p{Lower})"), { it -> it.groupValues[1].toUpperCase() })

        builder.append("  /** ${desc} **/\n")
        builder.append("  @param:JsonProperty(\"${name}\") @get:JsonProperty(\"${name}\")\n")
        if (DATE_FIELDS.contains(name)) {
            builder.append("  @param:JsonDeserialize(using = UnixTimestampAsStringDeserializer::class)\n")
            builder.append("  val ${fieldName}: Date")
        } else {
            builder.append("  val ${fieldName}: ${type}")
        }

        if (desc.toLowerCase().contains("optional")) {
            builder.append("?")
        }

        return builder.toString()
    }
}


fun generateRequest(firstElement: Element, secondElement: Element, thirdElement: Element): Pair<String, String> {
    val name = (firstElement.textExtractor.toString() + "Request")
            .replace(Regex("^(\\p{Alpha})"), { it -> it.groupValues[1].toUpperCase() })
    val desc = secondElement.textExtractor.toString()

    val fields = extractRequestFieldsFrom(thirdElement)

    val result = StringBuilder()

    result.append("/** ${desc} **/\n")
    result.append("@JsonIgnoreProperties(ignoreUnknown=true)\n")
    result.append("data class ${name} @JsonCreator constructor(")

    result.append(fields.joinToString(separator = "\n,\n"))

    result.append(")")

    var resultAsString = result.toString()

    resultAsString = resultAsString.replace(Regex("Array of (\\w+)"), "Array<$1>")
    resultAsString = resultAsString.replace("Array<Array> of KeyboardButton", "Array<Array<KeyboardButton>>")
    resultAsString = resultAsString.replace("Integer or String", "String")
    resultAsString = resultAsString.replace("InputFile or String", "String")
    resultAsString = resultAsString.replace("Integer", "Int")
    resultAsString = resultAsString.replace("True", "Boolean")
    resultAsString = resultAsString.replace("Float number", "Float")
    resultAsString = resultAsString.replace("InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply", "ReplyMarkup")

    return Pair(name, resultAsString)
}

fun generateObject(firstElement: Element, secondElement: Element, thirdElement: Element): Pair<String, String> {
    val name = firstElement.textExtractor.toString()
    val desc = secondElement.textExtractor.toString()

    val fields = extractFieldsFrom(thirdElement)

    val result = StringBuilder()

    result.append("/** ${desc} **/\n")
    result.append("@JsonIgnoreProperties(ignoreUnknown=true)\n")
    result.append("data class ${name} @JsonCreator constructor(")

    result.append(fields.joinToString(separator = "\n,\n"))

    result.append(")")

    if (name.matches(Regex("Input\\w+Content"))) {
        result.append(": InputMessageContent")
    } else if (name.matches(Regex("(InlineKeyboardMarkup|ReplyKeyboardMarkup|ReplyKeyboardHide|ForceReply)"))) {
        result.append(": ReplyMarkup")
    } else if (name.matches(Regex("InlineQueryResult\\w+"))) {
        result.append(": InlineQueryResult")
    }

    var resultAsString = result.toString()

    resultAsString = resultAsString.replace(Regex("Array of (\\w+)"), "Array<$1>")
    resultAsString = resultAsString.replace("Array<Array> of KeyboardButton", "Array<Array<KeyboardButton>>")
    resultAsString = resultAsString.replace("Integer", "Int")
    resultAsString = resultAsString.replace("True", "Boolean")
    resultAsString = resultAsString.replace("Float number", "Float")

    return Pair(name, resultAsString)
}

fun extractRequestFieldsFrom(thirdElement: Element): List<Field> {
    val result: MutableList<Field> = ArrayList()

    val allElements = thirdElement.allElements

    var index = 0

    var name: String = "";
    var type: String = "";
    var desc: String = "";
    var optional: Boolean = false

    allElements.forEach { el ->
        if (el.name.equals("td")) {
            if (4 == index) {
                if (optional) {
                    type += "?"
                }
                result.add(Field(name, type, desc))
                index = 0
            }

            if (0 == index) {
                name = el.textExtractor.toString()
            } else if (1 == index) {
                type = el.textExtractor.toString()
            } else if (2 == index) {
                optional = el.textExtractor.toString().toLowerCase().contains("optional")
            } else if (3 == index) {
                desc = el.textExtractor.toString()
            }

            index++
        }
    }

    return result.subList(1, result.size)
}

fun extractFieldsFrom(thirdElement: Element): List<Field> {
    val result: MutableList<Field> = ArrayList()

    val allElements = thirdElement.allElements

    var index = 0

    var name: String = "";
    var type: String = "";
    var desc: String = "";


    allElements.forEach { el ->
        if (el.name.equals("td")) {
            if (3 == index) {
                result.add(Field(name, type, desc))
                index = 0
            }

            if (0 == index) {
                name = el.textExtractor.toString()
            } else if (1 == index) {
                type = el.textExtractor.toString()
            } else if (2 == index) {
                desc = el.textExtractor.toString()
            }

            index++
        }
    }

    return result.subList(1, result.size)
}
