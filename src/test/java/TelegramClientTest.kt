import io.ingenieux.telegram.TelegramBotClient
import io.ingenieux.telegram.model.InputFile
import io.ingenieux.telegram.model.SendMessageRequest
import io.ingenieux.telegram.model.SendPhotoRequest
import io.ingenieux.telegram.model.SetWebhookRequest
import org.junit.Test
import java.io.File

class TelegramClientTest {
  val client = TelegramBotClient("178578207:AAGP3TGNbkvppv5A4ujPGhaDhxnjG8h")

  @Test
  fun testGetMe() {
    val result = client.getMe()

    println(result)
  }

  @Test
  fun testSetWebhook() {
    val result = client.setWebhook(SetWebhookRequest("https://f55c62c3.ngrok.io/bot", null))

    println(result)
  }


  @Test
  fun testSendMessage() {
    val req = SendMessageRequest(
      "116644997", "isto **eh** um __TESTE__",
      replyToMessageId = 6
    )

    val result = client.sendMessage(req)

    println(result)
  }

  @Test
  fun testSendPhoto() {
    val req = SendPhotoRequest(
      "116644997", InputFile.build(File("src/test/resources/gatofofo.jpg"))
    )

    val result = client.sendPhoto(req)

  }
}
