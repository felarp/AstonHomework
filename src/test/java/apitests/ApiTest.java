package apitests;

import assertions.HttpAssertions;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ApiTest extends BaseApiTest{
    @Test
    public void testGetRequest() {
        String endpoint = "/get?foo1=bar1&foo2=bar2";
        Response response = apiProvider.get(endpoint);

        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertArg("foo1", "bar1")
                .assertArg("foo2", "bar2");
    }
}
