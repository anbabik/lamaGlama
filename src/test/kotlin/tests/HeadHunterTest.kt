package tests

import com.codeborne.selenide.Selenide
import core.BaseTest
import core.Config
import core.attachBrowserConsoleLog
import core.attachText
import core.service.MockLoadServiceImpl
import crm.FileServiceImpl
import hh.pages.HeadHunterLoginPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HeadHunterTest : BaseTest() {

    companion object {
        val fileService = FileServiceImpl()
        val mockService = MockLoadServiceImpl()
    }

    @Test
    @DisplayName("test login by password")
    fun testLoginByPassword() {
        Selenide.open(Config.HH_LOGIN_URL)
        attachText("message", "some attached text")
        attachBrowserConsoleLog("Console")
        HeadHunterLoginPage().loginByPass()
    }

}