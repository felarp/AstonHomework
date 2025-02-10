public class Factorial {
    public static long calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        return (number == 0 || number == 1) ? 1 : number * calculate(number - 1);
    }
}

