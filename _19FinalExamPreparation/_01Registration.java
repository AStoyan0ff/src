package _19FinalExamPreparation; // 01. Final Exam Retake
import java.util.Scanner;

public class _01Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        String cmd;

        while (!(cmd = scanner.nextLine()).equals("Registration")) {
            String[] cmdPart = cmd.split(" ");

            switch (cmdPart[0]) {
                case "Letters":

                    if (cmdPart[1].equals("Lower")) {
                        user = user.toLowerCase();
                    }
                    else if (cmdPart[1].equals("Upper")) {
                        user = user.toUpperCase();
                    }

                    System.out.println(user);
                    break;

                case "Reverse":

                    int start = Integer.parseInt(cmdPart[1]);
                    int end = Integer.parseInt(cmdPart[2]);

                    if (start >= 0 && end < user.length() && start <= end) {

                        String reverseString = new StringBuilder
                                (user.substring(start, end + 1)).reverse().toString();

                        System.out.println(reverseString);
                    }
                    break;

                case "Substring":

                    String subStr = cmdPart[1];

                    if (user.contains(subStr)) {
                        user = user.replace(subStr, "");
                        System.out.println(user);
                    }
                    else {
                        System.out.printf("The username %s doesn't contain %s.%n", user, subStr);
                    }
                    break;

                case "Replace":

                    char toReplace = cmdPart[1].charAt(0);
                    user = user.replace(toReplace, '-');

                    System.out.println(user);
                    break;

                case "IsValid":

                    char toCheck = cmdPart[1].charAt(0);

                    if (user.contains(String.valueOf(toCheck))) {
                        System.out.println("Valid username.");
                    }
                    else {
                        System.out.printf("%c must be contained in your username.%n", toCheck);
                    }
                    break;
            }
        }
        scanner.close();
        // 01. Programming Fundamentals Final Exam Retake
    }
}
