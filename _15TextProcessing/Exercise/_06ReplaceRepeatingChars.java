package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(replaceRepeatingChars(input));
    }
    private static String replaceRepeatingChars(String word) {
        StringBuilder result = new StringBuilder();

        // Add the first character (because it is always saved)
        result.append(word.charAt(0));

        for (int pos = 1; pos < word.length(); pos++) {

            // Add the symbol only if it is different from the previous one
            if (word.charAt(pos) != word.charAt(pos - 1)) {
                result.append(word.charAt(pos));
            }
        }

        return result.toString();
    }
}
