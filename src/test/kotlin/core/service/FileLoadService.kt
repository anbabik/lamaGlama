package core.service

interface FileLoadService: LoadService {

    fun checkResult(message: String){
        println(message)
    }

}