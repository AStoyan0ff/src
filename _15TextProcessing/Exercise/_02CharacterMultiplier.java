package _15TextProcessing.Exercise;
import java.util.Scanner;
// AStoyanoff
public class _02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String first = input[0];
        String second = input[1];

        System.out.println(characterResults(first, second));
    }

    private static int characterResults(String strOne, String strTwo) {
        int result = 0;
        int minSize = Math.min(strOne.length(), strTwo.length());

        StringBuilder firstBuffer = new StringBuilder(strOne);
        StringBuilder secondBuffer = new StringBuilder(strTwo);

        // Multiply symbols and add ()
        for (int idx = 0; idx < minSize; idx++) {
            result += firstBuffer.charAt(idx) * secondBuffer.charAt(idx);
        }

        // Add the remaining characters from the longer word
        for (int pos = minSize; pos < firstBuffer.length(); pos++) {
            result += firstBuffer.charAt(pos);
        }
        for (int indx = minSize; indx < secondBuffer.length(); indx++) {
            result += secondBuffer.charAt(indx);
        }

        return result;
    }
}
