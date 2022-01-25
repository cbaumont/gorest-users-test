package payload

import com.github.javafaker.Faker

class UserPayload {

    static Faker faker = new Faker();

    static getUser() {
        [
                "name"  : faker.name().fullName(),
                "gender": "male",
                "email" : faker.idNumber().valid() + "@outlook.com",
                "status": "active"
        ]
    }
}
