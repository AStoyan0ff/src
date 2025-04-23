package _19FinalExamPreparation; // 02. Final Exam Retake
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05AdAstraGTC {

    public static List<FoodEntryClass> extractFood(String input) {

        List<FoodEntryClass> foodItems = new ArrayList<>();

        String regex = "([#|])(?<name>[A-Za-z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            String name = matcher.group("name");
            String expiryDate = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            foodItems.add(new FoodEntryClass(name, expiryDate, calories));
        }

        return foodItems;
    }

    public static int resultCalories(List<FoodEntryClass> foodItems) {
        int totalCalories = 0;

        for (FoodEntryClass item : foodItems) {
            totalCalories += item.calories;
        }
        return totalCalories;
    }

    static class FoodEntryClass {

        String name;
        String expiryDate;
        int calories;

        public FoodEntryClass(String name, String expiryDate, int calories) {

            this.name = name;
            this.expiryDate = expiryDate;
            this.calories = calories;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<FoodEntryClass> foodList = extractFood(input);

        int totalCalories = resultCalories(foodList);
        int days = totalCalories / 2000;

        System.out.println("You have food to last you for: " + days + " days!");

        for (FoodEntryClass item : foodList) {

            System.out.println
                    ("Item: " + item.name + ", " +
                            "Best before: " + item.expiryDate + ", " +
                            "Nutrition: " + item.calories);
        }
    }


}
