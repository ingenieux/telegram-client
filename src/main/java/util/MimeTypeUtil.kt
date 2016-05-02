package io.ingenieux.telegram.util

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.AutoDetectParser
import java.io.BufferedInputStream
import java.io.File
import java.io.InputStream

object MimeTypeUtil {
  fun guessMimeType(file: File) =
    guessMimeType(file.name, BufferedInputStream(file.inputStream()))

  fun guessMimeType(fileName: String, fileContent: ByteArray) =
    guessMimeType(fileName, fileContent.inputStream())

  fun guessMimeType(fileName: String, inputStream: InputStream): String {
    val parser = AutoDetectParser()
    val detector = parser.detector

    val metadata = Metadata()

    metadata.add(Metadata.RESOURCE_NAME_KEY, fileName)

    val mediaType = detector.detect(inputStream, metadata)

    return mediaType.toString()
  }
}
