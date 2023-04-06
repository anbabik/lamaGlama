
import io.restassured.RestAssured
import io.restassured.http.ContentType
import kotlin.properties.Delegates

fun main(args: Array<String>) {

//    val library = Library<Post>()
//    library.posts = getInfo<Post>("https://jsonplaceholder.typicode.com/posts")
//
//
//    println(library.posts)
    val cars: List<String> = listOf<String>("ford", "bmw", "skoda")
    println( swissKnife(-10, 20) )


    val bodyData = hashMapOf<String, Any>(
        "body" to "test"
    )

    bodyData["newKey"] = 10


}

fun <T> List<T>.getLast(): T {
    return this[this.size - 1]
}
fun String.reversedStr(): String = this.reversed()
fun swissKnife(x: Int, y: Int): Int {
    return when {
        (x > 0 && y > 0) -> x * y
        x <= 0 -> x + y
        else -> x - y
    }
}


//

fun getBodyData(id: Int, email: String): HashMap<String, Any>{
    return hashMapOf<String, Any>(
        "data" to hashMapOf<String, Any>(
            "id" to id,
            "email" to email,
            "first_name" to "Janet",
            "last_name" to "Weaver",
             "avatar" to "https://reqres.in/img/faces/2-image.jpg"
        ),
        "support" to hashMapOf<String, Any>(
            "url" to "https://reqres.in/#support-heading",
        "text" to "To keep ReqRes free, contributions towards server costs are appreciated!"
        )
    )

}

//СМ пример!
inline fun <reified T> getInfo(url: String): List<T> {
    return RestAssured.given()
        .relaxedHTTPSValidation()
        .header("Content-type", "application/json")
        .contentType(ContentType.JSON)
        .body(getBodyData(2,"test@mail.com"))
        .`when`()
        .get(url)
        .then().extract().response().body.jsonPath().getList("", T::class.java)
}


class Library<T> {
    var posts: List<T> by Delegates.notNull<List<T>>()
}


