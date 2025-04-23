package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryMap = new LinkedHashMap<>();

        legendaryMap.put("shards", 0);
        legendaryMap.put("fragments", 0);
        legendaryMap.put("motes", 0);

        Map<String, Integer> trashMap = new LinkedHashMap<>();

        boolean bReceived = false;
        String receiveItem = "";

        while (!bReceived) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int pos = 0; pos < input.length; pos += 2) {
                int quantity = Integer.parseInt(input[pos]);
                String item = input[pos + 1].toLowerCase();

                if (legendaryMap.containsKey(item)) {
                    legendaryMap.put(item, legendaryMap.get(item) + quantity);

                    if (legendaryMap.get(item) >= 250) {

                        receiveItem = getLegendaryItem(item);
                        legendaryMap.put(item, legendaryMap.get(item) - 250);

                        bReceived = true;
                        break;
                    }
                }
                else {
                    trashMap
                            .put(item, trashMap
                            .getOrDefault(item, 0) + quantity);
                }
            }
        }

        System.out.println(receiveItem + " obtained!");

        legendaryMap.forEach((item, amount) ->
                System.out.println(item + ": " + amount));

        trashMap.forEach((item, amount) ->
                System.out.println(item + ": " + amount));

        scanner.close();
    }

    private static String getLegendaryItem(String items) {

        if (items.equals("shards")) {
            return "Shadowmourne";
        }
        else if (items.equals("fragments")) {
            return "Valanyr";
        }
        else if (items.equals("motes")) {
            return "Dragonwrath";
        }
        return "";
    }
}
