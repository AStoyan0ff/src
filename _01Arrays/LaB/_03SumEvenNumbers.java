package _01Arrays.LaB;
import java.util.Arrays;
import java.util.Scanner;

public class _03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;

        for (int num : number) {

            if (num % 2 == 0) {
                result += num;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
