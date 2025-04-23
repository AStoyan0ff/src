package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // remove leading 0
        String biggerNumber = scanner.nextLine().replaceFirst("^0+", "");
        int digit = scanner.nextInt();

        // If the number is empty removal then it was "0"
        if (biggerNumber.isEmpty()) {
            biggerNumber = "0";
        }
        System.out.println(multiplyDigit(biggerNumber, digit));
        scanner.close();
    }

    private static String multiplyDigit(String digits, int digit) {
        // If the multiplier is 0 -> result is always 0.
        if (digit == 0) return "0";

        StringBuilder buffer = new StringBuilder();
        int curr = 0;

        // right to left
        for (int pos = digits.length() - 1; pos >= 0; pos--) {
            int currDigit = digits.charAt(pos) - '0';
            int product = (currDigit * digit) + curr;

            buffer.append(product % 10);
            curr = product / 10;
        }

        if (curr > 0) {
            buffer.append(curr);
        }
        return buffer.reverse().toString();
    }
}
