package crm

import crm.pages.MainCrmPage
import org.junit.jupiter.api.Test

class CrmTest {

    companion object {
        val fileService = FileServiceImpl()
    }

    @Test
    fun testCvLoad(){
       MainCrmPage().loadCV(fileService)
    }

    @Test
    fun testCVWrite(){
        MainCrmPage().writeCV(fileService)
    }

}