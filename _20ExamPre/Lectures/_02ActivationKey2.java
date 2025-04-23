package _20ExamPre.Lectures;
import java.util.Scanner;

public class _02ActivationKey2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder buffer = new StringBuilder(scanner.nextLine());
        String cmd = scanner.nextLine();

        while (!cmd.equals("Generate")) {
            String[] cmdParts = cmd.split(">>>");
            String name = cmdParts[0];

            if (name.equals("Contains")) {
                String textCheck = cmdParts[1].trim();

                if (buffer.indexOf(textCheck) != -1) {
                    System.out.println(buffer + " contains " + textCheck);
                }
                else {
                    System.out.println("Substring not found!");
                }
            }
            else if (name.equals("Flip")) {

                String type = cmdParts[1].trim();
                int startIdx = Integer.parseInt(cmdParts[2].trim());
                int endIdx = Integer.parseInt(cmdParts[3].trim());

                for (int pos = startIdx; pos < endIdx; pos++) {
                    char c = buffer.charAt(pos);

                    if (type.equals("Upper")) {
                        buffer.setCharAt(pos, Character.toUpperCase(c));
                    }
                    else if (type.equals("Lower")) {
                        buffer.setCharAt(pos, Character.toLowerCase(c));
                    }
                }
                System.out.println(buffer);
            }
            else if (name.equals("Slice")) {

                int start = Integer.parseInt(cmdParts[1].trim());
                int end = Integer.parseInt(cmdParts[2].trim());

                buffer.delete(start, end);
                System.out.println(buffer);
            }
            cmd = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + buffer);
    }
}
