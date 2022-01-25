package specification

import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.RestAssuredConfig
import io.restassured.config.SSLConfig
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification

class RequestSpecificationBuilder {

    static RequestSpecification build(String baseUri, String basePath, ContentType contentType = ContentType.JSON) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
        requestSpecBuilder.config = new RestAssuredConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation())
        requestSpecBuilder.setRelaxedHTTPSValidation()
        requestSpecBuilder.log(LogDetail.ALL)
        requestSpecBuilder.addFilter(new ResponseLoggingFilter())
        requestSpecBuilder.contentType = contentType
        requestSpecBuilder.baseUri = baseUri
        requestSpecBuilder.basePath = basePath

        return requestSpecBuilder.build()
    }
}