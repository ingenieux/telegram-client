package io.ingenieux.telegram

import com.fasterxml.jackson.annotation.JsonProperty
import io.ingenieux.telegram.model.HasInputFile
import io.ingenieux.telegram.model.InputFile
import io.ingenieux.telegram.model.TelegramResponse
import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.entity.mime.HttpMultipartMode
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import java.io.ByteArrayOutputStream
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.memberProperties

class TelegramBotClient(
  apiToken: String,
  val client: CloseableHttpClient = HttpClientBuilder.create().build()
) : AbstractTelegramClient(apiToken) {
  override fun <T> doRequest(methodName: String, responseClass: Class<T>, body: Any?): T {
    val methodUri = "${endpoint}/${methodName}"

    val hasBody = null == body

    val request = if (hasBody) {
      HttpGet(methodUri)
    } else {
      HttpPost(methodUri)
    }

    request.setHeader("Accept", "application/json")

    LOGGER.debug("Formatted request as {}", request)

    if (request is HttpPost) {
      request.entity = if (body is HasInputFile) {
        getBodyEntity(body)
      } else {
        request.setHeader("Content-Type", "application/json")

        val bodyAsString = MAPPER.writeValueAsString(body)

        StringEntity(bodyAsString)
      }

      LOGGER.trace("Formatted request body entity as {}", request.entity)
    }

    val result = client.execute(request)

    LOGGER.trace("result: ${result.statusLine.statusCode}")

    val baos = ByteArrayOutputStream()

    result.entity!!.writeTo(baos)

    val resultEntityAsString = baos.toString()

    LOGGER.trace("result entity: {}", resultEntityAsString)

    if (result.statusLine.statusCode != 200) {
      val responseEntity = MAPPER.readValue(resultEntityAsString, TelegramResponse::class.java)

      throw IllegalStateException("Error: ${responseEntity.description} (Status Code: ${result.statusLine.statusCode})")
    }

    val returnValue = MAPPER.readValue(resultEntityAsString, responseClass)

    return returnValue
  }

  fun getBodyEntity(body: Any): HttpEntity {
    val builder = MultipartEntityBuilder.create()
      .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)

    body.javaClass.kotlin.memberProperties.filter(
      { it.javaGetter?.isAnnotationPresent(JsonProperty::class.java) ?: false }
    ).forEach fieldHandler@ {
      val propertyName = it.javaGetter!!.getAnnotation(JsonProperty::class.java).value

      val value = it.get(body) ?: return@fieldHandler

      if (value is InputFile) {
        value.appendTo(propertyName, builder)
      } else {
        val valueAsString = MAPPER.writeValueAsString(value).trim('\'', '"')

        builder.addTextBody(propertyName, valueAsString)
      }
    }

    return builder.build()
  }
}
