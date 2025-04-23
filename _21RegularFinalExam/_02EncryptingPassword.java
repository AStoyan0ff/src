package _21RegularFinalExam;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {

            String input = scanner.nextLine();
            processPassword(input);
        }
    }

    private static void processPassword(String password) {

        String regex = "^(?<prefix>[^>]+)>" +
                "(?<g1>\\d{3})\\|" +
                "(?<g2>[a-z]{3})\\|" +
                "(?<g3>[A-Z]{3})\\|" +
                "(?<g4>[^<>]{3})" +
                "<\\k<prefix>$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {

            String encrypted =
                    matcher.group("g1") + matcher.group("g2") +
                            matcher.group("g3") + matcher.group("g4");

            System.out.println("Password: " + encrypted);
        } else {
            System.out.println("Try another password!");
        }
    }
}