package _07ExamPreparation;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.awt.AWTEventMulticaster.add;


public class _03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> movingTarget = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] commandParts = input.split(" ");
            String command = commandParts[0];
            int position = Integer.parseInt(commandParts[1]);

            switch (command) {
                case "Shoot" -> {
                    int power = Integer.parseInt(commandParts[2]);

                    shoot(movingTarget, position, power);
                }
                case "Add" -> {
                    int value = Integer.parseInt(commandParts[2]);

                    add(movingTarget, position, value);
                }
                case "Strike" -> {
                    int radius = Integer.parseInt(commandParts[2]);

                    strike(movingTarget, position, radius);
                }
            }

        }

        System.out.print(movingTarget
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining("|")));

        scanner.close();
    }

    private static boolean isValidIndex(List<Integer> targets, int index) {
        return index >= 0 && index < targets.size();
    }

    private static void shoot(List<Integer> movingTarget, int index, int power) {
        if (isValidIndex(movingTarget, index)) {
            movingTarget.set(index, movingTarget.get(index) - power);

            if (movingTarget.get(index) <= 0) {
                movingTarget.remove(index);
            }
        }
    }

    private static void add(List<Integer> movingTarget, int index, int value) {
        if (isValidIndex(movingTarget, index)) {
            movingTarget.add(index, value);
        }
        else {
            System.out.println("Invalid placement!");
        }
    }

    private static void strike(List<Integer> movingTarget, int index, int radius) {

        int left = index - radius;
        int right = index + radius;

        if (left >= 0 && right < movingTarget.size()) {

            if (right >= left) {
                movingTarget.subList(left, right + 1).clear();
            }
        }
        else {
            System.out.println("Strike missed!");
        }
    }
}
