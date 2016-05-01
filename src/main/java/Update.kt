package io.ingenieux.telegram

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.*

data class InlineKeyboardMarkup @JsonCreator constructor(
        @param:JsonProperty("inline_keyboard") @get:JsonProperty("inline_keyboard")
        val inlineKeyboard: Array<Array<InlineKeyboardButton>>
)


/** Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile again. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class GetFileRequest @JsonCreator constructor(@param:JsonProperty("chat_id") @get:com.fasterxml.jackson.annotation.JsonProperty("chat_id")
                                                   val fileId: String)


@JsonIgnoreProperties(ignoreUnknown = true)
interface InputMessageContent {}

@JsonIgnoreProperties(ignoreUnknown = true)
interface ReplyMarkup {}

@JsonIgnoreProperties(ignoreUnknown = true)
interface InlineQueryResult {}

