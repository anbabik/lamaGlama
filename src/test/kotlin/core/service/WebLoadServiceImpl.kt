package core.service

class WebLoadServiceImpl: LoadService {
    override fun downloadData(): String {
        return "Some Data"
    }

    override fun uploadData(): Boolean {
        TODO("Not yet implemented")
    }
}