package _02Arrays.Exercise;
import java.util.Arrays;
import java.util.Scanner;

public class _04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] arrayRotation = Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int opertation = Integer.parseInt(scanner.nextLine());

        opertation = opertation % arrayRotation.length;

        for (int pos = 0; pos < opertation; pos++) {
            findElements(arrayRotation);
        }

        System.out.println(Arrays.toString(arrayRotation)
                .replaceAll("[\\[\\],]", ""));
    }

    private static void findElements(int[] array) {
        int firstElement = array[0];

        System.arraycopy(array, 1, array, 0, array.length - 1);

        array[array.length - 1] = firstElement;
    }
}
