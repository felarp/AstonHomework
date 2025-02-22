package assertions;

import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@UtilityClass
public class HttpTestUtils {
    public static void assertStatus(Response response, int code) {
        assertThat(response.getStatusCode(), equalTo(code));
    }
    public static ResponseBodyAsserter assertBody(Response response) {
        System.out.println("Response: " + response.getBody().asPrettyString());
        return new ResponseBodyAsserter(response);
    }
}
