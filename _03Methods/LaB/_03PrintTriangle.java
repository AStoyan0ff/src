package _03Methods.LaB;
import java.util.Scanner;

public class _03PrintTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.close();

        printTriangle(N);
    }

    private static void printTriangle(int N) {

        for (int i = 1; i <= N; i++) {
            printLine(1, i);
        }
        for (int i = N - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    private static void printLine(int a, int b) {

        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
