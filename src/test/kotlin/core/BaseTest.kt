package core

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.AfterAll


/**
 * Базовый класс для тестов
 *
 * @method setup() - инициализация настроек и логгера
 * @method tearDown() - завершение сессии webdriver
 * @param @JvmStatic - аннотация для интеропа с джавой
 */

abstract class BaseTest {

   private fun setUp() {
        WebDriverConfig.configure()
        SelenideLogger.addListener("AllureSelenide", AllureSelenide())
    }

    init {
        setUp()
    }

    companion object {
        @JvmStatic
        @AfterAll
        fun tearDown() {
            Selenide.closeWebDriver()
            println("Chrome closed")
        }
    }
}