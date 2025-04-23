package _03Methods.LaB;
import java.util.Scanner;

public class _08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = Integer.parseInt(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.0f", Math.pow(digit, power));
        scanner.close();
    }
}
