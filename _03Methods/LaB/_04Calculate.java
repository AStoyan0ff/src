package _03Methods.LaB;
import java.util.Scanner;

public class _04Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());

        calculator(operation, firstDigit, secondDigit);
    }

    private static void calculator(String operation, int N1, int N2) {
        switch (operation) {

            case "add" -> System.out.println(N1 + N2);
            case "multiply" -> System.out.println(N1 * N2);
            case "subtract" -> System.out.println(N1 - N2);
            case "divide" -> System.out.println(N1 / N2);
        }
    }
}






