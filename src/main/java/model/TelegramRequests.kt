package io.ingenieux.telegram.model


import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


/** Use this method to receive incoming updates using long polling (wiki). An Array<Update> objects is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class GetUpdatesRequest @JsonCreator constructor(
  /** Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id. The negative offset can be specified to retrieve updates starting from -offset update from the end of the updates queue. All previous updates will forgotten. **/
  @param:JsonProperty("offset") @get:JsonProperty("offset")
  var offset: Int? = null
  ,
  /** Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100. **/
  @param:JsonProperty("limit") @get:JsonProperty("limit")
  var limit: Int? = null)


/** Use this method to send text messages. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendMessageRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Text of the message to be sent **/
  @param:JsonProperty("text") @get:JsonProperty("text")
  var text: String
  ,
  /** Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message. **/
  @param:JsonProperty("parse_mode") @get:JsonProperty("parse_mode")
  var parseMode: String? = null
  ,
  /** Disables link previews for links in this message **/
  @param:JsonProperty("disable_web_page_preview") @get:JsonProperty("disable_web_page_preview")
  var disableWebPagePreview: Boolean? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
)


/** Use this method to forward messages of any kind. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class ForwardMessageRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername) **/
  @param:JsonProperty("from_chat_id") @get:JsonProperty("from_chat_id")
  var fromChatId: String
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
)


/** Use this method to send photos. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendPhotoRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Photo to send. You can either pass a file_id as String to resend a photo that is already on the Telegram servers, or upload a new photo using multipart/form-data. **/
  @param:JsonProperty("photo") @get:JsonProperty("photo")
  var photo: InputFile
  ,
  /** Photo caption (may also be used when resending photos by file_id), 0-200 characters **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  var caption: String? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
) : HasInputFile


/** Use this method to send general files. On success, the sent Message is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendDocumentRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** File to send. You can either pass a file_id as String to resend a file that is already on the Telegram servers, or upload a new file using multipart/form-data. **/
  @param:JsonProperty("document") @get:JsonProperty("document")
  var document: InputFile
  ,
  /** Document caption (may also be used when resending documents by file_id), 0-200 characters **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  var caption: String? = null
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


/** Use this method to send .webp stickers. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendStickerRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Sticker to send. You can either pass a file_id as String to resend a sticker that is already on the Telegram servers, or upload a new sticker using multipart/form-data. **/
  @param:JsonProperty("sticker") @get:JsonProperty("sticker")
  var sticker: InputFile
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
) : HasInputFile


/** Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document). On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendVideoRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Video to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, or upload a new video file using multipart/form-data. **/
  @param:JsonProperty("video") @get:JsonProperty("video")
  var video: InputFile
  ,
  /** Duration of sent video in seconds **/
  @param:JsonProperty("duration") @get:JsonProperty("duration")
  var duration: Int? = null
  ,
  /** Video width **/
  @param:JsonProperty("width") @get:JsonProperty("width")
  var width: Int? = null
  ,
  /** Video height **/
  @param:JsonProperty("height") @get:JsonProperty("height")
  var height: Int? = null
  ,
  /** Video caption (may also be used when resending videos by file_id), 0-200 characters **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  var caption: String? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
) : HasInputFile


/** Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Audio or Document). On success, the sent Message is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendVoiceRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Audio file to send. You can either pass a file_id as String to resend an audio that is already on the Telegram servers, or upload a new audio file using multipart/form-data. **/
  @param:JsonProperty("voice") @get:JsonProperty("voice")
  var voice: InputFile
  ,
  /** Duration of sent audio in seconds **/
  @param:JsonProperty("duration") @get:JsonProperty("duration")
  var duration: Int? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
) : HasInputFile


/** Use this method to send point on the map. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendLocationRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Latitude of location **/
  @param:JsonProperty("latitude") @get:JsonProperty("latitude")
  var latitude: Float
  ,
  /** Longitude of location **/
  @param:JsonProperty("longitude") @get:JsonProperty("longitude")
  var longitude: Float
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
)


/** Use this method to send information about a venue. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendVenueRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Latitude of the venue **/
  @param:JsonProperty("latitude") @get:JsonProperty("latitude")
  var latitude: Float
  ,
  /** Longitude of the venue **/
  @param:JsonProperty("longitude") @get:JsonProperty("longitude")
  var longitude: Float
  ,
  /** Name of the venue **/
  @param:JsonProperty("title") @get:JsonProperty("title")
  var title: String
  ,
  /** Address of the venue **/
  @param:JsonProperty("address") @get:JsonProperty("address")
  var address: String
  ,
  /** Foursquare identifier of the venue **/
  @param:JsonProperty("foursquare_id") @get:JsonProperty("foursquare_id")
  var foursquareId: String? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
)


