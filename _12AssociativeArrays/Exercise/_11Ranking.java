package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _11Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> tournamentMap = new HashMap<>();
        Map<String, Map<String, Integer>> usersMap = new TreeMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("end of contests")) {
            if (!input.contains(":")) continue;

            String[] data = input.split(":");

            if (data.length == 2) {
                tournamentMap.put(data[0], data[1]);
            }
        }

        while (!(input = scanner.nextLine()).equals("end of submissions")) {

            if (!input.contains("=>")) continue;
            String[] subData = input.split("=>");

            if (subData.length != 4) continue;

            String tournament = subData[0];
            String password = subData[1];
            String name = subData[2];
            int points;

            try {
                points = Integer.parseInt(subData[3]);
            }
            catch (NumberFormatException e) {
                continue;
            }

            if (tournamentMap.containsKey(tournament) && tournamentMap.get(tournament).equals(password)) {
                usersMap.putIfAbsent(name, new HashMap<>());

                Map<String, Integer> userContests = usersMap.get(name);
                userContests.put(tournament, Math.max(userContests.getOrDefault(tournament, 0), points));
            }
        }

        String winner = "";
        int maxPoints = 0;

        for (String user : usersMap.keySet()) {
            int totalPoints = 0;

            for (int points : usersMap.get(user).values()) {
                totalPoints += points;
            }
            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                winner = user;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", winner, maxPoints);
        System.out.println("Ranking:");

        for (String user : usersMap.keySet()) {
            System.out.println(user);

            List<Map.Entry<String, Integer>> sortedMap = new ArrayList<>(usersMap.get(user).entrySet());

            Collections.sort(sortedMap, (a, b) ->
                    Integer.compare(b.getValue(), a.getValue()));

            for (Map.Entry<String, Integer> pair : sortedMap) {
                System.out.printf("#  %s -> %d%n", pair.getKey(), pair.getValue());
            }
        }
    }
}
