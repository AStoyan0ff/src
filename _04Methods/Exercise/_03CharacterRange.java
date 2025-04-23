package _04Methods.Exercise;
import java.util.Scanner;

public class _03CharacterRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);

        printCharASCII(one, two);
        scanner.close();
    }

    public static void printCharASCII(char start, char end) {
        if (start > end) {

            char buff = start;
            start = end;
            end = buff;
        }

        for (char ch = (char)(start + 1); ch < end; ch++) {
            System.out.print(ch + " ");
        }
    }
}
