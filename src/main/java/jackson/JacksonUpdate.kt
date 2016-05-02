package io.ingenieux.telegram.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.ObjectNode
import io.ingenieux.telegram.model.*
import java.util.*

class UnixTimestampAsStringDeserializer : StdDeserializer<Date>(Date::class.java) {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Date? {
        val timestamp = p!!.text.trim().toLong() * 1000L

        return Date(timestamp)
    }
}

class InputMessageContentDeserializer : StdDeserializer<InputMessageContent>(InputMessageContent::class.java) {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): InputMessageContent {
        val mapper = p!!.codec as ObjectMapper
        val root = mapper.readTree<ObjectNode>(p)
        //val targetClass: Class<out InputMessageContent>
        val typeReference: TypeReference<out InputMessageContent>

        if (!root.path("message_text").isMissingNode) {
            typeReference = object : TypeReference<InputTextMessageContent>() {}
            //targetClass = InputMessageContent::class.java
        } else if (!root.path("address").isMissingNode) {
            typeReference = object : TypeReference<InputVenueMessageContent>() {}
            //targetClass = InputVenueMessageContent::class.java
        } else if (!root.path("latitude").isMissingNode) {
            typeReference = object : TypeReference<InputLocationMessageContent>() {}
            //targetClass = InputLocationMessageContent::class.java
        } else if (!root.path("phone_number").isMissingNode) {
            typeReference = object : TypeReference<InputContactMessageContent>() {}
            //targetClass = InputContactMessageContent::class.java
        } else {

            throw IllegalStateException("Unable to found a deserializer for object: ${root}")
        }

        return mapper.convertValue(root, typeReference)
    }
}

object TelegramDeserializationModule : SimpleModule("telegram-deserialization-module", Version(0, 0, 1, "SNAPSHOT", "io.ingenieux.telegram", "lambada-telegram-bot")) {
    init {
        addDeserializer(InputMessageContent::class.java, InputMessageContentDeserializer())
        addDeserializer(Date::class.java, UnixTimestampAsStringDeserializer())
    }
}
