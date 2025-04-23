package _04Methods.Exercise;
import java.util.Scanner;

public class _10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        printTopInteger(N);
        scanner.close();
    }

    public static void printTopInteger(int N) {
        for (int pos = 1; pos <= N; pos++) {

            if (divisibleEight(pos) && oddDigits(pos)) {
                System.out.println(pos);
            }
        }
    }

    public static boolean divisibleEight(int N) {
        int result = 0;
        int curr = N;

        while (curr > 0) {

            result += curr % 10;
            curr /= 10;
        }
        return result % 8 == 0;
    }

    public static boolean oddDigits(int N) {
        int curr = N;

        while (curr > 0) {
            int digit = curr % 10;

            if (digit % 2 != 0) {
                return true;
            }
            curr /= 10;
        }
        return false;
    }
}
