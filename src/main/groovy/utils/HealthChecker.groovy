package utils

import io.restassured.response.Response
import io.restassured.specification.FilterableRequestSpecification
import io.restassured.specification.RequestSpecification

import static io.restassured.RestAssured.given

class HealthChecker {

    static void check(RequestSpecification requestSpecification) {
        RequestSpecification spec = given()
                .spec(requestSpecification)
        Response healthResp = spec.get('health')
        if (healthResp.statusCode() != 200 || healthResp.jsonPath().getString('status') != 'UP') {
            throw new ServiceDownException(String.format("The service %s is down.", ((FilterableRequestSpecification) spec).getBaseUri()))
        }
    }

}