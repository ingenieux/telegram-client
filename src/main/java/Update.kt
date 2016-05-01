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

@JsonIgnoreProperties(ignoreUnknown = true)
interface InputMessageContent {}

// Generated output starts below

/** This object represents an incoming update. Only one of the optional parameters can be present in any given update. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Update @JsonCreator constructor(
        /** The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. **/
        @param:JsonProperty("update_id") @get:JsonProperty("update_id")
        val updateId: Int
        ,
        /** Optional. New incoming message of any kind — text, photo, sticker, etc. **/
        @param:JsonProperty("message") @get:JsonProperty("message")
        val message: Message?
        ,
        /** Optional. New incoming inline query **/
        @param:JsonProperty("inline_query") @get:JsonProperty("inline_query")
        val inlineQuery: InlineQuery?
        ,
        /** Optional. The result of an inline query that was chosen by a user and sent to their chat partner. **/
        @param:JsonProperty("chosen_inline_result") @get:JsonProperty("chosen_inline_result")
        val chosenInlineResult: ChosenInlineResult?)


/** This object represents a Telegram user or bot. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class User @JsonCreator constructor(
        /** Unique identifier for this user or bot **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: Int
        ,
        /** User‘s or bot’s first name **/
        @param:JsonProperty("first_name") @get:JsonProperty("first_name")
        val firstName: String
        ,
        /** Optional. User‘s or bot’s last name **/
        @param:JsonProperty("last_name") @get:JsonProperty("last_name")
        val lastName: String?)


/** This object represents a chat. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Chat @JsonCreator constructor(
        /** Unique identifier for this chat, not exceeding 1e13 by absolute value **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: Int
        ,
        /** Type of chat, can be either “private”, “group”, “supergroup” or “channel” **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Optional. Title, for channels and group chats **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Username, for private chats and channels if available **/
        @param:JsonProperty("username") @get:JsonProperty("username")
        val username: String?
        ,
        /** Optional. First name of the other party in a private chat **/
        @param:JsonProperty("first_name") @get:JsonProperty("first_name")
        val firstName: String?)


