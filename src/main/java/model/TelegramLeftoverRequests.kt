package io.ingenieux.telegram.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SetWebhookRequest @JsonCreator constructor(
  @param:JsonProperty("url") @get:com.fasterxml.jackson.annotation.JsonProperty("url")
  var url: String? = null
  ,
  @param:JsonProperty("certificate") @get:com.fasterxml.jackson.annotation.JsonProperty("certificate")
  var certificate: InputFile? = null
) : HasInputFile

/** Use this method to send text messages. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendAudioRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Text of the message to be sent **/
  @param:JsonProperty("audio") @get:JsonProperty("text")
  var audio: InputFile
  ,
  /** Duration of the audio in seconds **/
  @param:JsonProperty("duration") @get:JsonProperty("duration")
  var duration: Int? = null
  ,
  /** Performer **/
  @param:JsonProperty("performer") @get:JsonProperty("performer")
  var performer: String? = null
  ,
  /** Performer **/
  @param:JsonProperty("performer") @get:JsonProperty("performer")
  var title: String? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
) : HasInputFile

@JsonIgnoreProperties(ignoreUnknown = true)
data class SendChatActionRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:com.fasterxml.jackson.annotation.JsonProperty("chat_id")
  var chatId: String
  ,
  @param:JsonProperty("action") @get:com.fasterxml.jackson.annotation.JsonProperty("action")
  var action: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TelegramFile @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("file_id") @get:com.fasterxml.jackson.annotation.JsonProperty("file_id")
  var chatId: String
  ,
  @param:JsonProperty("file_size") @get:com.fasterxml.jackson.annotation.JsonProperty("file_size")
  var fileSize: Int? = null
  ,
  @param:JsonProperty("file_path") @get:com.fasterxml.jackson.annotation.JsonProperty("file_path")
  var path: String? = null
)