/** Use this method to send phone contacts. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class SendContactRequest @JsonCreator constructor(
  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
  ,
  /** Contact's phone number **/
  @param:JsonProperty("phone_number") @get:JsonProperty("phone_number")
  var phoneNumber: String
  ,
  /** Contact's first name **/
  @param:JsonProperty("first_name") @get:JsonProperty("first_name")
  var firstName: String
  ,
  /** Contact's last name **/
  @param:JsonProperty("last_name") @get:JsonProperty("last_name")
  var lastName: String? = null
  ,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  var disableNotification: Boolean? = null
  ,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  var replyToMessageId: Int? = null
  ,
  @param:JsonProperty("reply_markup") @get:com.fasterxml.jackson.annotation.JsonProperty("reply_markup")
  var replyMarkup: ReplyMarkup? = null
)


/** Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class GetUserProfilePhotosRequest @JsonCreator constructor(
  /** Unique identifier of the target user **/
  @param:JsonProperty("user_id") @get:JsonProperty("user_id")
  var userId: Int
  ,
  /** Sequential number of the first photo to be returned. By default, all photos are returned. **/
  @param:JsonProperty("offset") @get:JsonProperty("offset")
  var offset: Int? = null)


/** Use this method to unban a previously kicked user in a supergroup. The user will not return to the group automatically, but will be able to join via link, etc. The bot must be an administrator in the group for this to work. Returns Boolean on success. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class UnbanChatMemberRequest @JsonCreator constructor(
  /** Unique identifier for the target group or username of the target supergroup (in the format @supergroupusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String
)


/** Use this method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class AnswerCallbackQueryRequest @JsonCreator constructor(
  /** Unique identifier for the query to be answered **/
  @param:JsonProperty("callback_query_id") @get:JsonProperty("callback_query_id")
  var callbackQueryId: String
  ,
  /** Text of the notification. If not specified, nothing will be shown to the user **/
  @param:JsonProperty("text") @get:JsonProperty("text")
  var text: String? = null
)


/** Use this method to edit text messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class EditMessageTextRequest @JsonCreator constructor(
  /** Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String? = null
  ,
  /** Required if inline_message_id is not specified. Unique identifier of the sent message **/
  @param:JsonProperty("message_id") @get:JsonProperty("message_id")
  var messageId: Int? = null
  ,
  /** Required if chat_id and message_id are not specified. Identifier of the inline message **/
  @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
  var inlineMessageId: String? = null
  ,
  /** New text of the message **/
  @param:JsonProperty("text") @get:JsonProperty("text")
  var text: String
  ,
  /** Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message. **/
  @param:JsonProperty("parse_mode") @get:JsonProperty("parse_mode")
  var parseMode: String? = null
  ,
  /** Disables link previews for links in this message **/
  @param:JsonProperty("disable_web_page_preview") @get:JsonProperty("disable_web_page_preview")
  var disableWebPagePreview: Boolean? = null)


/** Use this method to edit captions of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class EditMessageCaptionRequest @JsonCreator constructor(
  /** Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String? = null
  ,
  /** Required if inline_message_id is not specified. Unique identifier of the sent message **/
  @param:JsonProperty("message_id") @get:JsonProperty("message_id")
  var messageId: Int? = null
  ,
  /** Required if chat_id and message_id are not specified. Identifier of the inline message **/
  @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
  var inlineMessageId: String? = null
  ,
  /** New caption of the message **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  var caption: String?)


/** Use this method to edit only the reply markup of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class EditMessageReplyMarkupRequest @JsonCreator constructor(
  /** Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  var chatId: String? = null
  ,
  /** Required if inline_message_id is not specified. Unique identifier of the sent message **/
  @param:JsonProperty("message_id") @get:JsonProperty("message_id")
  var messageId: Int? = null
  ,
  /** Required if chat_id and message_id are not specified. Identifier of the inline message **/
  @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
  var inlineMessageId: String? = null)


/** Use this method to send answers to an inline query. On success, Boolean is returned. No more than 50 results per query are allowed. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class AnswerInlineQueryRequest @JsonCreator constructor(
  /** Unique identifier for the answered query **/
  @param:JsonProperty("inline_query_id") @get:JsonProperty("inline_query_id")
  var inlineQueryId: String
  ,
  /** A JSON-serialized array of results for the inline query **/
  @param:JsonProperty("results") @get:JsonProperty("results")
  var results: Array<InlineQueryResult>
  ,
  /** The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300. **/
  @param:JsonProperty("cache_time") @get:JsonProperty("cache_time")
  var cacheTime: Int? = null
  ,
  /** Pass Boolean, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query **/
  @param:JsonProperty("is_personal") @get:JsonProperty("is_personal")
  var isPersonal: Boolean? = null
  ,
  /** Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don‘t support pagination. Offset length can’t exceed 64 bytes. **/
  @param:JsonProperty("next_offset") @get:JsonProperty("next_offset")
  var nextOffset: String? = null
  ,
  /** If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter switch_pm_parameter **/
  @param:JsonProperty("switch_pm_text") @get:JsonProperty("switch_pm_text")
  var switchPmText: String? = null
)
