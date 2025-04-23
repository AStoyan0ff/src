package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder cryptBuffer = new StringBuilder();

        for (char sym : input.toCharArray()) {
            // Loop through each sym and move it 3 positions forward =)
            cryptBuffer.append((char) (sym + 3));
        }
        System.out.println(cryptBuffer);
        scanner.close();
    }
}