/** This object represents a message. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Message @JsonCreator constructor(
        /** Unique message identifier **/
        @param:JsonProperty("message_id") @get:JsonProperty("message_id")
        val messageId: Int
        ,
        /** Optional. Sender, can be empty for messages sent to channels **/
        @param:JsonProperty("from") @get:JsonProperty("from")
        val from: User?
        ,
        /** Date the message was sent in Unix time **/
        @param:JsonProperty("date") @get:JsonProperty("date")
        @param:JsonDeserialize(using = UnixTimestampAsStringDeserializer::class)
        val date: Date
        ,
        /** Conversation the message belongs to **/
        @param:JsonProperty("chat") @get:JsonProperty("chat")
        val chat: Chat
        ,
        /** Optional. For forwarded messages, sender of the original message **/
        @param:JsonProperty("forward_from") @get:JsonProperty("forward_from")
        val forwardFrom: User?
        ,
        /** Optional. For forwarded messages, date the original message was sent in Unix time **/
        @param:JsonProperty("forward_date") @get:JsonProperty("forward_date")
        @param:JsonDeserialize(using = UnixTimestampAsStringDeserializer::class)
        val forwardDate: Date?
        ,
        /** Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply. **/
        @param:JsonProperty("reply_to_message") @get:JsonProperty("reply_to_message")
        val replyToMessage: Message?
        ,
        /** Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters. **/
        @param:JsonProperty("text") @get:JsonProperty("text")
        val text: String?
        ,
        /** Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text **/
        @param:JsonProperty("entities") @get:JsonProperty("entities")
        val entities: Array<MessageEntity>?
        ,
        /** Optional. Message is an audio file, information about the file **/
        @param:JsonProperty("audio") @get:JsonProperty("audio")
        val audio: Audio?
        ,
        /** Optional. Message is a general file, information about the file **/
        @param:JsonProperty("document") @get:JsonProperty("document")
        val document: Document?
        ,
        /** Optional. Message is a photo, available sizes of the photo **/
        @param:JsonProperty("photo") @get:JsonProperty("photo")
        val photo: Array<PhotoSize>?
        ,
        /** Optional. Message is a sticker, information about the sticker **/
        @param:JsonProperty("sticker") @get:JsonProperty("sticker")
        val sticker: Sticker?
        ,
        /** Optional. Message is a video, information about the video **/
        @param:JsonProperty("video") @get:JsonProperty("video")
        val video: Video?
        ,
        /** Optional. Message is a voice message, information about the file **/
        @param:JsonProperty("voice") @get:JsonProperty("voice")
        val voice: Voice?
        ,
        /** Optional. Caption for the document, photo or video, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. Message is a shared contact, information about the contact **/
        @param:JsonProperty("contact") @get:JsonProperty("contact")
        val contact: Contact?
        ,
        /** Optional. Message is a shared location, information about the location **/
        @param:JsonProperty("location") @get:JsonProperty("location")
        val location: Location?
        ,
        /** Optional. Message is a venue, information about the venue **/
        @param:JsonProperty("venue") @get:JsonProperty("venue")
        val venue: Venue?
        ,
        /** Optional. A new member was added to the group, information about them (this member may be the bot itself) **/
        @param:JsonProperty("new_chat_member") @get:JsonProperty("new_chat_member")
        val newChatMember: User?
        ,
        /** Optional. A member was removed from the group, information about them (this member may be the bot itself) **/
        @param:JsonProperty("left_chat_member") @get:JsonProperty("left_chat_member")
        val leftChatMember: User?
        ,
        /** Optional. A chat title was changed to this value **/
        @param:JsonProperty("new_chat_title") @get:JsonProperty("new_chat_title")
        val newChatTitle: String?
        ,
        /** Optional. A chat photo was change to this value **/
        @param:JsonProperty("new_chat_photo") @get:JsonProperty("new_chat_photo")
        val newChatPhoto: Array<PhotoSize>?
        ,
        /** Optional. Service message: the chat photo was deleted **/
        @param:JsonProperty("delete_chat_photo") @get:JsonProperty("delete_chat_photo")
        val deleteChatPhoto: Boolean?
        ,
        /** Optional. Service message: the group has been created **/
        @param:JsonProperty("group_chat_created") @get:JsonProperty("group_chat_created")
        val groupChatCreated: Boolean?
        ,
        /** Optional. Service message: the supergroup has been created **/
        @param:JsonProperty("supergroup_chat_created") @get:JsonProperty("supergroup_chat_created")
        val supergroupChatCreated: Boolean?
        ,
        /** Optional. Service message: the channel has been created **/
        @param:JsonProperty("channel_chat_created") @get:JsonProperty("channel_chat_created")
        val channelChatCreated: Boolean?
        ,
        /** Optional. The group has been migrated to a supergroup with the specified identifier, not exceeding 1e13 by absolute value **/
        @param:JsonProperty("migrate_to_chat_id") @get:JsonProperty("migrate_to_chat_id")
        val migrateToChatId: Int?
        ,
        /** Optional. The supergroup has been migrated from a group with the specified identifier, not exceeding 1e13 by absolute value **/
        @param:JsonProperty("migrate_from_chat_id") @get:JsonProperty("migrate_from_chat_id")
        val migrateFromChatId: Int?)


/** This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class MessageEntity @JsonCreator constructor(
        /** Type of the entity. One of mention (@username), hashtag, bot_command, url, email, bold (bold text), italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs) **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Offset in UTF-16 code units to the start of the entity **/
        @param:JsonProperty("offset") @get:JsonProperty("offset")
        val offset: Int
        ,
        /** Length of the entity in UTF-16 code units **/
        @param:JsonProperty("length") @get:JsonProperty("length")
        val length: Int)


