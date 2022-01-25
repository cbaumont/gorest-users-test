package specification

import io.restassured.specification.RequestSpecification
import utils.PropertiesReader

class UsersSpecification {

    static RequestSpecification getServiceSpecification() {
        return RequestSpecificationBuilder
                .build(PropertiesReader.get("users-client"), "/users")
    }
}
