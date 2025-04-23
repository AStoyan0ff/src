package _04Methods.Exercise;
import java.util.Scanner;

public class _01SmallestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        int N3 = Integer.parseInt(scanner.nextLine());

        System.out.println(smallNumbers(N1, N2, N3));
    }

    private static int smallNumbers(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}
