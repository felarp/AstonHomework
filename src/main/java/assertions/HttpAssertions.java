package assertions;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpAssertions {
            public static void assertStatusCode(Response response, int expectedStatusCode) {
            assertThat(response.getStatusCode())
                    .as("Проверка кода ответа")
                    .isEqualTo(expectedStatusCode);
        }
        public static ResponseBodyAssertions assertResponseBody(Response response) {
            System.out.println("Тело ответа: " + response.getBody().asPrettyString());
            return new ResponseBodyAssertions(response);
        }
    }

