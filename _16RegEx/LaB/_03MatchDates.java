package _16RegEx.LaB;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b(0[2-9]|[12]\\d|3[01])[./-]([A-Z][a-z]{2})[./-](\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            String day = matcher.group(1);
            String month = matcher.group(2);
            String year = matcher.group(3);

            System.out.printf("Day: %s, Month: %s, Year: %s\n", day, month, year);
        }
        scanner.close();
    }
}
