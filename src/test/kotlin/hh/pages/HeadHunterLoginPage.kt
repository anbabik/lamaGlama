package hh.pages

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import core.Config
import core.Interaction
import core.service.LoadService
import io.qameta.allure.Step
import kotlin.test.assertEquals

class HeadHunterLoginPage {
    private val buttonSelectPassword = element(byXpath("//button[@data-qa=\"expand-login-by-password\"]"))
    //private val buttonSignupSubmit = element(byXpath("//button[@data-qa=\"account-login-submit\"]"))
    private val buttonSignupSubmit = element(byXpath("//div[@class=\"account-login-actions\"]//button[@data-qa=\"account-login-submit\"]"))
    private val fieldLogin = element(byXpath("//input[@name=\"username\" and @inputmode=\"email\"]"))
    private val inputLogin = element(byXpath("//input[@type=\"hidden\" and @name=\"username\"]"))
    private val fieldPassword = element(byXpath("//input[@data-qa=\"login-input-password\"]"))
//           val mainMenu = element(byXpath("//button[@data-qa=\"mainmenu_applicantProfile\"]"))
//           val userName = element(byXpath("//a[@data-qa=\"mainmenu_applicantInfo\"]//span")).shouldBe(visible).text()

    @Step("Ввести значение в поле")
    fun setInput(field:SelenideElement, input:String): HeadHunterLoginPage {
 //       field.setValue(input)
        field.sendKeys(input)
        return this
    }

    @Step("После паузы нажать на кнопку")
    fun clickAfterPause(time:Long, button:SelenideElement, ): HeadHunterLoginPage {
        Thread.sleep(time)
        button.click()
        return this
    }


    @Step("Войти в аккаунт с помощью пароля")
    fun loginByPassword(): HeadHunterLoginPage {
        buttonSelectPassword.click()
        Interaction.setInputValue(fieldLogin, Config.USER_LOGIN)
        //setInput(fieldLogin, Config.USER_LOGIN)
        //setInput(fieldPassword, Config.USER_PASSWORD)
        clickAfterPause(2_000, buttonSignupSubmit)
        Thread.sleep(4000)
        element("#rc-anchor-container > div.rc-anchor-content > div:nth-child(1) > div").click()
        Thread.sleep(4000)
        return this
    }

    @Step("Download CV")
    fun checkDownloadCv(service: LoadService): HeadHunterLoginPage {
        val cv = service.downloadData()
        assertEquals("Some Data", cv)
        return this
    }

}

