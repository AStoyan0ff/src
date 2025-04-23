package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _14MOBAChallengerAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersMap = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Season end")) {

            if (input.contains("->")) {
                String[] cmd = input.split(" -> ");

                String player = cmd[0];
                String position = cmd[1];
                int skill = Integer.parseInt(cmd[2]);

                playersMap.putIfAbsent(player, new HashMap<>());
                playersMap.get(player).put(position, Math.max(playersMap.get(player).getOrDefault(position, 0), skill));

            }
            else if (input.contains("vs")) {
                // Battle time
                String[] cmd = input.split(" vs ");
                String firstPlayer = cmd[0];
                String secondPlayer = cmd[1];

                if (playersMap.containsKey(firstPlayer) && playersMap.containsKey(secondPlayer)) {

                    Set<String> positionsSet = new HashSet<>(playersMap.get(firstPlayer).keySet());
                    positionsSet.retainAll(playersMap.get(secondPlayer).keySet());

                    if (!positionsSet.isEmpty()) {

                        int totalFirstSkill = playersMap
                                .get(firstPlayer).values().stream()
                                .mapToInt(Integer::intValue).sum();

                        int totalSecondSkill = playersMap
                                .get(secondPlayer).values().stream()
                                .mapToInt(Integer::intValue).sum();

                        if (totalFirstSkill > totalSecondSkill) {
                            playersMap.remove(secondPlayer);
                        }
                        else if (totalFirstSkill < totalSecondSkill) {
                            playersMap.remove(firstPlayer);
                        }
                    }
                }
            }
        }

        // Sorted result - > used Lambda & Stream API - It's very hard to me (for the moment) =)
        playersMap
                .entrySet()
                .stream()
                .sorted((first, second) -> {

                    int skillCompare = Integer.compare(
                            second
                                    .getValue()
                                    .values()
                                    .stream()
                                    .mapToInt(Integer::intValue)
                                    .sum(),

                            first
                                    .getValue()
                                    .values()
                                    .stream()
                                    .mapToInt(Integer::intValue)
                                    .sum());

                    return skillCompare != 0 ? skillCompare : first.getKey().compareTo(second.getKey());
                })
                .forEach(player -> {
                    int totalSkill = player
                            .getValue().values().stream()
                            .mapToInt(Integer::intValue).sum();

                    System.out.println(player.getKey() + ": " + totalSkill + " skill");

                    player
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted((first, second) -> {
                                int skillCompare = Integer.compare(second.getValue(), first.getValue());

                                return skillCompare != 0 ? skillCompare : first.getKey().compareTo(second.getKey());
                            })
                            .forEach(position ->
                                    System.out.println("- " + position.getKey() + " <::> " + position.getValue()));
                });
    }
}