/** This object represents one size of a photo or a file / sticker thumbnail. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class PhotoSize @JsonCreator constructor(
        /** Unique identifier for this file **/
        @param:JsonProperty("file_id") @get:JsonProperty("file_id")
        val fileId: String
        ,
        /** Photo width **/
        @param:JsonProperty("width") @get:JsonProperty("width")
        val width: Int
        ,
        /** Photo height **/
        @param:JsonProperty("height") @get:JsonProperty("height")
        val height: Int)


/** This object represents an audio file to be treated as music by the Telegram clients. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Audio @JsonCreator constructor(
        /** Unique identifier for this file **/
        @param:JsonProperty("file_id") @get:JsonProperty("file_id")
        val fileId: String
        ,
        /** Duration of the audio in seconds as defined by sender **/
        @param:JsonProperty("duration") @get:JsonProperty("duration")
        val duration: Int
        ,
        /** Optional. Performer of the audio as defined by sender or by audio tags **/
        @param:JsonProperty("performer") @get:JsonProperty("performer")
        val performer: String?
        ,
        /** Optional. Title of the audio as defined by sender or by audio tags **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. MIME type of the file as defined by sender **/
        @param:JsonProperty("mime_type") @get:JsonProperty("mime_type")
        val mimeType: String?)


/** This object represents a general file (as opposed to photos, voice messages and audio files). **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Document @JsonCreator constructor(
        /** Unique file identifier **/
        @param:JsonProperty("file_id") @get:JsonProperty("file_id")
        val fileId: String
        ,
        /** Optional. Document thumbnail as defined by sender **/
        @param:JsonProperty("thumb") @get:JsonProperty("thumb")
        val thumb: PhotoSize?
        ,
        /** Optional. Original filename as defined by sender **/
        @param:JsonProperty("file_name") @get:JsonProperty("file_name")
        val fileName: String?
        ,
        /** Optional. MIME type of the file as defined by sender **/
        @param:JsonProperty("mime_type") @get:JsonProperty("mime_type")
        val mimeType: String?)


/** This object represents a sticker. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Sticker @JsonCreator constructor(
        /** Unique identifier for this file **/
        @param:JsonProperty("file_id") @get:JsonProperty("file_id")
        val fileId: String
        ,
        /** Sticker width **/
        @param:JsonProperty("width") @get:JsonProperty("width")
        val width: Int
        ,
        /** Sticker height **/
        @param:JsonProperty("height") @get:JsonProperty("height")
        val height: Int
        ,
        /** Optional. Sticker thumbnail in .webp or .jpg format **/
        @param:JsonProperty("thumb") @get:JsonProperty("thumb")
        val thumb: PhotoSize?)


/** This object represents a video file. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Video @JsonCreator constructor(
        /** Unique identifier for this file **/
        @param:JsonProperty("file_id") @get:JsonProperty("file_id")
        val fileId: String
        ,
        /** Video width as defined by sender **/
        @param:JsonProperty("width") @get:JsonProperty("width")
        val width: Int
        ,
        /** Video height as defined by sender **/
        @param:JsonProperty("height") @get:JsonProperty("height")
        val height: Int
        ,
        /** Duration of the video in seconds as defined by sender **/
        @param:JsonProperty("duration") @get:JsonProperty("duration")
        val duration: Int
        ,
        /** Optional. Video thumbnail **/
        @param:JsonProperty("thumb") @get:JsonProperty("thumb")
        val thumb: PhotoSize?
        ,
        /** Optional. Mime type of a file as defined by sender **/
        @param:JsonProperty("mime_type") @get:JsonProperty("mime_type")
        val mimeType: String?)


/** This object represents a voice note. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Voice @JsonCreator constructor(
        /** Unique identifier for this file **/
        @param:JsonProperty("file_id") @get:JsonProperty("file_id")
        val fileId: String
        ,
        /** Duration of the audio in seconds as defined by sender **/
        @param:JsonProperty("duration") @get:JsonProperty("duration")
        val duration: Int
        ,
        /** Optional. MIME type of the file as defined by sender **/
        @param:JsonProperty("mime_type") @get:JsonProperty("mime_type")
        val mimeType: String?)


