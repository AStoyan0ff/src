package _19FinalExamPreparation;
import java.util.Scanner;

public class _13PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String cmd;
        while (!(cmd = scanner.nextLine()).equals("Done")) {
            String [] cmdParts = cmd.split(" ");

            String action = cmdParts[0];

            switch (action) {

                case "TakeOdd":

                    password = takeOdd(password);
                    System.out.println(password);

                    break;

                case "Cut":

                    int idx = Integer.parseInt(cmdParts[1]);
                    int size = Integer.parseInt(cmdParts[2]);
                    password = cutPass(password, idx, size);

                    System.out.println(password);
                    break;

                case "Substitute":

                    String subStr = cmdParts[1];
                    String substitute = cmdParts[2];

                    if (password.contains(subStr)) {
                        password = password.replace(subStr, substitute);

                        System.out.println(password);
                    }
                    else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }
        System.out.println("Your password is: " + password);
    }

    private static String takeOdd(String password) {
        StringBuilder buffer = new StringBuilder();

        for (int pos = 1; pos < password.length(); pos += 2) {
            buffer.append(password.charAt(pos));
        }
        return buffer.toString();
    }

    private static String cutPass(String password, int idx, int size) {
        String subStr = password.substring(idx, idx + size);

        return password.replaceFirst(subStr, "");
    }
}
