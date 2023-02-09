package core

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Configuration.*
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

object WebDriverConfig {

    fun configure() {
        WebDriverManager.chromedriver().setup()

        val capabilities = DesiredCapabilities()
        val chromeOptions = ChromeOptions()

        chromeOptions.apply {
            addArguments("--no-sandbox")
            // addArguments("--no-gpu")
            addArguments("--enable-automation")
            addArguments("--disable-popup-blocking")
            addArguments("--disable-notifications")
            addArguments("--disable-gpu")
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions)

        Configuration().apply {
            browser = "chrome"
            driverManagerEnabled = true
            browserSize = "1920x1080"
            headless = false
            pageLoadTimeout = 120_000
            browserCapabilities = capabilities
            timeout = 25_000 // implicit wait in ms
        }
    }
}