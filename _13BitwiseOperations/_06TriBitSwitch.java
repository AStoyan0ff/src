package _13BitwiseOperations;
import java.util.Scanner;

public class _06TriBitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = scanner.nextInt();
        int pos = scanner.nextInt();

        // Създавам маска с 3 бита и я измествам на позиция "pos"
        int mask = 7 << pos;
        int result = digit ^ mask; // XOR ^

        // e.g. : 00000000000000000000010011010010 -> 00000000000000000000011101010010

        System.out.println(result); // 1874
        scanner.close();
    }
}
