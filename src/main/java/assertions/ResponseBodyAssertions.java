package assertions;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseBodyAssertions {
    private final Response response;

    public ResponseBodyAssertions(Response response) {
        this.response = response;
    }

    public ResponseBodyAssertions assertField(String fieldPath, String expectedValue) {
        assertThat(response.jsonPath().getString(fieldPath))
                .as("Проверка значения " + fieldPath)
                .isEqualTo(expectedValue);
        return this;
    }
}


