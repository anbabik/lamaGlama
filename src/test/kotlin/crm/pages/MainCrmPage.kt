package crm.pages

import core.service.LoadService
import core.service.WriteService
import io.qameta.allure.Step
import kotlin.test.assertEquals

class MainCrmPage: BasePage() {

    @Step("Download CV")
    fun loadCV(service: LoadService): MainCrmPage {
        val cv = service.downloadData()
        assertEquals("Some Data", cv)
        return this
    }

    @Step("WriteCV")
    fun writeCV(service: WriteService) {
        service.writeData(MainCrmPage().menu)
    }
}