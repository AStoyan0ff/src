package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _15DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, Dragon>> dragonMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos ++) {
            String [] cmdParts = scanner.nextLine().split(" ");

            String cmd = cmdParts[0];
            String name = cmdParts[1];

            Integer damage = statistic(cmdParts.length > 2 ? cmdParts[2] : null);
            Integer health = statistic(cmdParts.length > 3 ? cmdParts[3] : null);
            Integer shield = statistic(cmdParts.length > 4 ? cmdParts[4] : null);

            Dragon dragon = new Dragon(name, damage, health, shield);
            dragonMap.computeIfAbsent(cmd, a -> new TreeMap<>()).put(name, dragon);
        }

        printDragon(dragonMap);
    }

    private static Integer statistic(String stats) {

        if (stats == null || stats.equals("null")) {
            return null;
        }
        return Integer.parseInt(stats);
    }

    private static void printDragon(Map<String, TreeMap<String, Dragon>> dragonMap) {
        for (Map.Entry<String, TreeMap<String, Dragon>> pair : dragonMap.entrySet()) {

            String style = pair.getKey();
            Collection<Dragon> dragons = pair.getValue().values();

            double avgDamage = dragons
                    .stream().mapToInt(Dragon::getDamage)
                    .average().orElse(0);

            double avgHealth = dragons
                    .stream().mapToInt(Dragon:: getHealth)
                    .average().orElse(0);

            double avgShield = dragons
                    .stream().mapToInt(Dragon:: getShield).average()
                    .orElse(0);

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                    style,
                    avgDamage,
                    avgHealth,
                    avgShield);

            for (Dragon dragon : dragons) {

                System.out.printf("-%s -> damage: %s, health: %s, armor: %s\n",
                        dragon.getName(),
                        dragon.getDamage(),
                        dragon.getHealth(),
                        dragon.getShield());
            }
        }
    }

    static class Dragon {

        private String name;
        private int damage;
        private int health;
        private int shield;

        public Dragon(String name, Integer damage, Integer health, Integer shield) {

            this.name = name;
            this.damage = damage != null ? damage : 45;
            this.health = health != null ? health : 250;
            this.shield = shield != null ? shield : 10;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public int getShield() {
            return shield;
        }
    }
}
