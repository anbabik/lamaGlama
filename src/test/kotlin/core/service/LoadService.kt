package core.service

interface LoadService {
    fun downloadData(): String
    fun uploadData(): Boolean
}