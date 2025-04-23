package _14TextProcessing.LaB;
import java.util.Scanner;

public class _02RepeatSwitchStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (String input : words) {

            // Добавяне на съдържание в края на низове или списъци -> append()
            switch (input) {
                default:
                    result.append(repeatString(input, input.length()));

                    break;
            }
        }
        System.out.println(result);
    }

    private static String repeatString(String word, int cnt) {
        StringBuilder repeatWord = new StringBuilder();

        for (int pos = 0; pos < cnt; pos++) {
            repeatWord.append(word);
        }
        return repeatWord.toString();
    }
}
