package tests

import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.files.DownloadActions.click
import core.BaseTest
import core.Config
import core.attachScreen
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GoogleTest: BaseTest() {
    @Test
    @DisplayName("test google Login")
    fun testLogin () {
        open(Config.BASE_URL)
        click()
        attachScreen("Google Screen")
        Thread.sleep(10_000)
        assertEquals(Config.BASE_URL, WebDriverRunner.getWebDriver().currentUrl)
    }

}