package x;

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

    val h4s: MutableList<Triple<Element, Tag, Tag>> = ArrayList()

    val listIterator = content.allStartTags.filter { it.name == "h4" }.listIterator()

    val result: MutableList<String> = ArrayList()

    do {
        val firstTag = listIterator.next() as Tag
        val firstElement = content.getNextElement(firstTag.begin)
        val secondElement = content.getNextElement(1 + firstElement.end)
        var thirdElement = content.getNextElement(1 + secondElement.end)

        val isAnH4 = (firstTag.name === "h4")
        val isAnP = (secondElement.name === "p")
        val isATable = (thirdElement.name === "table")

        val isValid = isAnH4 && isAnP && isATable

        if (isValid) {
            val pair = generateObject(firstElement, secondElement, thirdElement)

            if (pair.first[0].isLowerCase())
                continue;

            result.add(pair.second)
        }

    } while (listIterator.previousIndex() < (tags.size - 3) && listIterator.hasNext())

    System.out.println(result.joinToString(separator = "\n\n\n"))
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
    }

    var resultAsString = result.toString()

    resultAsString = resultAsString.replace(Regex("Array of (\\w+)"), "Array<$1>")
    resultAsString = resultAsString.replace("Array<Array> of KeyboardButton", "Array<Array<KeyboardButton>>")
    resultAsString = resultAsString.replace("Integer", "Int")
    resultAsString = resultAsString.replace("True", "Boolean")
    resultAsString = resultAsString.replace("Float number", "Float")

    return Pair(name, resultAsString)
}

fun extractFieldsFrom(thirdElement: Element): List<Field> {
    val result: MutableList<Field> = ArrayList()

    val allElements = thirdElement.allElements

    var index = 0

    var name: String = "";
    var type: String = "";
    var desc: String = "";


    allElements.forEach {
        val el = it as Element

        //println("el.name: ${el.name}")

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
