package _01Arrays.LaB;
import java.util.Arrays;
import java.util.Scanner;

public class _06EqualArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* String[] firstArrInput = scanner.nextLine().split(" ");
        int[] firstArr = new int[firstArrInput.length];

        for (int idx = 0; idx < firstArrInput.length; idx++) {
            firstArr[idx] = Integer.parseInt(firstArrInput[idx]);
        }*/

        int[] firstArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (firstArr.length != secondArr.length) {

            System.out.println("Arrays are not identical. Found difference at 0 index.");
            return;
        }

        int sum = 0;

        for (int idx = 0; idx < firstArr.length; idx++) {

            if (firstArr[idx] != secondArr[idx]) {

                System.out.printf("Arrays are not identical. Found difference at %d index.%n", idx);
                return;
            }
            sum += firstArr[idx];
        }
        System.out.printf("Arrays are identical. Sum: %d%n", sum);
        scanner.close();
    }
}
