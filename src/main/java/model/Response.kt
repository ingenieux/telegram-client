package io.ingenieux.telegram.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/** Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile again. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class TelegramResponse @JsonCreator constructor(
  @param:JsonProperty("ok") @get:com.fasterxml.jackson.annotation.JsonProperty("ok")
  val ok: Boolean
  ,
  @param:JsonProperty("description") @get:com.fasterxml.jackson.annotation.JsonProperty("description")
  val description: String?
  ,
  @param:JsonProperty("error_code") @get:com.fasterxml.jackson.annotation.JsonProperty("error_code")
  val errorCode: Int?
)

/** Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile again. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class GetMeResponse @JsonCreator constructor(
  @param:JsonProperty("ok") @get:com.fasterxml.jackson.annotation.JsonProperty("ok")
  val ok: Boolean
  ,
  @param:JsonProperty("result") @get:com.fasterxml.jackson.annotation.JsonProperty("result")
  val result: User
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SendMessageResponse @JsonCreator constructor(
  @param:JsonProperty("ok") @get:com.fasterxml.jackson.annotation.JsonProperty("ok")
  val ok: Boolean
  ,
  @param:JsonProperty("result") @get:com.fasterxml.jackson.annotation.JsonProperty("result")
  val description: Message
)
