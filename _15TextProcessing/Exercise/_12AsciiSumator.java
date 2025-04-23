package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _12AsciiSumator {
    public static int charactersResult(char start, char end, String input) {
        int result = 0;

        char low = (char) Math.min(start, end);
        char up = (char) Math.max(start, end);

        for (int pos = 0; pos < input.length(); pos++) {
            char curr = input.charAt(pos);

            if (curr > low && curr < up) {
                result += curr;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();

        int result = charactersResult(first, second, input);

        System.out.println(result);
        scanner.close();

        /*Как работи:
        За първото въвеждане знаците между '.' (ASCII 46) и '@' (ASCII 64)
        в низа dsg12gr5653feee5 са d, s, g, 1, 2, g, r, 5, 6, 5, 3, f, e, e, e, 5.
        Техните ASCII стойности се сумират, за да дадат 363.

        За втория вход знаците между '?' (ASCII 63) и 'Е' (ASCII 69)
        в низа @ABCEF са A, B, C. Техните ASCII стойности се сумират, за да дадат 262.*/
    }
}
