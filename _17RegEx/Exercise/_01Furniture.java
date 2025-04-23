package _17RegEx.Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> furtitureList = new ArrayList<>();
        double totalSpend = 0.0;

        String regEx = ">>([A-Za-z]+)<<([0-9]+\\.?[0-9]*)!([0-9]+)";
        Pattern pattern = Pattern.compile(regEx);

        String input;
        while (!(input = scanner.nextLine()).equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {

                String furniture = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));

                furtitureList.add(furniture);
                totalSpend += price * quantity;
            }
        }
        System.out.println("Bought furniture:");

        if (!furtitureList.isEmpty()) {

            for (String items : furtitureList) {
                System.out.println(items);
            }
        }
        System.out.printf("Total money spend: %.2f\n", totalSpend);
        scanner.close();
    }
}
