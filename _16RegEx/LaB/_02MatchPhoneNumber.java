package _16RegEx.LaB;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regEx = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(input);

        StringBuilder buffer = new StringBuilder();
        boolean isFound = false;

        while (mat.find()) {

            if (isFound) {
                buffer.append(", ");
            }
            buffer.append(mat.group());
            isFound = true;
        }
        if (isFound) {
            System.out.println(buffer);
        }
        scanner.close();
    }
}
