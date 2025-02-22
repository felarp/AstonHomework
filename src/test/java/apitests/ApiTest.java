package apitests;

import assertions.HttpTestUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class ApiTest extends BaseApiTest {
    @Test
    void testGet() {
        Response response = apiProvider.get("/get?foo1=bar1&foo2=bar2");
        HttpTestUtils.assertStatus(response, 200);
        HttpTestUtils.assertBody(response)
                .assertField("args.foo1", "bar1")
                .assertField("args.foo2", "bar2");
    }
    @Test
    void testPost() {
        String body = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.post("/post", body);
        HttpTestUtils.assertStatus(response, 200);
        HttpTestUtils.assertBody(response)
                .assertField("data", body)
                .assertField("url", "https://postman-echo.com/post");
    }
    @Test
    void testPostUrlEncoded() {
        Map<String, String> params = Map.of("foo1", "bar1", "foo2", "bar2");
        Response response = apiProvider.postUrlEncoded("/post", params);
        HttpTestUtils.assertStatus(response, 200);
        HttpTestUtils.assertBody(response)
                .assertField("form.foo1", "bar1")
                .assertField("form.foo2", "bar2");
    }
    @Test
    void testPut() {
        String body = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.put("/put?hand=wave", body);
        HttpTestUtils.assertStatus(response, 200);
        HttpTestUtils.assertBody(response)
                .assertField("data", body)
                .assertField("url", "https://postman-echo.com/put?hand=wave")
                .assertField("args.hand", "wave");
    }
    @Test
    void testPatch() {
        String body = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.patch("/patch", body);
        HttpTestUtils.assertStatus(response, 200);
        HttpTestUtils.assertBody(response)
                .assertField("data", body)
                .assertField("url", "https://postman-echo.com/patch")
                .assertField("args", "[:]");
    }
    @Test
    void testDelete() {
        String body = "This is expected to be sent back as part of response body.";
        Response response = apiProvider.delete("/delete", body);
        HttpTestUtils.assertStatus(response, 200);
        HttpTestUtils.assertBody(response)
                .assertField("data", body)
                .assertField("url", "https://postman-echo.com/delete")
                .assertField("args", "[:]");
    }
}


