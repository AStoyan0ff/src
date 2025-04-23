package _19FinalExamPreparation;
import java.util.Scanner;

public class _11SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //85 / 100

        String message = scanner.nextLine();

        String command;
        while (!(command = scanner.nextLine()).equals("Reveal")) {
            String[] commandParts = command.split(":\\|:");

            String action = commandParts[0];

            switch (action) {

                case "InsertSpace":

                    int index = Integer.parseInt(commandParts[1]);
                    message = insertSpace(message, index);

                    System.out.println(message);
                    break;

                case "Reverse":

                    String substring = commandParts[1];
                    String result = reverseSubstring(message, substring);

                    if (result.equals("error")) {
                        System.out.println("error");
                    }
                    else {
                        message = result;
                        System.out.println(message);
                    }
                    break;

                case "ChangeAll":

                    String oldSubstring = commandParts[1];
                    String replacement = commandParts[2];

                    message = changeAll(message, oldSubstring, replacement);
                    System.out.println(message);

                    break;

                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }

        System.out.println("You have a new text message: " + message);
    }

    private static String insertSpace(String message, int index) {
        return message.substring(0, index) + " " + message.substring(index);
    }

    private static String reverseSubstring(String message, String substring) {
        int index = message.indexOf(substring);

        if (index != -1) {
            String before = message.substring(0, index);
            String after = message.substring(index + substring.length());
            String reverseBuffer = new StringBuilder(substring).reverse().toString();
            return before + after + reverseBuffer;
        }
        else {
            return "error";
        }
    }

    private static String changeAll(String message, String oldSubstring, String replacement) {
        return message.replace(oldSubstring, replacement);
    }
}