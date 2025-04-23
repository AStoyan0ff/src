package _19FinalExamPreparation; // 01. Final Exam Retake
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03BakeryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> storeMap = new LinkedHashMap<>();
        int totalSells = 0;

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("Complete")) {
                break;
            }

            String[] cmdParts = input.split(" ");

            if (cmdParts.length < 3) {
                continue;
            }

            String cmd = cmdParts[0];
            int quantity = Integer.parseInt(cmdParts[1]);
            String food = cmdParts[2];

            if (cmd.equals("Receive")) {

                receiveFood(storeMap, quantity, food);
            }
            else if (cmd.equals("Sell")) {

                totalSells += sellFood(storeMap, quantity, food);
            }
        }

        for (Map.Entry<String, Integer> entry : storeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("All sold: " + totalSells + " goods");
    }

    public static void receiveFood(Map<String, Integer> storeMap, int quantity, String food) {

        if (quantity <= 0) {
            return;
        }
        storeMap.put(food, storeMap.getOrDefault(food, 0) + quantity);
    }

    public static int sellFood(Map<String, Integer> storeMap, int quantity, String food) {

        if (!storeMap.containsKey(food)) {
            System.out.println("You do not have any " + food + ".");

            return 0; // No sale made
        }

        int avQuantity = storeMap.get(food);

        if (avQuantity < quantity) {
            System.out.println
                    ("There aren't enough " + food + ". You sold the last " + avQuantity + " of them.");

            storeMap.remove(food); // Remove food from Storage
            return avQuantity; // Return the sell quantity
        }
        else {

            System.out.println("You sold " + quantity + " " + food + ".");
            storeMap.put(food, avQuantity - quantity); // Update Storage

            if (storeMap.get(food) == 0) {
                storeMap.remove(food);
            }
            return quantity;
        }
    }
}
