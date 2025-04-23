package _01Arrays.LaB;
import java.util.Arrays;
import java.util.Scanner;

public class _04ReversArrayToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] reverseArr = scanner.nextLine().split(" ");
        int N = reverseArr.length;

        for (int idx = 0; idx < N / 2; idx++) {
            String buff = reverseArr[idx];

            reverseArr[idx] = reverseArr[N - 1 - idx];
            reverseArr[N - 1 - idx] = buff;
        }
        System.out.println(String.join(" ", reverseArr));
        scanner.close();
    }
}
