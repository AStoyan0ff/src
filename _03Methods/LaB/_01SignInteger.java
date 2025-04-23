package _03Methods.LaB;
import java.util.Scanner;

public class _01SignInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        printNumber(N);

    }

    private static void printNumber(int digit) {

        if (digit > 0) {
            System.out.printf("The number %d is positive.", digit);
        }
        else if (digit == 0) {
            System.out.printf("The number %d is zero.", digit);
        }
        else {
            System.out.printf("The number %d is negative.", digit);
        }
    }
}
