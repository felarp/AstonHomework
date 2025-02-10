import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @DataProvider(name = "factorialDataProvider")
    public Object[][] factorialDataProvider() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120}
        };
    }
    @Test(dataProvider = "factorialDataProvider")
    public void testFactorial(int number, long expectedResult) {
        assertEquals(Factorial.calculate(number), expectedResult,
                "Факториал " + number + " должен быть " + expectedResult);
    }

    @Test
    public void testFactorialThrowsExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}

