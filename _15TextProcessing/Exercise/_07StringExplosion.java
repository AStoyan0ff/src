package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(myDrinkExplosion(input));
    }
    private static String myDrinkExplosion(String text) {
        StringBuilder buffer = new StringBuilder();

        int power = 0;

        for (int pos = 0; pos < text.length(); pos++) {
            char currChar = text.charAt(pos);

            if (currChar == '>') {
                buffer.append(currChar);
                power += Character.getNumericValue(text.charAt(pos + 1));
            }
            else if (power > 0) {
                power--;
            }
            else {
                buffer.append(currChar);
            }
        }
        return buffer.toString();
        // Finish today... =)
    }
}
