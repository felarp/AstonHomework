public class Factorial {
    public static long calculate(int number) {
            if (number < 0) throw new IllegalArgumentException("Число должно быть неотрицательным");
            long result = 1;
            for (int i = 2; i <= number; i++) result *= i;
            return result;
        }
    }

