
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @ParameterizedTest
    @MethodSource("factorialDataProvider")
    void testFactorial(int number, long expectedResult) {
        assertEquals(expectedResult, Factorial.calculate(number),
                "Факториал " + number + " должен быть " + expectedResult);
    }

    private static Stream<Arguments> factorialDataProvider() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(5, 120)
        );
    }
    @Test
    void testFactorialThrowsExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> Factorial.calculate(-1),
                "Ожидалось исключение IllegalArgumentException для отрицательного числа");
    }
}