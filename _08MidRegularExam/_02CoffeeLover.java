package _08MidRegularExam;
import java.util.*;
import java.util.Scanner;

public class _02CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffeesList = new ArrayList<>(Arrays
                .asList(scanner.nextLine()
                .split(" ")));

        int input = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < input; pos++) {
            String[] commandParts = scanner.nextLine().split(" ");
            String command = commandParts[0];

            switch (command) {

                case "Include" -> includeCoffee
                        (coffeesList, commandParts[1]);

                case "Remove" -> removeCoffees

                        (coffeesList, commandParts[1], Integer
                                .parseInt(commandParts[2]));
                case "Prefer" ->

                        preferCoffees(coffeesList, Integer
                                .parseInt(commandParts[1]), Integer
                                .parseInt(commandParts[2]));

                case "Reverse" -> reverseCoffees(coffeesList);
            }
        }
        printCoffeesList(coffeesList);
    }

    public static void includeCoffee(List<String> coffees, String coffee) {
        coffees.add(coffee);
    }

    public static void removeCoffees(List<String> coffees, String position, int count) {

        if (count > coffees.size()) {
            return;
        }
        if (position.equals("first")) {
            coffees.subList(0, count).clear();
        }
        else if (position.equals("last")) {
            coffees.subList(coffees.size() - count, coffees.size()).clear();
        }
    }

    public static void preferCoffees(List<String> coffees, int pos1, int pos2) {

        if (pos1 >= 0 && pos1 < coffees.size() && pos2 >= 0 && pos2 < coffees.size()) {
            String buff = coffees.get(pos1);

            coffees.set(pos1, coffees.get(pos2));
            coffees.set(pos2, buff);
        }
    }

    public static void reverseCoffees(List<String> coffees) {
        List<String> reversed = new ArrayList<>();

        for (int i = coffees.size() - 1; i >= 0; i--) {
            reversed.add(coffees.get(i));
        }
        coffees.clear();
        coffees.addAll(reversed);
    }

    public static void printCoffeesList(List<String> coffees) {
        System.out.println("Coffees:");
        System.out.println(String.join(" ", coffees));
    }
}
