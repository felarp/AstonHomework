import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTestNgTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculate(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.calculate(5), 120, "Факториал 5 должен быть 120");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumberThrowsException() {
        Factorial.calculate(-1);
    }
}

