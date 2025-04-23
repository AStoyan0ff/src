package _14TextProcessing.LaB;
import java.util.Scanner;

public class _04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] banWords = scanner.nextLine().split(", ");
        String word = scanner.nextLine();

        for (String text : banWords) {
            String replaceWord = "*".repeat(text.length());

            word = word.replace(text, replaceWord);
        }

        System.out.println(word);
        scanner.close();
    }
}
