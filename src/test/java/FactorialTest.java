import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(Factorial.calculate(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(Factorial.calculate(5), 120, "Факториал 5 должен быть 120");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число должно быть неотрицательным")
    public void testFactorialOfNegativeNumberThrowsExceptionWithMessage() {
        Factorial.calculate(-1);
    }

    @Test
    public void testFactorialOfLargeNumber() {

        Assert.assertTrue(Factorial.calculate(20) > 0, "Факториал 20 должен быть положительным");
    }
}

