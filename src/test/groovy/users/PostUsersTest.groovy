package users

import base.BaseTest
import org.apache.http.HttpStatus
import org.testng.annotations.Test
import payload.UserPayload

import static org.hamcrest.Matchers.is

class PostUsersTest extends BaseTest {

    @Test
    void shouldCreateNewUser() {
        def user = UserPayload.getUser()
        def response = client.postUser(user)

        response.then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("data.name", is(user.name))
                .body("data.email", is(user.email))
                .body("data.gender", is(user.gender))
                .body("data.status", is(user.status))
    }
}
