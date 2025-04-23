package _02Arrays.Exercise;
import java.util.Arrays;
import java.util.Scanner;

public class _05ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arrayModifier = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String [] temp = input.split(" ");
            String operation = temp[0];

            switch (operation) {
                case "swap":

                    int pos = Integer.parseInt(temp[1]);
                    int pos2 = Integer.parseInt(temp[2]);
                    int curr = arrayModifier[pos];

                    arrayModifier[pos] = arrayModifier[pos2];
                    arrayModifier[pos2] = curr;
                    break;

                case "multiply":

                    pos = Integer.parseInt(temp[1]);
                    pos2 = Integer.parseInt(temp[2]);
                    arrayModifier[pos] *= arrayModifier[pos2];
                    break;

                case "decrease":

                    for (int i = 0; i < arrayModifier.length; i++) {
                        arrayModifier[i] -= 1;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(Arrays
                .toString(arrayModifier)
                .replaceAll("[\\[\\]]", ""));

        scanner.close();
    }
}
