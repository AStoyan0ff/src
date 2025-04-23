package _13BitwiseOperations;
import java.util.Scanner;

public class _02BitAtPositionOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = scanner.nextInt();
        int bit = (digit >> 1) & 1;

        System.out.println(bit);
        scanner.close();

        //Вариант 2

        /*int N = scanner.nextInt();
        int bits = (N / 2) % 2;

        System.out.println(bits);
        scanner.close();*/
    }
}
