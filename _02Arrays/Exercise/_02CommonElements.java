package _02Arrays.Exercise;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrOne = scanner.nextLine().split(" ");
        String[] arrTwo = scanner.nextLine().split(" ");

        System.out.println(findElements(arrOne, arrTwo));
    }

    private static String findElements(String[] arrOne, String[] arrTwo) {

        Set<String> setOne = new HashSet<>(Arrays.asList(arrOne));
        Set<String> common = new HashSet<>();

        for (String element : arrTwo) {

            if (setOne.contains(element)) {
                common.add(element);
            }
        }
        return String.join(" ", common);
    }
}
