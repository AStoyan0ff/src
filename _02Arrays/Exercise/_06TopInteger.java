package _02Arrays.Exercise;
import java.util.Arrays;
import java.util.Scanner;

public class _06TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arrTopInteger = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder topInt = new StringBuilder(); // Find top Digits

        for (int pos = 0; pos <= arrTopInteger.length - 1; pos++) {
            boolean isFound = true;

            for (int indx = pos + 1; indx < arrTopInteger.length; indx++) {

                if (arrTopInteger[pos] <= arrTopInteger[indx]) {

                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                topInt.append(arrTopInteger[pos]).append(" ");
            }
        }

        System.out.println(topInt.toString().trim());
        scanner.close();
    }
}
