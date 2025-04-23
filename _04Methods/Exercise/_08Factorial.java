package _04Methods.Exercise;
import java.util.Scanner;

public class _08Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());

        // Метод за изчисление на Factorial

        long first = factorialResult(N1);
        long second = factorialResult(N2);

        double result = (double) first / second;

        System.out.printf("%.2f", result);
    }

    public static long factorialResult(int digit) {
        // !5 = 1 * 2 * 3 * 4 * 5 == 120

        long factorial = 1;

        for (int pos = 2; pos <= digit; pos++) {
            factorial *= pos;
        }
        return factorial;
    }
}

