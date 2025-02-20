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
    public Response get(String endpoint, String token) {
        return given()
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
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
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formParams)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response patch(String endpoint, Object body) {
        return given()
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response delete(String endpoint) {
        return given()
                .accept(ContentType.JSON)
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

}
