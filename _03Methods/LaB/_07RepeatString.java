package _03Methods.LaB;
import java.util.Scanner;

public class _07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int N = Integer.parseInt(scanner.nextLine());

        repeatString(input, N);
    }
    public static void repeatString(String text, int cnt) {

        for (int i = 1; i <= cnt; i++) {
            System.out.print(text);
        }
    }
}
