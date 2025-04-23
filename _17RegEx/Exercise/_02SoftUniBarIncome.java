package _17RegEx.Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalIn = 0;
        List<String> outList = new ArrayList<>();

        String regEx = "%(?<custom>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d+(\\.\\d+)?)\\$";
        Pattern patReg = Pattern.compile(regEx);

        String input;
        while (!(input = scanner.nextLine()).equals("end of shift")) {
            Matcher matReg = patReg.matcher(input);

            if (matReg.find()) {

                String custom = matReg.group("custom");
                String product = matReg.group("product");
                int quantity = Integer.parseInt(matReg.group("quantity"));
                double price = Double.parseDouble(matReg.group("price"));

                double totalSpend = quantity * price;
                totalIn += totalSpend;
                outList.add(String.format("%s: %s - %.2f", custom, product, totalSpend));
            }
        }

        for (String curr : outList) {
            System.out.println(curr);
        }
        System.out.printf("Total income: %.2f%n", totalIn);
        scanner.close();
    }
}
