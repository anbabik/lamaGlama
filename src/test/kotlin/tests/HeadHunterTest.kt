package tests

import core.BaseTest
import core.service.MockLoadServiceImpl
import crm.FileServiceImpl
import hh.pages.HeadHunterLoginPage
import org.junit.jupiter.api.Test

class HeadHunterTest: BaseTest() {

    companion object {
        val fileService = FileServiceImpl()
        val mockService = MockLoadServiceImpl()
    }

    /*
    @BeforeTest
    fun openBaseURL(){
        Selenide.open(Config.HH_BASE_URL)
        //       Thread.sleep(10_000)
        assertEquals(Config.BASE_URL, WebDriverRunner.getWebDriver().currentUrl)
    }
     */

//    @Test
//    @DisplayName("test login by password")
//    fun testLoginByPassword() {
//        Selenide.open(Config.HH_LOGIN_URL)
//        HeadHunterLoginPage().loginByPassword()
//        Thread.sleep(10_000)
//        assertEquals("https://hh.ru/?hhtmFrom=account_login", WebDriverRunner.getWebDriver().currentUrl)
//
//    }

    @Test
    fun loadTest(){
        HeadHunterLoginPage().checkDownloadCv(mockService)
    }
}