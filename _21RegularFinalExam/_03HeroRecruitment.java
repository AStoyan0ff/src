package _21RegularFinalExam;
import java.util.*;
import java.util.Scanner;

public class _03HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> heroesMap = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String [] parts = input.split(" ");
            String command = parts[0];
            String heroName = parts[1];

            if (command.equals("Enroll")) {
                enrollHero(heroesMap, heroName);
            }
            else if (command.equals("Learn")) {
                String spellName = parts[2];

                learnSpell(heroesMap, heroName, spellName);
            }
            else if (command.equals("Unlearn")) {
                String spellName;
                spellName = parts[2];

                unlearnSpell(heroesMap, heroName, spellName);
            }
        }

        printHeroes(heroesMap);
    }

    private static void enrollHero(Map<String, Set<String>> heroes, String heroName) {

        if (heroes.containsKey(heroName)) {
            System.out.println(heroName + " is already enrolled.");
        }
        else {
            heroes.put(heroName, new LinkedHashSet<>());
        }
    }

    private static void learnSpell(Map<String, Set<String>> heroes, String heroName, String spellName) {

        if (!heroes.containsKey(heroName)) {

            System.out.println(heroName + " doesn't exist.");
            return;
        }

        Set<String> spellSet = heroes.get(heroName);

        if (spellSet.contains(spellName)) {
            System.out.println(heroName + " has already learnt " + spellName + ".");
        }
        else {
            spellSet.add(spellName);
        }
    }

    private static void unlearnSpell(Map<String, Set<String>> heroes, String heroName, String spellName) {

        if (!heroes.containsKey(heroName)) {

            System.out.println(heroName + " doesn't exist.");
            return;
        }

        Set<String> spellSet = heroes.get(heroName);

        if (!spellSet.contains(spellName)) {
            System.out.println(heroName + " doesn't know " + spellName + ".");
        }
        else {
            spellSet.remove(spellName);
        }
    }

    private static void printHeroes(Map<String, Set<String>> heroes) {
        System.out.println("Heroes:");

        for (Map.Entry<String, Set<String>> entry : heroes.entrySet()) {

            System.out.print("== " + entry.getKey() + ": ");
            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}
