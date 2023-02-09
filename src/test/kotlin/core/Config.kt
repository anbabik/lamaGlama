package core

object Config {
    val BASE_URL = "https://www.google.com/"
    val HH_BASE_URL = "https://hh.ru/"
    val HH_LOGIN_URL = "https://hh.ru/account/login?backurl=%2F&hhtmFrom=main"
    val USER_LOGIN = "saint.babik93@gmail.com"
    val USER_PASSWORD = "123456@Hh"

    val loginData = hashMapOf<String, String>(
        "userLogin" to "saint.babik93@gmail.com",
        "userPassword" to "123456@Hh"
    )


}