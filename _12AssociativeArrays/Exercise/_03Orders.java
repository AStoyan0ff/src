package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Product> productMap = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("buy")) {
                break;
            }

            String[] data = input.split(" ");
            String name = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            productMap.putIfAbsent(name, new Product(name, price, 0));
            Product product = productMap.get(name);

            product.setPrice(price);
            product.setQuantity(quantity);
        }
        productMap.forEach((key, product) ->
                System.out.printf("%s -> %.2f%n", key, product.getPrice()));
    }

    static class Product {

        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {

            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity += quantity;
        }

        public double getPrice() {
            return this.price * this.quantity;
        }
    }
}
                                                        // by AStoyanoff
