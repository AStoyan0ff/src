package _04Methods.Exercise;
import java.util.Scanner;

public class _09Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        while (!(input = scanner.next()).equals("END")) {
            int number = Integer.parseInt(input);

            System.out.println(isPalindrome(number));
        }
    }

    public static boolean isPalindrome(int number) {

        String original = String.valueOf(number);
        String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }
}
