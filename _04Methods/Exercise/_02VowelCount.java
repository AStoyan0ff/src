package _04Methods.Exercise;
import java.util.Scanner;

public class _02VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(vowelsCnt(input));
        scanner.close();
    }

    public static int vowelsCnt(String text) {
        int cnt = 0;
        text = text.toLowerCase();

        for (char ch : text.toCharArray()) {

            if ("aeoiuy".indexOf(ch) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}
