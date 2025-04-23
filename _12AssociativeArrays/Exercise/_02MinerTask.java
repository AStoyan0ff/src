package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _02MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            resourcesMap
                    .put(input, resourcesMap.getOrDefault(input, 0) + quantity);

        }

        for (Map.Entry<String, Integer> input : resourcesMap.entrySet()) {
            System.out.println(input.getKey() + " -> " + input.getValue());


            /*String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " -> " + value);*/

        }
    }
}
