package _16RegEx.LaB;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String reg = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern patRegex = Pattern.compile(reg);
        Matcher matRegex = patRegex.matcher(input);

        while (matRegex.find()) {
            System.out.print(matRegex.group() + " ");

        }
        scanner.close();
    }
}
