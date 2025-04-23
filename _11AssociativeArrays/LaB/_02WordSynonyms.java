package _11AssociativeArrays.LaB;
import java.util.*;

public class _02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wordsCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymsMap = new LinkedHashMap<>();

        for (int pos = 0; pos < wordsCount ; pos++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonymsMap.putIfAbsent(word, new ArrayList<>());
            synonymsMap.get(word).add(synonym);
        }
        scanner.close();

        for (Map.Entry<String, List<String>> input : synonymsMap.entrySet()) {
            System.out.println(input.getKey() + " - " + String.join(", ", input.getValue()));
        }
    }
}
