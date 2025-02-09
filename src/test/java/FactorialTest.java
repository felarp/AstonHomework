import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.calculate(0), "Факториал 0 должен быть 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, Factorial.calculate(5), "Факториал 5 должен быть 120");
    }

    @Test
    void testFactorialOfNegativeNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
        System.out.println("Тест успешно поймал исключение: " + exception.getMessage());
    }
}