package _19FinalExamPreparation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile
        ("([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1");

        Matcher matcher = pattern.matcher(input);

        List<String> mirrorList = new ArrayList<>();
        int pairs = 0;

        while (matcher.find()) {
            pairs++;

            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");

            if (bFirst(firstWord, secondWord)) {
                mirrorList.add(firstWord + " <=> " + secondWord);
            }
        }

        if (pairs == 0) {
            System.out.println("No word pairs found!");
        }
        else {
            System.out.println(pairs + " word pairs found!");
        }

        if (mirrorList.isEmpty()) {
            System.out.println("No mirror words!");
        }
        else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorList));
        }
    }

    private static boolean bFirst(String firstWord, String secondWord) {
        return firstWord.equals(new StringBuilder(secondWord).reverse().toString());
    }
}
