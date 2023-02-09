package crm

import core.service.WebLoadServiceImpl
import crm.pages.MainCrmPage
import org.junit.jupiter.api.Test

class CrmTest {

    companion object {
        val fileService = FileServiceImpl()
        val webService = WebLoadServiceImpl()
    }

    @Test
    fun testCvLoad(){
       MainCrmPage().loadCV(webService)
    }

    @Test
    fun testCVWrite(){
        MainCrmPage().writeCV(fileService)
    }

}