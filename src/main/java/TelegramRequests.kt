package io.ingenieux.telegram.model



import com.fasterxml.jackson.annotation.JsonCreator


import com.fasterxml.jackson.annotation.JsonIgnoreProperties


import com.fasterxml.jackson.annotation.JsonProperty


import com.fasterxml.jackson.databind.annotation.JsonDeserialize


import java.util.*



/** Use this method to receive incoming updates using long polling (wiki). An Array<Update> objects is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class GetUpdatesRequest @JsonCreator constructor(  /** Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id. The negative offset can be specified to retrieve updates starting from -offset update from the end of the updates queue. All previous updates will forgotten. **/
  @param:JsonProperty("offset") @get:JsonProperty("offset")
  val offset: Int?
,
  /** Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100. **/
  @param:JsonProperty("limit") @get:JsonProperty("limit")
  val limit: Int?)


/** Use this method to send text messages. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendMessageRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Text of the message to be sent **/
  @param:JsonProperty("text") @get:JsonProperty("text")
  val text: String
,
  /** Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message. **/
  @param:JsonProperty("parse_mode") @get:JsonProperty("parse_mode")
  val parseMode: String?
,
  /** Disables link previews for links in this message **/
  @param:JsonProperty("disable_web_page_preview") @get:JsonProperty("disable_web_page_preview")
  val disableWebPagePreview: Boolean?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to forward messages of any kind. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class ForwardMessageRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername) **/
  @param:JsonProperty("from_chat_id") @get:JsonProperty("from_chat_id")
  val fromChatId: String
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?)


/** Use this method to send photos. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendPhotoRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Photo to send. You can either pass a file_id as String to resend a photo that is already on the Telegram servers, or upload a new photo using multipart/form-data. **/
  @param:JsonProperty("photo") @get:JsonProperty("photo")
  val photo: String
,
  /** Photo caption (may also be used when resending photos by file_id), 0-200 characters **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  val caption: String?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send general files. On success, the sent Message is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendDocumentRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** File to send. You can either pass a file_id as String to resend a file that is already on the Telegram servers, or upload a new file using multipart/form-data. **/
  @param:JsonProperty("document") @get:JsonProperty("document")
  val document: String
,
  /** Document caption (may also be used when resending documents by file_id), 0-200 characters **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  val caption: String?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send .webp stickers. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendStickerRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Sticker to send. You can either pass a file_id as String to resend a sticker that is already on the Telegram servers, or upload a new sticker using multipart/form-data. **/
  @param:JsonProperty("sticker") @get:JsonProperty("sticker")
  val sticker: String
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document). On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendVideoRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Video to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, or upload a new video file using multipart/form-data. **/
  @param:JsonProperty("video") @get:JsonProperty("video")
  val video: String
,
  /** Duration of sent video in seconds **/
  @param:JsonProperty("duration") @get:JsonProperty("duration")
  val duration: Int?
,
  /** Video width **/
  @param:JsonProperty("width") @get:JsonProperty("width")
  val width: Int?
,
  /** Video height **/
  @param:JsonProperty("height") @get:JsonProperty("height")
  val height: Int?
,
  /** Video caption (may also be used when resending videos by file_id), 0-200 characters **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  val caption: String?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Audio or Document). On success, the sent Message is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendVoiceRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Audio file to send. You can either pass a file_id as String to resend an audio that is already on the Telegram servers, or upload a new audio file using multipart/form-data. **/
  @param:JsonProperty("voice") @get:JsonProperty("voice")
  val voice: String
,
  /** Duration of sent audio in seconds **/
  @param:JsonProperty("duration") @get:JsonProperty("duration")
  val duration: Int?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send point on the map. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendLocationRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Latitude of location **/
  @param:JsonProperty("latitude") @get:JsonProperty("latitude")
  val latitude: Float
,
  /** Longitude of location **/
  @param:JsonProperty("longitude") @get:JsonProperty("longitude")
  val longitude: Float
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send information about a venue. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendVenueRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Latitude of the venue **/
  @param:JsonProperty("latitude") @get:JsonProperty("latitude")
  val latitude: Float
,
  /** Longitude of the venue **/
  @param:JsonProperty("longitude") @get:JsonProperty("longitude")
  val longitude: Float
,
  /** Name of the venue **/
  @param:JsonProperty("title") @get:JsonProperty("title")
  val title: String
,
  /** Address of the venue **/
  @param:JsonProperty("address") @get:JsonProperty("address")
  val address: String
