package _13BitwiseOperations;
import java.util.Scanner;

public class _05OddTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        int result = 0;

        // XOR  => a ^ b ^ c = c ^ b ^ a

        // Това означава че всички числа които се срещат четен брой пъти
        // ще се унищожат (x ^ x = 0) а единственото число което се среща
        // нечетен брой пъти ще остане.

        // e.g. : 1 2 3 2 3 1 3 -> (1^1) ^ (2^2) ^ (3^3^3) = 3;
        // с O(n) сложност и не използва допълнителна памет =)

        for (String digit : input) {
            result ^= Integer.parseInt(digit);
        }
        System.out.println(result);
        scanner.close();
    }
}
