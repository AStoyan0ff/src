package _11AssociativeArrays.LaB;
import java.util.Scanner;
import java.util.*;

public class _03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] words = scanner.nextLine().toLowerCase().split(" ");
        Map<String, Integer> phenomenonMap = new LinkedHashMap<>();

        for (String word : words) {
            phenomenonMap
                    .put(word, phenomenonMap
                    .getOrDefault(word, 0) + 1);
        }
        ArrayList<String> oddOccurrences = new ArrayList<>();

        for (Map.Entry<String, Integer> input : phenomenonMap.entrySet()) {

            if (input.getValue() % 2 != 0) {
                oddOccurrences.add(input.getKey());
            }
        }
        System.out.println(String.join(", ", oddOccurrences));
    }
}