/** This object represents a phone contact. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Contact @JsonCreator constructor(
        /** Contact's phone number **/
        @param:JsonProperty("phone_number") @get:JsonProperty("phone_number")
        val phoneNumber: String
        ,
        /** Contact's first name **/
        @param:JsonProperty("first_name") @get:JsonProperty("first_name")
        val firstName: String
        ,
        /** Optional. Contact's last name **/
        @param:JsonProperty("last_name") @get:JsonProperty("last_name")
        val lastName: String?)


/** This object represents a point on the map. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Location @JsonCreator constructor(
        /** Longitude as defined by sender **/
        @param:JsonProperty("longitude") @get:JsonProperty("longitude")
        val longitude: Float)


/** This object represents a venue. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class Venue @JsonCreator constructor(
        /** Venue location **/
        @param:JsonProperty("location") @get:JsonProperty("location")
        val location: Location
        ,
        /** Name of the venue **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Address of the venue **/
        @param:JsonProperty("address") @get:JsonProperty("address")
        val address: String)


/** This object represent a user's profile pictures. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserProfilePhotos @JsonCreator constructor(
        /** Total number of profile pictures the target user has **/
        @param:JsonProperty("total_count") @get:JsonProperty("total_count")
        val totalCount: Int)


/** This object represents a custom keyboard with reply options (see Introduction to bots for details and examples). **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReplyKeyboardMarkup @JsonCreator constructor(
        /** Array<button> rows, each represented by an Array<KeyboardButton> objects **/
        @param:JsonProperty("keyboard") @get:JsonProperty("keyboard")
        val keyboard: Array<Array<KeyboardButton>>
        ,
        /** Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the same height as the app's standard keyboard. **/
        @param:JsonProperty("resize_keyboard") @get:JsonProperty("resize_keyboard")
        val resizeKeyboard: Boolean?
        ,
        /** Optional. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to false. **/
        @param:JsonProperty("one_time_keyboard") @get:JsonProperty("one_time_keyboard")
        val oneTimeKeyboard: Boolean?)


/** This object represents one button of the reply keyboard. For simple text buttons String can be used instead of this object to specify text of the button. Optional fields are mutually exclusive. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class KeyboardButton @JsonCreator constructor(
        /** Text of the button. If none of the optional fields are used, it will be sent to the bot as a message when the button is pressed **/
        @param:JsonProperty("text") @get:JsonProperty("text")
        val text: String?
        ,
        /** Optional. If Boolean, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only **/
        @param:JsonProperty("request_contact") @get:JsonProperty("request_contact")
        val requestContact: Boolean?)


/** Upon receiving a message with this object, Telegram clients will hide the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see ReplyKeyboardMarkup). **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReplyKeyboardHide @JsonCreator constructor(
        /** Requests clients to hide the custom keyboard **/
        @param:JsonProperty("hide_keyboard") @get:JsonProperty("hide_keyboard")
        val hideKeyboard: Boolean)


/** This object represents one button of an inline keyboard. You must use exactly one of the optional fields. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineKeyboardButton @JsonCreator constructor(
        /** Label text on the button **/
        @param:JsonProperty("text") @get:JsonProperty("text")
        val text: String
        ,
        /** Optional. HTTP url to be opened when button is pressed **/
        @param:JsonProperty("url") @get:JsonProperty("url")
        val url: String?
        ,
        /** Optional. Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes **/
        @param:JsonProperty("callback_data") @get:JsonProperty("callback_data")
        val callbackData: String?)


/** This object represents an incoming callback query from a callback button in an inline keyboard. If the button that originated the query was attached to a message sent by the bot, the field message will be presented. If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be presented. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class CallbackQuery @JsonCreator constructor(
        /** Unique identifier for this query **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Sender **/
        @param:JsonProperty("from") @get:JsonProperty("from")
        val from: User
        ,
        /** Optional. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old **/
        @param:JsonProperty("message") @get:JsonProperty("message")
        val message: Message?
        ,
        /** Optional. Identifier of the message sent via the bot in inline mode, that originated the query **/
        @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
        val inlineMessageId: String?)


/** Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class ForceReply @JsonCreator constructor(
        /** Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply' **/
        @param:JsonProperty("force_reply") @get:JsonProperty("force_reply")
        val forceReply: Boolean)


/** This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQuery @JsonCreator constructor(
        /** Unique identifier for this query **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Sender **/
        @param:JsonProperty("from") @get:JsonProperty("from")
        val from: User
        ,
        /** Optional. Sender location, only for bots that request user location **/
        @param:JsonProperty("location") @get:JsonProperty("location")
        val location: Location?
        ,
        /** Text of the query **/
        @param:JsonProperty("query") @get:JsonProperty("query")
        val query: String)


/** Represents a link to an article or web page. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultArticle @JsonCreator constructor(
        /** Type of the result, must be article **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 Bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Title of the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Content of the message to be sent **/
        @param:JsonProperty("input_message_content") @get:JsonProperty("input_message_content")
        val inputMessageContent: InputMessageContent
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?
        ,
        /** Optional. URL of the result **/
        @param:JsonProperty("url") @get:JsonProperty("url")
        val url: String?
        ,
        /** Optional. Pass Boolean, if you don't want the URL to be shown in the message **/
        @param:JsonProperty("hide_url") @get:JsonProperty("hide_url")
        val hideUrl: Boolean?
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Url of the thumbnail for the result **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String?
        ,
        /** Optional. Thumbnail width **/
        @param:JsonProperty("thumb_width") @get:JsonProperty("thumb_width")
        val thumbWidth: Int?)


/** Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the photo. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultPhoto @JsonCreator constructor(
        /** Type of the result, must be photo **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid URL of the photo. Photo must be in jpeg format. Photo size must not exceed 5MB **/
        @param:JsonProperty("photo_url") @get:JsonProperty("photo_url")
        val photoUrl: String
        ,
        /** URL of the thumbnail for the photo **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String
        ,
        /** Optional. Width of the photo **/
        @param:JsonProperty("photo_width") @get:JsonProperty("photo_width")
        val photoWidth: Int?
        ,
        /** Optional. Height of the photo **/
        @param:JsonProperty("photo_height") @get:JsonProperty("photo_height")
        val photoHeight: Int?
        ,
        /** Optional. Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Caption of the photo to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the animation. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultGif @JsonCreator constructor(
        /** Type of the result, must be gif **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid URL for the GIF file. File size must not exceed 1MB **/
        @param:JsonProperty("gif_url") @get:JsonProperty("gif_url")
        val gifUrl: String
        ,
        /** Optional. Width of the GIF **/
        @param:JsonProperty("gif_width") @get:JsonProperty("gif_width")
        val gifWidth: Int?
        ,
        /** Optional. Height of the GIF **/
        @param:JsonProperty("gif_height") @get:JsonProperty("gif_height")
        val gifHeight: Int?
        ,
        /** URL of the static thumbnail for the result (jpeg or gif) **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String
        ,
        /** Optional. Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Caption of the GIF file to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the animation. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultMpeg4Gif @JsonCreator constructor(
        /** Type of the result, must be mpeg4_gif **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid URL for the MP4 file. File size must not exceed 1MB **/
        @param:JsonProperty("mpeg4_url") @get:JsonProperty("mpeg4_url")
        val mpeg4Url: String
        ,
        /** Optional. Video width **/
        @param:JsonProperty("mpeg4_width") @get:JsonProperty("mpeg4_width")
        val mpeg4Width: Int?
        ,
        /** Optional. Video height **/
        @param:JsonProperty("mpeg4_height") @get:JsonProperty("mpeg4_height")
        val mpeg4Height: Int?
        ,
        /** URL of the static thumbnail (jpeg or gif) for the result **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String
        ,
        /** Optional. Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Caption of the MPEG-4 file to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the video. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultVideo @JsonCreator constructor(
        /** Type of the result, must be video **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid URL for the embedded video player or video file **/
        @param:JsonProperty("video_url") @get:JsonProperty("video_url")
        val videoUrl: String
        ,
        /** Mime type of the content of video url, “text/html” or “video/mp4” **/
        @param:JsonProperty("mime_type") @get:JsonProperty("mime_type")
        val mimeType: String
        ,
        /** URL of the thumbnail (jpeg only) for the video **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String
        ,
        /** Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. Caption of the video to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. Video width **/
        @param:JsonProperty("video_width") @get:JsonProperty("video_width")
        val videoWidth: Int?
        ,
        /** Optional. Video height **/
        @param:JsonProperty("video_height") @get:JsonProperty("video_height")
        val videoHeight: Int?
        ,
        /** Optional. Video duration in seconds **/
        @param:JsonProperty("video_duration") @get:JsonProperty("video_duration")
        val videoDuration: Int?
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to an mp3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the audio. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultAudio @JsonCreator constructor(
        /** Type of the result, must be audio **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid URL for the audio file **/
        @param:JsonProperty("audio_url") @get:JsonProperty("audio_url")
        val audioUrl: String
        ,
        /** Title **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. Performer **/
        @param:JsonProperty("performer") @get:JsonProperty("performer")
        val performer: String?
        ,
        /** Optional. Audio duration in seconds **/
        @param:JsonProperty("audio_duration") @get:JsonProperty("audio_duration")
        val audioDuration: Int?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a voice recording in an .ogg container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the the voice message. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultVoice @JsonCreator constructor(
        /** Type of the result, must be voice **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid URL for the voice recording **/
        @param:JsonProperty("voice_url") @get:JsonProperty("voice_url")
        val voiceUrl: String
        ,
        /** Recording title **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. Recording duration in seconds **/
        @param:JsonProperty("voice_duration") @get:JsonProperty("voice_duration")
        val voiceDuration: Int?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the file. Currently, only .PDF and .ZIP files can be sent using this method. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultDocument @JsonCreator constructor(
        /** Type of the result, must be document **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. Caption of the document to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** A valid URL for the file **/
        @param:JsonProperty("document_url") @get:JsonProperty("document_url")
        val documentUrl: String
        ,
        /** Mime type of the content of the file, either “application/pdf” or “application/zip” **/
        @param:JsonProperty("mime_type") @get:JsonProperty("mime_type")
        val mimeType: String
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?
        ,
        /** Optional. Content of the message to be sent instead of the file **/
        @param:JsonProperty("input_message_content") @get:JsonProperty("input_message_content")
        val inputMessageContent: InputMessageContent?
        ,
        /** Optional. URL of the thumbnail (jpeg only) for the file **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String?
        ,
        /** Optional. Thumbnail width **/
        @param:JsonProperty("thumb_width") @get:JsonProperty("thumb_width")
        val thumbWidth: Int?)


/** Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the location. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultLocation @JsonCreator constructor(
        /** Type of the result, must be location **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 Bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Location latitude in degrees **/
        @param:JsonProperty("latitude") @get:JsonProperty("latitude")
        val latitude: Float
        ,
        /** Location longitude in degrees **/
        @param:JsonProperty("longitude") @get:JsonProperty("longitude")
        val longitude: Float
        ,
        /** Location title **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?
        ,
        /** Optional. Content of the message to be sent instead of the location **/
        @param:JsonProperty("input_message_content") @get:JsonProperty("input_message_content")
        val inputMessageContent: InputMessageContent?
        ,
        /** Optional. Url of the thumbnail for the result **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String?
        ,
        /** Optional. Thumbnail width **/
        @param:JsonProperty("thumb_width") @get:JsonProperty("thumb_width")
        val thumbWidth: Int?)


/** Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the venue. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultVenue @JsonCreator constructor(
        /** Type of the result, must be venue **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 Bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Latitude of the venue location in degrees **/
        @param:JsonProperty("latitude") @get:JsonProperty("latitude")
        val latitude: Float
        ,
        /** Longitude of the venue location in degrees **/
        @param:JsonProperty("longitude") @get:JsonProperty("longitude")
        val longitude: Float
        ,
        /** Title of the venue **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Address of the venue **/
        @param:JsonProperty("address") @get:JsonProperty("address")
        val address: String
        ,
        /** Optional. Foursquare identifier of the venue if known **/
        @param:JsonProperty("foursquare_id") @get:JsonProperty("foursquare_id")
        val foursquareId: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?
        ,
        /** Optional. Content of the message to be sent instead of the venue **/
        @param:JsonProperty("input_message_content") @get:JsonProperty("input_message_content")
        val inputMessageContent: InputMessageContent?
        ,
        /** Optional. Url of the thumbnail for the result **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String?
        ,
        /** Optional. Thumbnail width **/
        @param:JsonProperty("thumb_width") @get:JsonProperty("thumb_width")
        val thumbWidth: Int?)


/** Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the contact. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultContact @JsonCreator constructor(
        /** Type of the result, must be contact **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 Bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Contact's phone number **/
        @param:JsonProperty("phone_number") @get:JsonProperty("phone_number")
        val phoneNumber: String
        ,
        /** Contact's first name **/
        @param:JsonProperty("first_name") @get:JsonProperty("first_name")
        val firstName: String
        ,
        /** Optional. Contact's last name **/
        @param:JsonProperty("last_name") @get:JsonProperty("last_name")
        val lastName: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?
        ,
        /** Optional. Content of the message to be sent instead of the contact **/
        @param:JsonProperty("input_message_content") @get:JsonProperty("input_message_content")
        val inputMessageContent: InputMessageContent?
        ,
        /** Optional. Url of the thumbnail for the result **/
        @param:JsonProperty("thumb_url") @get:JsonProperty("thumb_url")
        val thumbUrl: String?
        ,
        /** Optional. Thumbnail width **/
        @param:JsonProperty("thumb_width") @get:JsonProperty("thumb_width")
        val thumbWidth: Int?)


/** Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the photo. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedPhoto @JsonCreator constructor(
        /** Type of the result, must be photo **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier of the photo **/
        @param:JsonProperty("photo_file_id") @get:JsonProperty("photo_file_id")
        val photoFileId: String
        ,
        /** Optional. Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Caption of the photo to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with specified content instead of the animation. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedGif @JsonCreator constructor(
        /** Type of the result, must be gif **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier for the GIF file **/
        @param:JsonProperty("gif_file_id") @get:JsonProperty("gif_file_id")
        val gifFileId: String
        ,
        /** Optional. Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Caption of the GIF file to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the animation. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedMpeg4Gif @JsonCreator constructor(
        /** Type of the result, must be mpeg4_gif **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier for the MP4 file **/
        @param:JsonProperty("mpeg4_file_id") @get:JsonProperty("mpeg4_file_id")
        val mpeg4FileId: String
        ,
        /** Optional. Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String?
        ,
        /** Optional. Caption of the MPEG-4 file to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the sticker. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedSticker @JsonCreator constructor(
        /** Type of the result, must be sticker **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier of the sticker **/
        @param:JsonProperty("sticker_file_id") @get:JsonProperty("sticker_file_id")
        val stickerFileId: String
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the file. Currently, only pdf-files and zip archives can be sent using this method. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedDocument @JsonCreator constructor(
        /** Type of the result, must be document **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** A valid file identifier for the file **/
        @param:JsonProperty("document_file_id") @get:JsonProperty("document_file_id")
        val documentFileId: String
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Caption of the document to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the video. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedVideo @JsonCreator constructor(
        /** Type of the result, must be video **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier for the video file **/
        @param:JsonProperty("video_file_id") @get:JsonProperty("video_file_id")
        val videoFileId: String
        ,
        /** Title for the result **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. Short description of the result **/
        @param:JsonProperty("description") @get:JsonProperty("description")
        val description: String?
        ,
        /** Optional. Caption of the video to be sent, 0-200 characters **/
        @param:JsonProperty("caption") @get:JsonProperty("caption")
        val caption: String?
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the voice message. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedVoice @JsonCreator constructor(
        /** Type of the result, must be voice **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier for the voice message **/
        @param:JsonProperty("voice_file_id") @get:JsonProperty("voice_file_id")
        val voiceFileId: String
        ,
        /** Voice message title **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents a link to an mp3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the audio. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InlineQueryResultCachedAudio @JsonCreator constructor(
        /** Type of the result, must be audio **/
        @param:JsonProperty("type") @get:JsonProperty("type")
        val type: String
        ,
        /** Unique identifier for this result, 1-64 bytes **/
        @param:JsonProperty("id") @get:JsonProperty("id")
        val id: String
        ,
        /** A valid file identifier for the audio file **/
        @param:JsonProperty("audio_file_id") @get:JsonProperty("audio_file_id")
        val audioFileId: String
        ,
        /** Optional. An Inline keyboard attached to the message **/
        @param:JsonProperty("reply_markup") @get:JsonProperty("reply_markup")
        val replyMarkup: InlineKeyboardMarkup?)


/** Represents the content of a text message to be sent as the result of an inline query. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InputTextMessageContent @JsonCreator constructor(
        /** Text of the message to be sent, 1-4096 characters **/
        @param:JsonProperty("message_text") @get:JsonProperty("message_text")
        val messageText: String
        ,
        /** Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message. **/
        @param:JsonProperty("parse_mode") @get:JsonProperty("parse_mode")
        val parseMode: String?) : InputMessageContent


/** Represents the content of a location message to be sent as the result of an inline query. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InputLocationMessageContent @JsonCreator constructor(
        /** Latitude of the location in degrees **/
        @param:JsonProperty("latitude") @get:JsonProperty("latitude")
        val latitude: Float) : InputMessageContent


