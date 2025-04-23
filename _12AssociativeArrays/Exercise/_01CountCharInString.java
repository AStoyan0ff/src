package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _01CountCharInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> encountersMap = new LinkedHashMap<>();

        for (char currChar : input.toCharArray()) {

            if (currChar != ' ') {
                encountersMap.put
                        (currChar, encountersMap.getOrDefault(currChar, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> pair : encountersMap.entrySet()) {

            Character key = pair.getKey();
            Integer value = pair.getValue();

            System.out.println(key + " -> " + value);
        }
    }
}
