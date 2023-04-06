package Reqres

data class PostRequest (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)