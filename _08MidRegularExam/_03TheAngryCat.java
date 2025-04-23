package _08MidRegularExam;
import java.util.*;
import java.util.Scanner;

public class _03TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] priceArr = Arrays
                .stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int points = Integer.parseInt(scanner.nextLine());
        String items = scanner.nextLine();

        int value = priceArr[points];
        int left = 0;
        int right = 0;

        for (int pos = 0; pos < points; pos++) {

            if
            ((items.equals("cheap") && priceArr[pos] < value) ||
                (items.equals("expensive") && priceArr[pos] >= value)) {

                left += priceArr[pos];
            }
        }

        for (int i = points + 1; i < priceArr.length; i++) {

            if
            ((items.equals("cheap") && priceArr[i] < value) ||
                (items.equals("expensive") && priceArr[i] >= value)) {

                right += priceArr[i];
            }
        }

        if (left >= right) {
            System.out.println("Left - " + left);
        }
        else {
            System.out.println("Right - " + right);
        }
    }
}
