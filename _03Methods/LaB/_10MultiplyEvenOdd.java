package _03Methods.LaB;
import java.util.Scanner;

public class _10MultiplyEvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int result = evensAndOdds(N);

        System.out.println(result);
    }

    public static int evensAndOdds(int N) {

        N = Math.abs(N);

        int resultEven = evenDigit(N);
        int resultOdd = oddsDigit(N);

        return resultEven * resultOdd;
    }

    public static int evenDigit(int N) {
        int sum = 0;

        while (N > 0) {
            int digit = N % 10;

            if (digit % 2 == 0) {
                sum += digit;
            }

            N /= 10;
        }
        return sum;
    }

    public static int oddsDigit(int N) {
        int sum = 0;

        while (N > 0) {
            int digit = N % 10;

            if (digit % 2 != 0) {
                sum += digit;
            }
            N /= 10;
        }
        return sum;
    }
}
