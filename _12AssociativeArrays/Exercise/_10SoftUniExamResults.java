package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> scoresMap = new LinkedHashMap<>();
        Map<String, Integer> languagesMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("exam finished")) {

            String[] cmd = input.split("-");
            String name = cmd[0];

            if (cmd[1].equals("banned")) {
                scoresMap.remove(name);            }
            else {
                String language = cmd[1];
                int points = Integer.parseInt(cmd[2]);

                scoresMap.put(name, Math.max(scoresMap.getOrDefault(name, 0), points));
                languagesMap.put(language, languagesMap.getOrDefault(language, 0) + 1);
            }
        }

        System.out.println("Results:");

        scoresMap.forEach((user, points) ->
                System.out.println(user + " | " + points));

        System.out.println("Submissions:");

        languagesMap.forEach((language, count) ->
                System.out.println(language + " - " + count));

        scanner.close();
    }
}