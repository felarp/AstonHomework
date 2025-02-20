package providers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiProvider {
    public Response get(String endpoint) {
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response post(String endpoint, Object body) {
        return given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response postUrlEncoded(String endpoint, Map<String, String> formParams) {
        return given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .formParams(formParams)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response put(String endpoint, String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response patch(String endpoint, String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response delete(String endpoint, String requestBody) {
        return given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
