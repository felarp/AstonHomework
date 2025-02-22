package providers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

import static io.restassured.RestAssured.given;
import java.util.Map;

@RequiredArgsConstructor
public class ApiProvider {
    private static final String JSON = ContentType.JSON.toString();
    private static final String URL_ENCODED = "application/x-www-form-urlencoded; charset=UTF-8";
    private static final String TEXT = "text/plain";

    private RequestSpecification baseSpec() {
        return given().accept(JSON).log().all();
    }

    public Response get(String endpoint) {
        return baseSpec().get(endpoint).then().log().all().extract().response();
    }

    public Response post(String endpoint, Object body) {
        return baseSpec().contentType(JSON).body(body)
                .post(endpoint).then().log().all().extract().response();
    }

    public Response postUrlEncoded(String endpoint, Map<String, String> params) {
        return baseSpec().contentType(URL_ENCODED).formParams(params)
                .post(endpoint).then().log().all().extract().response();
    }

    public Response put(String endpoint, String body) {
        return baseSpec().contentType(TEXT).body(body)
                .put(endpoint).then().log().all().extract().response();
    }

    public Response patch(String endpoint, String body) {
        return baseSpec().contentType(TEXT).body(body)
                .patch(endpoint).then().log().all().extract().response();
    }

    public Response delete(String endpoint, String body) {
        return baseSpec().contentType(JSON).body(body)
                .delete(endpoint).then().log().all().extract().response();
    }
}
