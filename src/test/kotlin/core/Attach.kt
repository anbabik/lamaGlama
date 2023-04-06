package core

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.logging.LogType

@Attachment(value = "{screenshotName}", type = "image/png")
fun attachScreen(screenshotName: String = "Screenshot"): ByteArray? {
    return (WebDriverRunner.getWebDriver() as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
}

@Attachment(value = "{attachName}", type = "text/plain")
fun attachText(attachName: String?, message: String?): String? {
    return message
}
@Attachment(value = "{attachName}", type = "application/json")
fun attachJson(json: String?, attachName: String? = "Json attach"): String? {
    return json
}
@Attachment(value = "{attachName}", type="text/plain")
fun attachBrowserConsoleLog(attachName: String? = "Console logger"): String {
    return Selenide.getWebDriverLogs(LogType.BROWSER).joinToString("\n\n")
}
