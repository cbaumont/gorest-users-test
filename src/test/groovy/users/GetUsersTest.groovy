package users

import base.BaseTest
import org.apache.http.HttpStatus
import org.testng.annotations.Test

import static org.hamcrest.Matchers.is

class GetUsersTest extends BaseTest {

    @Test
    void shouldListAllUsers() {
        def response = client.getUsers()

        response.then()
                .statusCode(HttpStatus.SC_OK)
    }

    @Test
    void shouldListUserById() {
        int id = 130

        def response = client.getUserById(id)

        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", is(id))
    }
}
