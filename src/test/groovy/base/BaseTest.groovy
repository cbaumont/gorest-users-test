package base

import client.UsersClient
import org.testng.annotations.BeforeClass


class BaseTest {

    UsersClient client

    @BeforeClass
    void setUp() {
        client = new UsersClient()
    }

}
