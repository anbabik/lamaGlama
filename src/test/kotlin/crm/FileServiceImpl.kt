package crm

import core.service.FileLoadService
import core.service.WriteService

class FileServiceImpl: FileLoadService, WriteService {

    override fun downloadData(): String {
       return "Some Data"
    }

    override fun uploadData(): Boolean {
        TODO("Not yet implemented")
    }

    override fun writeData(data: String) {
        super.writeData(data)
    }

}
