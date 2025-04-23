package _20ExamPre.Lectures;
import java.util.Scanner;

public class _01ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());


        String command;
        while (!(command = scanner.nextLine()).equals("Generate")) {

            String[] parts = command.split(">>>");
            String action = parts[0];

            if (action.equals("Contains")) {
                String substring = parts[1];

                if (activationKey.toString().contains(substring)) {
                    System.out.println(activationKey + " contains " + substring);
                }
                else {
                    System.out.println("Substring not found!");
                }
            }
            else if (action.equals("Flip")) {

                String caseType = parts[1];
                int startIndex = Integer.parseInt(parts[2]);
                int endIndex = Integer.parseInt(parts[3]);

                String modifiedPart = activationKey.substring(startIndex, endIndex);

                if (caseType.equals("Upper")) {
                    modifiedPart = modifiedPart.toUpperCase();
                }
                else {
                    modifiedPart = modifiedPart.toLowerCase();
                }

                activationKey.replace(startIndex, endIndex, modifiedPart);
                System.out.println(activationKey);
            }
            else if (action.equals("Slice")) {

                int sliceStart = Integer.parseInt(parts[1]);
                int sliceEnd = Integer.parseInt(parts[2]);

                activationKey.delete(sliceStart, sliceEnd);
                System.out.println(activationKey);
            }
        }
        System.out.println("Your activation key is: " + activationKey);
        scanner.close();
    }
}
