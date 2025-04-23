package _07ExamPreparation;
import java.util.*;
import java.util.Scanner;

public class _01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalPriceNoTaxes = 0;
        double totalTaxes = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("special") || input.equals("regular")) {

                if (totalPriceNoTaxes == 0) {
                    System.out.println("Invalid order!");
                }
                else {
                    double totalPriceWithTaxes = totalPriceNoTaxes + totalTaxes;

                    if (input.equals("special")) {
                        totalPriceWithTaxes *= 0.9;
                    }

                    System.out.println("Congratulations you've just bought a new computer!");
                    System.out.printf("Price without taxes: %.2f$\n", totalPriceNoTaxes);
                    System.out.printf("Taxes: %.2f$\n", totalTaxes);
                    System.out.println("-----------");
                    System.out.printf("Total price: %.2f$\n", totalPriceWithTaxes);
                }
                break;
            }

            try {
                double price = Double.parseDouble(input);

                if (price < 0) {
                    System.out.println("Invalid price!");
                }
                else {
                    totalPriceNoTaxes += price;
                    totalTaxes += price * 0.20;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid price!");
            }
        }
        scanner.close();
    }
}
