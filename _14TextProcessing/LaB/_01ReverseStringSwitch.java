package _14TextProcessing.LaB;
import java.util.Scanner;

public class _01ReverseStringSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();

            switch (word) {
                case "end":
                    return;

                default:
                    String reversed = new StringBuilder(word).reverse().toString();
                    System.out.println(word + " = " + reversed);

                    break;
            }
        }
    }
}
