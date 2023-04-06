package tests

import Reqres.EndPoints
import Reqres.model.PostUserRequest
import Reqres.model.User
import io.restassured.RestAssured
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PostCreateUsers {

    companion object{

        val myTestUser1 = User(null, "Barsik", "Malkovich",
            null, "wildCat@mail.com", "Chief Mouser" )
        val myTestUser2 = User(null, "Sharik", "Gav-Gav",
            null, "wildDog@mail.com", "Watcher" )

        val postBody = PostUserRequest(myTestUser1.firstName, myTestUser1.job)
        val postBody2 = listOf<PostUserRequest>(
            PostUserRequest(myTestUser1.firstName, myTestUser1.job),
            PostUserRequest(myTestUser2.firstName, myTestUser2.job)
        )


    }

    @Test
    fun successCreateUser() {

        val userResponse: Response = RestAssured.given()
            .baseUri(EndPoints().basePath)
            .header("Content-type", "application/json")
            .and()
            .body(postBody)
            .`when`()
            .post(EndPoints().serviceAPI+ EndPoints().pointUser)
            .then()
            .statusCode(201)
            .log().all()
            .extract().response()

        Assertions.assertNotNull(userResponse.body)
    }

    //С двумя юзерами ответ приходит 201, но тело ответа отличается от ожидаемого
    /*
    @Test
    fun successCreateTwoUsers() {

        val userResponse: Response = RestAssured.given()
            .baseUri(EndPoints().basePath)
            .log().all()
            .header("Content-type", "application/json")
            .and()
            .body(postBody2)
            .`when`()
            .post(EndPoints().serviceAPI+EndPoints().pointUser)
            .then()
            .statusCode(201)
            .log().all()
            .extract().response()

        Assertions.assertNotNull(userResponse.body)
    }

     */
}