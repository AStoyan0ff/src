package _15TextProcessing.Exercise;
import java.math.BigInteger;
import java.util.Scanner;

public class _05MultiplyBigInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger first = new BigInteger(scanner.nextLine());
        BigInteger second = new BigInteger(scanner.nextLine());

        System.out.println(first.multiply(second));
        scanner.close();
    }
}
