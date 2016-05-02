package io.ingenieux.telegram.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.ingenieux.telegram.util.MimeTypeUtil
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.AutoDetectParser
import java.io.ByteArrayInputStream
import java.io.File

data class InlineKeyboardMarkup @JsonCreator constructor(
  @param:JsonProperty("inline_keyboard") @get:JsonProperty("inline_keyboard")
  val inlineKeyboard: Array<Array<InlineKeyboardButton>>
)

/** Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile again. **/
@JsonIgnoreProperties(ignoreUnknown = true)
data class GetFileRequest @JsonCreator constructor(
  @param:JsonProperty("file_id") @get:com.fasterxml.jackson.annotation.JsonProperty("file_id")
  val fileId: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
interface InputMessageContent {}

@JsonIgnoreProperties(ignoreUnknown = true)
interface ReplyMarkup {}

@JsonIgnoreProperties(ignoreUnknown = true)
interface InlineQueryResult {}

/**
 * Tag Interface for Methods Containing Files
 */
interface HasInputFile {}

@JsonIgnoreProperties(ignoreUnknown = true)
class InputFile private constructor(
  val fileId: String?,
  val fileName: String?,
  val contentType: String?,
  val fileContent: ByteArray?,
  val file: File?
) {
  fun appendTo(fieldName: String, builder: MultipartEntityBuilder) {
    if (null != fileId) {
      builder.addTextBody(fieldName, fileId)
    } else if (null != file) {
      builder.addBinaryBody(fieldName, file, ContentType.parse(contentType), fileName)
    } else {
      builder.addBinaryBody(fieldName, fileContent, ContentType.parse(contentType), fileName)
    }
  }
  
  companion object Factory {
    fun build(fileId: String) = InputFile(fileId, null, null, null, null)

    fun build(fileName: String, contentType: String, fileContent: ByteArray) =
      InputFile(null, fileName, contentType, fileContent, null)

    fun build(fileName: String, fileContent: ByteArray) =
      InputFile(null, fileName, MimeTypeUtil.guessMimeType(fileName, fileContent), fileContent, null)

    fun build(file: File): InputFile {
      val mimeType = MimeTypeUtil.guessMimeType(file)

      return InputFile(null, file.name, mimeType, null, file)
    }
  }
}

