package _19FinalExamPreparation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08DestinationMapper2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regEx = "([=/])([A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);

        List<String> destinationList = new ArrayList<>();
        int travel = 0;

        while (matcher.find()) {
            String destination = matcher.group(2);

            destinationList.add(destination);
            travel += destination.length();
        }

        if (destinationList.isEmpty()) {

            System.out.println
                    ("Destinations:");
        }
        else {
            System.out.println
                    ("Destinations: " + String.join(", ", destinationList));
        }

        System.out.println
                    ("Travel Points: " + travel);

        scanner.close();
    }
}
