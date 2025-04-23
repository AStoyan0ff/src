package _07ExamPreparation;
import java.util.*;
import java.util.Scanner;

public class _02CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int countBattle = 0;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (energy >= distance) {
                energy -= distance;
                countBattle++;
            }
            else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countBattle, energy);
                return;
            }

            if (countBattle % 3 == 0) {
                energy += countBattle;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %s. Energy left: %s", countBattle, energy);
        scanner.close();
    }
}
