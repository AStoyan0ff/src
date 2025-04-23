package _05List.Lab;
import java.util.*;
import java.util.Scanner;

public class _05ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<String> productList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String curr = scanner.nextLine();

            productList.add(curr);
        }
        Collections.sort(productList);

        /*for (int pos = 0; pos < productList.size(); pos++) {
            System.out.printf("%d.%s%n", pos + 1, productList.get(pos));
        }*/
        int number = 1;

        for (String current : productList) {
            System.out.println(number + "." + current);
        }
    }

}
