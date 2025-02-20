package apitests;

import assertions.HttpAssertions;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;


public class ApiTest extends BaseApiTest {
    @Test
    public void testGetRequest() {
        String endpoint = "/get?foo1=bar1&foo2=bar2";
        Response response = apiProvider.get(endpoint);
        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertField("args.foo1", "bar1")
                .assertField("args.foo2", "bar2");
    }

    @Test
    public void testPostRequest() {
        String endpoint = "/post";
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = apiProvider.post(endpoint, requestBody);
        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertField("data", requestBody)
                .assertField("url", "https://postman-echo.com/post");
    }

    @Test
    public void testPostUrlEncodedRequest() {
        String endpoint = "/post";
        Map<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");
        Response response = apiProvider.postUrlEncoded(endpoint, formParams);
        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertField("form.foo1", "bar1")
                .assertField("form.foo2", "bar2");
    }

    @Test
    public void testPutRequest() {
        String endpoint = "/put?hand=wave";
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.put(endpoint, requestBody);
        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertField("data", requestBody)
                .assertField("url", "https://postman-echo.com/put?hand=wave")
                .assertField("args.hand", "wave");
    }

    @Test
    public void testPatchRequest() {
        String endpoint = "/patch";
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.patch(endpoint, requestBody);
        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertField("data", requestBody)
                .assertField("url", "https://postman-echo.com/patch")
                .assertField("args", "[:]");
    }

    @Test
    public void testDeleteRequest() {
        String endpoint = "/delete";
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.delete(endpoint, requestBody);
        HttpAssertions.assertStatusCode(response, 200);
        HttpAssertions.assertResponseBody(response)
                .assertField("data", "This is expected to be sent back as part of response body.")
                .assertField("url", "https://postman-echo.com/delete")
                .assertField("args", "[:]")
                .assertField("files", "[:]")
                .assertField("form", "[:]")
                .assertField("headers.host", "postman-echo.com")
                .assertField("headers.content-type", "application/json");
    }
}


