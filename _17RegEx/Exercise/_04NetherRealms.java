package _17RegEx.Exercise;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] demonNames = scanner.nextLine().split("\\s*,\\s*");
        Map<String, Demon> demonsMap = new LinkedHashMap<>();

        for (String name : demonNames) {

            int health = resultHealth(name);
            double damage = resultDamage(name);
            demonsMap.put(name, new Demon(name, health, damage));
        }

        for (Demon currDemon : demonsMap.values()) {

            System.out.printf("%s - %d health, %.2f damage%n",
                    currDemon.name, currDemon.health, currDemon.damage);

            scanner.close();
        }
    }

    public static int resultHealth(String name) {
        int health = 0;

        for (char c : name.toCharArray()) {
            if (!Character.isDigit(c) && "+-*/.".indexOf(c) == -1) {
                health += c;
            }
        }
        return health;
    }

    public static double resultDamage(String name) {
        double damage = 0.0;

        Pattern numberPattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        Matcher matcher = numberPattern.matcher(name);

        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }

        for (char c : name.toCharArray()) {

            if (c == '*') {
                damage *= 2;
            }
            else if (c == '/') {
                damage /= 2;
            }
        }
        return damage;
    }

    static class Demon {

        String name;
        int health;
        double damage;

        public Demon(String name, int health, double damage) {

            this.name = name;
            this.health = health;
            this.damage = damage;
        }
    }
}
