package io.ingenieux.telegram

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ingenieux.telegram.jackson.TelegramDeserializationModule
import io.ingenieux.telegram.model.*
import org.slf4j.LoggerFactory

abstract class AbstractTelegramClient(val apiToken: String) {
  protected abstract fun <T> doRequest(methodName: String, responseClass: Class<T>, body: Any? = null): T

  companion object {
    val MAPPER = jacksonObjectMapper()
      .enable(SerializationFeature.INDENT_OUTPUT)
      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
      .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
      .registerModule(TelegramDeserializationModule)
  }

  protected val LOGGER = LoggerFactory.getLogger(this.javaClass)

  var endpoint: String

  init {
    endpoint = "https://api.telegram.org/bot${apiToken}"
  }

  fun getMe() = doRequest("getMe", GetMeResponse::class.java)

  fun sendMessage(req: SendMessageRequest) =
    doRequest("sendMessage", SendMessageResponse::class.java, req)

  fun forwardMessage(req: ForwardMessageRequest)
    = doRequest("forwardMessage", SendMessageResponse::class.java, req)

  fun sendPhoto(req: SendPhotoRequest)
    = doRequest("sendPhoto", SendMessageResponse::class.java, req)

  fun sendAudio(req: SendAudioRequest)
    = doRequest("sendAudio", SendMessageResponse::class.java, req)

  fun sendDocument(req: SendDocumentRequest)
    = doRequest("sendDocument", SendMessageResponse::class.java, req)

  fun sendSticker(req: SendStickerRequest)
    = doRequest("sendSticker", SendMessageResponse::class.java, req)

  fun sendVideo(req: SendVideoRequest)
    = doRequest("sendVideo", SendMessageResponse::class.java, req)

  fun sendVoice(req: SendVoiceRequest)
    = doRequest("sendVoice", SendMessageResponse::class.java, req)

  fun sendLocation(req: SendLocationRequest)
    = doRequest("sendLocation", SendMessageResponse::class.java, req)

  fun sendVenue(req: SendVenueRequest)
    = doRequest("sendVenue", SendMessageResponse::class.java, req)

  fun sendContact(req: SendContactRequest)
    = doRequest("sendContact", SendMessageResponse::class.java, req)

  fun sendChatAction(req: SendChatActionRequest)
    = doRequest("sendChatAction", SendMessageResponse::class.java, req)

  fun getUserProfilePhotos(req: GetUserProfilePhotosRequest)
    = doRequest("getUserProfilePhotos", UserProfilePhotos::class.java, req)

  fun getFile(req: GetFileRequest)
    = doRequest("getFile", TelegramFile::class.java, req)

  fun answerCallbackQuery(req: AnswerCallbackQueryRequest)
    = doRequest("answerCallbackQuery", Boolean::class.java, req)

  fun editMessageCaption(req: EditMessageCaptionRequest)
    = doRequest("editMessageCaption", SendMessageResponse::class.java, req)

  fun editMessageText(req: EditMessageTextRequest)
    = doRequest("editMessageCaption", SendMessageResponse::class.java, req)

  fun editMessageReplyMarkup(req: EditMessageReplyMarkupRequest)
    = doRequest("editMessageReplyMarkup", SendMessageResponse::class.java, req)

  fun answerInlineQuery(req: AnswerCallbackQueryRequest)
    = doRequest("answerInlineQuery", Boolean::class.java, req)

  fun setWebhook(req: SetWebhookRequest)
    = doRequest("setWebhook", TelegramResponse::class.java, req)

  fun getUpdates(req: GetUpdatesRequest)
    = doRequest("getUpdates", Array<Update>::class.java, req)
}

