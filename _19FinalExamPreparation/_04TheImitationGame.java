package _19FinalExamPreparation; // 02.  Final Exam Retake
import java.util.Scanner;

public class _04TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder buffer = new StringBuilder(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Decode")) {
                break;
            }

            String[] cmdParts = input.split("\\|");
            String cmd = cmdParts[0];

            switch (cmd) {

                case "Move":

                    int N = Integer.parseInt(cmdParts[1]);
                    moveWord(buffer, N);

                    break;

                case "Insert":

                    int index = Integer.parseInt(cmdParts[1]);
                    String value = cmdParts[2];

                    insertVal(buffer, index, value);
                    break;

                case "ChangeAll":

                    String subStr = cmdParts[1];
                    String replacement = cmdParts[2];

                    changeAll(buffer, subStr, replacement);
                    break;

                default:

                    System.out.println
                            ("Invalid command: " + cmd);
                    break;
            }
        }
        System.out.println
                ("The decrypted message is: " + buffer);
    }

    public static void moveWord
            (StringBuilder buff, int N) {

        String movePart = buff.substring(0, N);
        buff.delete(0, N);
        buff.append(movePart);
    }

    public static void insertVal
            (StringBuilder buff, int idx, String value) {

        buff.insert(idx, value);
    }

    public static void changeAll
            (StringBuilder buff, String subStr, String replaces) {

        String updatedMsg =
                buff.toString().replace(subStr, replaces);


        buff.setLength(0); // Clear StringBuilder (buffer)
        buff.append(updatedMsg);
    }
}