,
  /** Foursquare identifier of the venue **/
  @param:JsonProperty("foursquare_id") @get:JsonProperty("foursquare_id")
  val foursquareId: String?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to send phone contacts. On success, the sent Message is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class SendContactRequest @JsonCreator constructor(  /** Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Contact's phone number **/
  @param:JsonProperty("phone_number") @get:JsonProperty("phone_number")
  val phoneNumber: String
,
  /** Contact's first name **/
  @param:JsonProperty("first_name") @get:JsonProperty("first_name")
  val firstName: String
,
  /** Contact's last name **/
  @param:JsonProperty("last_name") @get:JsonProperty("last_name")
  val lastName: String?
,
  /** Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound. **/
  @param:JsonProperty("disable_notification") @get:JsonProperty("disable_notification")
  val disableNotification: Boolean?
,
  /** If the message is a reply, ID of the original message **/
  @param:JsonProperty("reply_to_message_id") @get:JsonProperty("reply_to_message_id")
  val replyToMessageId: Int?)


/** Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class GetUserProfilePhotosRequest @JsonCreator constructor(  /** Unique identifier of the target user **/
  @param:JsonProperty("user_id") @get:JsonProperty("user_id")
  val userId: Int
,
  /** Sequential number of the first photo to be returned. By default, all photos are returned. **/
  @param:JsonProperty("offset") @get:JsonProperty("offset")
  val offset: Int?)


/** Use this method to unban a previously kicked user in a supergroup. The user will not return to the group automatically, but will be able to join via link, etc. The bot must be an administrator in the group for this to work. Returns Boolean on success. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class UnbanChatMemberRequest @JsonCreator constructor(  /** Unique identifier for the target group or username of the target supergroup (in the format @supergroupusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String)


/** Use this method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class AnswerCallbackQueryRequest @JsonCreator constructor(  /** Unique identifier for the query to be answered **/
  @param:JsonProperty("callback_query_id") @get:JsonProperty("callback_query_id")
  val callbackQueryId: String
,
  /** Text of the notification. If not specified, nothing will be shown to the user **/
  @param:JsonProperty("text") @get:JsonProperty("text")
  val text: String?)


/** Use this method to edit text messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class EditMessageTextRequest @JsonCreator constructor(  /** Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Required if inline_message_id is not specified. Unique identifier of the sent message **/
  @param:JsonProperty("message_id") @get:JsonProperty("message_id")
  val messageId: Int
,
  /** Required if chat_id and message_id are not specified. Identifier of the inline message **/
  @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
  val inlineMessageId: String
,
  /** New text of the message **/
  @param:JsonProperty("text") @get:JsonProperty("text")
  val text: String
,
  /** Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message. **/
  @param:JsonProperty("parse_mode") @get:JsonProperty("parse_mode")
  val parseMode: String?
,
  /** Disables link previews for links in this message **/
  @param:JsonProperty("disable_web_page_preview") @get:JsonProperty("disable_web_page_preview")
  val disableWebPagePreview: Boolean?)


/** Use this method to edit captions of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class EditMessageCaptionRequest @JsonCreator constructor(  /** Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Required if inline_message_id is not specified. Unique identifier of the sent message **/
  @param:JsonProperty("message_id") @get:JsonProperty("message_id")
  val messageId: Int
,
  /** Required if chat_id and message_id are not specified. Identifier of the inline message **/
  @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
  val inlineMessageId: String
,
  /** New caption of the message **/
  @param:JsonProperty("caption") @get:JsonProperty("caption")
  val caption: String?)


/** Use this method to edit only the reply markup of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise Boolean is returned. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class EditMessageReplyMarkupRequest @JsonCreator constructor(  /** Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername) **/
  @param:JsonProperty("chat_id") @get:JsonProperty("chat_id")
  val chatId: String
,
  /** Required if inline_message_id is not specified. Unique identifier of the sent message **/
  @param:JsonProperty("message_id") @get:JsonProperty("message_id")
  val messageId: Int
,
  /** Required if chat_id and message_id are not specified. Identifier of the inline message **/
  @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
  val inlineMessageId: String)


/** Use this method to send answers to an inline query. On success, Boolean is returned. No more than 50 results per query are allowed. **/
@JsonIgnoreProperties(ignoreUnknown=true)
data class AnswerInlineQueryRequest @JsonCreator constructor(  /** Unique identifier for the answered query **/
  @param:JsonProperty("inline_query_id") @get:JsonProperty("inline_query_id")
  val inlineQueryId: String
,
  /** A JSON-serialized array of results for the inline query **/
  @param:JsonProperty("results") @get:JsonProperty("results")
  val results: Array<InlineQueryResult>
,
  /** The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300. **/
  @param:JsonProperty("cache_time") @get:JsonProperty("cache_time")
  val cacheTime: Int?
,
  /** Pass Boolean, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query **/
  @param:JsonProperty("is_personal") @get:JsonProperty("is_personal")
  val isPersonal: Boolean?
,
  /** Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don‘t support pagination. Offset length can’t exceed 64 bytes. **/
  @param:JsonProperty("next_offset") @get:JsonProperty("next_offset")
  val nextOffset: String?
,
  /** If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter switch_pm_parameter **/
  @param:JsonProperty("switch_pm_text") @get:JsonProperty("switch_pm_text")
  val switchPmText: String?)