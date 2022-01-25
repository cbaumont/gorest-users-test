package client

import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import specification.UsersSpecification
import utils.PropertiesReader

import static io.restassured.RestAssured.given

class UsersClient {

    static RequestSpecification serviceSpecification = UsersSpecification.getServiceSpecification()
    static accessToken = PropertiesReader.get("access-token")

    UsersClient() {
    }

    Response getUsers() {
        return given()
                .spec(serviceSpecification)
                .get()
    }

    Response getUserById(int id) {
        return given()
                .spec(serviceSpecification)
                .pathParam("id", id)
                .get("/{id}")
    }

    Response postUser(user) {
        return given()
                .spec(serviceSpecification)
                .auth().oauth2(accessToken)
                .body(user)
                .post()
    }

    Response deleteUser(int id) {
        return given()
                .spec(serviceSpecification)
                .auth().oauth2(accessToken)
                .pathParam("id", id)
                .delete()
    }
}
