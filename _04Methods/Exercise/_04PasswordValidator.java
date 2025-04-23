package _04Methods.Exercise;
import java.util.Scanner;

public class _04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean a = isValidateSize(password);

        if (!a) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean b = isValidateChar(password);

        if (!b) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean c = validateDigits(password);

        if (!c) {
            System.out.println("Password must have at least 2 digits");
        }

        if (a && b && c) {
            System.out.println("Password is valid");
        }
    }

    public static boolean isValidateSize(String input) {
        return input.length() >= 6 && input.length() <= 10;
    }

    public static boolean isValidateChar(String input) {
        //превръщаме стринг масив от символи
        for (char symbol : input.toCharArray()) {

            // извикваме класа Character и метода дали символа е цифра или буква
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateDigits(String input) {
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {

            if (Character.isDigit(input.charAt(i))) {
                cnt++;
            }
        }
        return cnt >= 2;
    }
}

