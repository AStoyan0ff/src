package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double totalCost = 0;

        for (String newInput : input) {
            totalCost += getString(newInput);
        }
        System.out.printf("%.2f\n", totalCost);
        scanner.close();
    }
    private static double getString(String input) {

        char first = input.charAt(0);
        char last = input.charAt(input.length() - 1);
        double num = Double.parseDouble(input.substring(1, input.length() - 1));

        if (Character.isUpperCase(first)) {
            num /= getAlphabet(first);
        }
        else {
            num *= getAlphabet(first);
        }

        if (Character.isUpperCase(last)) {
            num -= getAlphabet(last);
        }
        else {
            num += getAlphabet(last);
        }
        return num;
    }
    private static int getAlphabet(char letter) {
        return Character.toLowerCase(letter) - 'a' + 1;
    }
}
// Finish today =) 03:00 h