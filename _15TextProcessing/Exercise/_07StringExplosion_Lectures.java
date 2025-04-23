package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _07StringExplosion_Lectures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder buffer = new StringBuilder(input);
        int totalPower = 0;

        for (int pos = 0; pos < buffer.length(); pos++) {
            char currChar = buffer.charAt(pos);

            if (currChar == '>') {
                int power = Integer.parseInt(buffer.charAt(pos + 1) + "");
                totalPower += power;

            }
            else if (totalPower > 0) {
                buffer.deleteCharAt(pos);
                totalPower--;

                pos--;
            }
        }
        System.out.println(buffer);
        scanner.close();
    }
}
