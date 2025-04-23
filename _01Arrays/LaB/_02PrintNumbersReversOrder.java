package _01Arrays.LaB;
import java.util.Scanner;

public class _02PrintNumbersReversOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numbers = new int[N];

        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = scanner.nextInt();
        }
        for (int idx = N - 1; idx >= 0; idx--) {
            System.out.print(numbers[idx] + " ");
            scanner.close();
        }
    }
}
