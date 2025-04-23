package _13BitwiseOperations;
import java.util.Scanner;

public class _04BitDestroyer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int position = scanner.nextInt();

        // обръща всички битове -> "position" става 0, а всички останали 1 ->
        // зануляване на бита на "position", без да променя останалите
        // Двоично представяне (преди) -> 010100100001 => 010100000001 (след)

        int result = N & ~ (1 << position);

        System.out.println(result);
        scanner.close();
    }
}
