package _13BitwiseOperations;
import java.util.Scanner;

public class _03PositionBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = scanner.nextInt();
        //int pos = scanner.nextInt();

        /*int bit = (digit >> pos) & 1;*/
        int bit = (digit / 2) % 2;

        System.out.println(bit);
        scanner.close();
    }
}
