package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _13MOBAChallengerSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersMap = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Season end")) {

            if (input.contains("->")) {
                String[] cmd = input.split(" -> ");

                if (cmd.length < 3) {
                    continue; // Пропускам грешен вход -> Just in case
                }

                String player = cmd[0];
                String position = cmd[1];
                int skills = Integer.parseInt(cmd[2]);

                playersMap.putIfAbsent(player, new HashMap<>());

                Map<String, Integer> positionMap = playersMap.get(player);
                positionMap.put(position, Math.max(positionMap.getOrDefault(position, 0), skills));

            }
            else if (input.contains("vs")) {
                String[] cmd = input.split(" vs ");

                if (cmd.length < 2) {
                    continue;
                }

                String firstPlayer = cmd[0];
                String secondPlayer = cmd[1];

                if (playersMap.containsKey(firstPlayer) && playersMap.containsKey(secondPlayer)) {

                    Set<String> positionSet = new HashSet<>(playersMap.get(firstPlayer).keySet());
                    positionSet.retainAll(playersMap.get(secondPlayer).keySet());

                    if (!positionSet.isEmpty()) {
                        int totalFirstSkills = getAllSkills(playersMap.get(firstPlayer));
                        int totalSecondSkills = getAllSkills(playersMap.get(secondPlayer));

                        if (totalFirstSkills > totalSecondSkills) {
                            playersMap.remove(secondPlayer);
                        }
                        else if (totalFirstSkills < totalSecondSkills) {
                            playersMap.remove(firstPlayer);
                        }
                    }
                }
            }
        }

        List<Map.Entry<String, Map<String, Integer>>> sortedList = new ArrayList<>(playersMap.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Map<String, Integer>>>() {

            @Override
            public int compare(Map.Entry<String, Map<String, Integer>> first, Map.Entry<String, Map<String, Integer>> second) {

                int totalFirstSkill = getAllSkills(first.getValue());
                int totalSecondSkill = getAllSkills(second.getValue());
                int skillCompare = Integer.compare(totalSecondSkill, totalFirstSkill);

                if (skillCompare != 0) {
                    return skillCompare;
                }
                return first.getKey().compareTo(second.getKey());
            }
        });

        for (Map.Entry<String, Map<String, Integer>> gamer : sortedList) {
            int totalSkill = getAllSkills(gamer.getValue());

            System.out.println(gamer.getKey() + ": " + totalSkill + " skill");

            List<Map.Entry<String, Integer>> sortedPositionList = new ArrayList<>(gamer.getValue().entrySet());
            Collections.sort(sortedPositionList, new Comparator<Map.Entry<String, Integer>>() {

                @Override
                public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second) {

                    int skillCompare = Integer.compare(second.getValue(), first.getValue());

                    if (skillCompare != 0) {
                        return skillCompare;
                    }
                    return first.getKey().compareTo(second.getKey());
                }
            });

            for (Map.Entry<String, Integer> pair : sortedPositionList) {
                System.out.println("- " + pair.getKey() + " <::> " + pair.getValue());
            }
        }

        scanner.close();
    }

    private static int getAllSkills(Map<String, Integer> index) {
        int totalSkill = 0;

        for (int skill : index.values()) {
            totalSkill += skill;
        }
        return totalSkill;
    }
}
