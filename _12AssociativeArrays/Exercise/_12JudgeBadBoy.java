package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _12JudgeBadBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> tournamentMap = new LinkedHashMap<>();
        Map<String, Integer> statisticsMap = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("no more time")) {
            String[] cmd = input.split(" -> ");

            String user = cmd[0].trim();
            String tournament = cmd[1].trim();
            int points = Integer.parseInt(cmd[2].trim());

            tournamentMap.putIfAbsent(tournament, new HashMap<>());
            tournamentMap.get(tournament).merge(user, points, Math::max);
        }

        for (Map<String, Integer> player : tournamentMap.values()) {
            for (Map.Entry<String, Integer> pair : player.entrySet()) {

                String user = pair.getKey();
                int points = pair.getValue();
                statisticsMap.merge(user, points, Integer::sum);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> pair : tournamentMap.entrySet()) {
            String tournament = pair.getKey();

            Map<String, Integer> playersMap = pair.getValue();
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(playersMap.entrySet());

            sortedList.sort((a, s) -> {
                int result = Integer.compare(s.getValue(), a.getValue());

                if (result == 0) {
                    return a.getKey().compareTo(s.getKey());
                }
                return result;
            });

            System.out.printf("%s: %s participants\n", tournament, sortedList.size());
            int pos = 1;

            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.printf("%s. %s <::> %s\n", pos++, entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Individual standings:");

        List<Map.Entry<String, Integer>> finalList = new ArrayList<>(statisticsMap.entrySet());

        finalList.sort((a, s) -> {
            int result = Integer.compare(s.getValue(), a.getValue());

            if (result == 0) {
                return a.getKey().compareTo(s.getKey());
            }
            return result;
        });

        int pos = 1;

        for (Map.Entry<String, Integer> pair : finalList) {
            System.out.printf("%s. %s -> %s\n", pos++, pair.getKey(), pair.getValue());
        }
        scanner.close();
    }
}
