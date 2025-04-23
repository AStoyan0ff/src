package _04Methods.Exercise;
import java.util.Scanner;

public class _05AddSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        int N3 = Integer.parseInt(scanner.nextLine());

        int result = subtract(sum(N1, N2), N3);

        System.out.println(result);
        scanner.close();

    }

    public static int sum(int a, int b) {
        return a + b;

    }

    public static int subtract(int sum, int c) {
        return sum - c;
    }
}

