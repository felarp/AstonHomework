package assertions;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseBodyAssertions {
    private final Response response;
    public ResponseBodyAssertions(Response response) {
            this.response = response;
        }
        public ResponseBodyAssertions assertArg(String argName, String expectedValue) {
            assertThat(response.jsonPath().getString("args." + argName))
                    .as("Проверка значения " + argName)
                    .isEqualTo(expectedValue);
            return this;
        }
    }

