package core.service

interface WriteService {

    fun writeData(data: String) {
        println("Your $data is saved!")
    }

}