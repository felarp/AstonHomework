package apitests;

import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeAll;
import providers.ApiProvider;

public class BaseApiTest {
    protected static ApiProvider apiProvider = new ApiProvider();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "";
    }
}
