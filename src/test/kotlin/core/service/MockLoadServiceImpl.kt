package core.service

class MockLoadServiceImpl: LoadService {

    override fun downloadData(): String {
        return "Some Data"
    }

    override fun uploadData(): Boolean {
        TODO("Not yet implemented")
    }

}