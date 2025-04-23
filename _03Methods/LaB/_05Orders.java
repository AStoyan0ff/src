package _03Methods.LaB;
import java.util.Scanner;

public class _05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int cnt = Integer.parseInt(scanner.nextLine());

        scanner.close();

        finalPrice(product, cnt);
    }

    private static void finalPrice(String product, int cnt) {
        double price = productPrice(product);
        double totalCost = price * cnt;

        System.out.printf("%.2f%n", totalCost);
    }
    private static double productPrice(String product) {
        return switch (product) {

            case "coffee" -> 1.50;
            case "water" -> 1.00;
            case "coke" -> 1.40;
            case "snacks" -> 2.00;
            default -> 0.00;
        };
    }
}
