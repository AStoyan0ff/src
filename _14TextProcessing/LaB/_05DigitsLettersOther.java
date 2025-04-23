package _14TextProcessing.LaB;
import java.util.Scanner;

public class _05DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder symbol = new StringBuilder();

        for (char curr : input.toCharArray()) {

            if (Character.isDigit(curr)) {
                digit.append(curr);
            }
            else if (Character.isLetter(curr)) {
                letter.append(curr);
            }
            else {
                symbol.append(curr);
            }
        }
        System.out.println(digit);
        System.out.println(letter);
        System.out.println(symbol);

        scanner.close();
    }
}
