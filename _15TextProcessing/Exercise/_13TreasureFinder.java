package _15TextProcessing.Exercise;
import java.util.*;
import java.util.Scanner;

public class _13TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] key = new int[input.length];

        for (int pos = 0; pos < input.length; pos++) {
            key[pos] = Integer.parseInt(input[pos]);
        }

        while (true) {
            String cryptMsg = scanner.nextLine();

            if (cryptMsg.equals("find")) {
                break;
            }

            String decryptMsg = decryptMessage(cryptMsg, key);
            String type = extractType(decryptMsg);
            String coordinates = extractCoord(decryptMsg);

            System.out.printf("Found %s at %s\n", type, coordinates);
        }
        scanner.close();
    }

    public static String decryptMessage(String cryptMsg, int[] key) {

        StringBuilder buffer = new StringBuilder();
        int position = 0;

        for (int pos = 0; pos < cryptMsg.length(); pos++) {

            char decryptSymbol = (char) (cryptMsg.charAt(pos) - key[position]);
            buffer.append(decryptSymbol);

            position = (position + 1) % key.length;
        }
        return buffer.toString();
    }

    public static String extractType(String decryptMsg) {

        int start = decryptMsg.indexOf('&') + 1;
        int end = decryptMsg.indexOf('&', start);

        return decryptMsg.substring(start, end);
    }

    public static String extractCoord(String decryptMsg) {

        int start = decryptMsg.indexOf('<') + 1;
        int end = decryptMsg.indexOf('>', start);

        return decryptMsg.substring(start, end);
    }
}