/** Represents the content of a venue message to be sent as the result of an inline query. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InputVenueMessageContent @JsonCreator constructor(
        /** Latitude of the venue in degrees **/
        @param:JsonProperty("latitude") @get:JsonProperty("latitude")
        val latitude: Float
        ,
        /** Longitude of the venue in degrees **/
        @param:JsonProperty("longitude") @get:JsonProperty("longitude")
        val longitude: Float
        ,
        /** Name of the venue **/
        @param:JsonProperty("title") @get:JsonProperty("title")
        val title: String
        ,
        /** Address of the venue **/
        @param:JsonProperty("address") @get:JsonProperty("address")
        val address: String) : InputMessageContent


/** Represents the content of a contact message to be sent as the result of an inline query. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class InputContactMessageContent @JsonCreator constructor(
        /** Contact's phone number **/
        @param:JsonProperty("phone_number") @get:JsonProperty("phone_number")
        val phoneNumber: String
        ,
        /** Contact's first name **/
        @param:JsonProperty("first_name") @get:JsonProperty("first_name")
        val firstName: String) : InputMessageContent


/** Represents a result of an inline query that was chosen by the user and sent to their chat partner. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class ChosenInlineResult @JsonCreator constructor(
        /** The unique identifier for the result that was chosen **/
        @param:JsonProperty("result_id") @get:JsonProperty("result_id")
        val resultId: String
        ,
        /** The user that chose the result **/
        @param:JsonProperty("from") @get:JsonProperty("from")
        val from: User
        ,
        /** Optional. Sender location, only for bots that require user location **/
        @param:JsonProperty("location") @get:JsonProperty("location")
        val location: Location?
        ,
        /** Optional. Identifier of the sent inline message. Available only if there is an inline keyboard attached to the message. Will be also received in callback queries and can be used to edit the message. **/
        @param:JsonProperty("inline_message_id") @get:JsonProperty("inline_message_id")
        val inlineMessageId: String?)
