package _21RegularFinalExam;
import java.util.*;
import java.util.Scanner;

public class _01DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        while (true) {
            String[] cmdParts = scanner.nextLine().split(" ");
            String cmd = cmdParts[0];

            if (cmd.equals("Finish")) {
                break;
            }

            switch (cmd) {

                case "Replace":

                    char currChar = cmdParts[1].charAt(0);
                    char newChar = cmdParts[2].charAt(0);

                    message = replaceChars(message, currChar, newChar);

                    System.out.println(message);
                    break;

                case "Cut":

                    int start = Integer.parseInt(cmdParts[1]);
                    int end = Integer.parseInt(cmdParts[2]);

                    message = cutSubStr(message, start, end);
                    break;

                case "Make":

                    String caseType = cmdParts[1];
                    message = makeCase(message, caseType);

                    System.out.println(message);
                    break;

                case "Check":

                    String substring = cmdParts[1];
                    checkSubStr(message, substring);
                    break;

                case "Sum":

                    start = Integer.parseInt(cmdParts[1]);
                    end = Integer.parseInt(cmdParts[2]);

                    sumASCII(message, start, end);
                    break;
            }
        }
    }

    private static String replaceChars(String message, char currChar, char newChar) {
        return message.replace(currChar, newChar);
    }

    private static String cutSubStr(String message, int start, int end) {

        if (isValid(message, start, end)) {

            String before = message.substring(0, start);
            String after = message.substring(end + 1);
            message = before + after;

            System.out.println(message);
        }
        else {
            System.out.println("Invalid indices!");
        }
        return message;
    }

    private static String makeCase(String message, String caseType) {

        if (caseType.equals("Upper")) {
            return message.toUpperCase();
        }
        else {
            return message.toLowerCase();
        }
    }

    private static void checkSubStr(String message, String substring) {

        if (message.contains(substring)) {
            System.out.println("Message contains " + substring);
        }
        else {
            System.out.println("Message doesn't contain " + substring);
        }
    }

    private static void sumASCII(String message, int start, int end) {

        if (isValid(message, start, end)) {
            String substring = message.substring(start, end + 1);
            int sum = 0;

            for (char c : substring.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
        }
        else {
            System.out.println("Invalid indices!");
        }
    }

    private static boolean isValid(String message, int start, int end) {
        return start >= 0 && end < message.length() && start <= end;

    }
}
