package _13BitwiseOperations;
import java.util.Scanner;

// Преобразуване от десетична (10) в двуична бройна с-ма (2)
public class _01BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digit = Integer.parseInt(scanner.nextLine());
        int searchDigit = Integer.parseInt(scanner.nextLine());
        int cnt = 0;

        while (digit > 0) {
            int remainder = digit % 2;

            if (remainder == searchDigit) {
                cnt++;
            }
            digit /= 2;
        }
        System.out.printf("We have %d zeroes ", cnt);
        scanner.close();
    }
}
