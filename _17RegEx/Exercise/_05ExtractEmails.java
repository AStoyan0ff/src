package _17RegEx.Exercise;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regEx =
                "\\b[a-zA-Z0-9]+(?:[._-][a-zA-Z0-9]+)*@[a-zA-Z]+(?:-?[a-zA-Z]+)*(?:\\.[a-zA-Z]+(?:-?[a-zA-Z]+)*)+\\b";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
