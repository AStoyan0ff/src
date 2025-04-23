package _03Methods.LaB;
import java.util.Scanner;

public class _11MathOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int N2 = Integer.parseInt(scanner.nextLine());

        scanner.close();

        System.out.println(mathOperation(N1, operator, N2));

    }
    private static int mathOperation(int N1, char operator, int N2) {

        switch (operator) {

            case '+' -> {
                return N1 + N2;
            }
            case '-' -> {
                return N1 - N2;
            }
            case '*' -> {
                return N1 * N2;
            }
            case '/' -> {
                if (N2 != 0) {
                    return N1 / N2;
                }
                else {
                    System.out.println("Error: Division by zero!");
                    return 0;
                }
            }
            default -> {
                System.out.println("Error: Invalid operator!");
                return 0;
            }
        }
    }
}
