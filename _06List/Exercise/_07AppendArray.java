package _06List.Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07AppendArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arrays = input.split("\\|");

        List<Integer> result = new ArrayList<>();

        for (int pos = arrays.length - 1; pos >= 0; pos--) {

            String array = arrays[pos].trim();
            String[] digits = array.split("\\s+");

            for (String number : digits) {

                if (!number.isEmpty()) {
                    result.add(Integer.parseInt(number));
                }
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
