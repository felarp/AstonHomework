package assertions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Data
@AllArgsConstructor
public class ResponseBodyAsserter {
    private final Response response;
    public ResponseBodyAsserter assertField(String path, String value) {
        assertThat(response.jsonPath().getString(path), equalTo(value));
        return this;
    }
}


