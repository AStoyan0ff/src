package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _01ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] user = scanner.nextLine().split(", ");

        for (String input : user) {
            if (bFirstValidUser(input)) {

                System.out.println(input);
            }
        }
    }
    // check username is valid
    private static boolean bFirstValidUser(String user) {

        if (user.length() < 3 || user.length() > 16) {
            return false;
        }
        // check -> letter, digit, special symbol
        for (char c : user.toCharArray()) {

            if (!Character.isLetterOrDigit(c) && c != '-' && c != '_') {
                return false;
            }
        }
        return true;
    }
}
