package _04Methods.Exercise;
import java.util.Scanner;

public class _06MiddleCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddChar(input);
        scanner.close();
    }

    private static void printMiddChar(String text) {

        // aString -> 'r' -> index 3 -> дължината е 7
        // Делим дължината на 2 ( 7 / 2 = 3) намираме index 3
        int sizeOf = text.length();
        int indx = sizeOf / 2;

        if (sizeOf % 2 == 0) {

            char one = text.charAt(indx);
            char two = text.charAt(indx - 1);

            System.out.println("" + two + one);
        }
        else {
            char symbol = text.charAt(indx);
            System.out.println("" + symbol);
        }
    }
}
