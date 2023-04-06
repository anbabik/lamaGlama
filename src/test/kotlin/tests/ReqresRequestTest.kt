package tests

import Reqres.model.PostUserRequest
import Reqres.model.User
import io.restassured.RestAssured.given
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ReqresRequestTest {

    companion object{
        val userId: Int = 2
        val pageNumber: Int = 1
        val per_page: Int = 6
        val total: Int = 12
        val total_pages:Int = 2

        val myTestUser = User(null, "Barsik", "Malkovich",
        null, "wildCat@mail.com", "Chief Mouser" )
        val postBody = PostUserRequest(myTestUser.firstName, myTestUser.job)

    }



    //Написать удаление пользователя после всех тестов



    @Test
    fun successGetSingleUserById() {

        val response: Response = given()
                                .baseUri("https://reqres.in")
                                .`when`()
                                .log().all()
                                .get("/api/users/{id}", userId)
                                .then()
                                .statusCode(200)
                                .log().all()
                                .extract().response()

        Assertions.assertEquals("application/json; charset=utf-8", response.contentType)
        Assertions.assertEquals(userId, response.jsonPath().getInt("data.id"))
        Assertions.assertEquals("janet.weaver@reqres.in", response.jsonPath().getString("data.email"))

}

    @Test
    fun successGetListOfUsers() {

        val response: Response = given()
            .baseUri("https://reqres.in")
            .queryParam("page", pageNumber)
            .`when`()
            .log().all()
            .get("/api/users")
            .then()
            .statusCode(200)
            .log().all()
            .extract().response()


        Assertions.assertEquals("application/json; charset=utf-8", response.contentType)
        Assertions.assertEquals(pageNumber, response.jsonPath().getInt("page"))
        Assertions.assertEquals(1, response.jsonPath().getInt("page"))
        Assertions.assertEquals(userId, response.jsonPath().getInt("data[1].id"))
        Assertions.assertEquals("janet.weaver@reqres.in", response.jsonPath().getString("data[1].email"))

    }



}