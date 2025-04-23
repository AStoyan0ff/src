package _19FinalExamPreparation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _14HeroesCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroesMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {
            String[] dataParts = scanner.nextLine().split(" ");

            String name = dataParts[0];
            int hp = Integer.parseInt(dataParts[1]);
            int mp = Integer.parseInt(dataParts[2]);

            heroesMap.put(name, new Hero(name, hp, mp));
        }

        String cmd;
        while (!(cmd = scanner.nextLine()).equals("End")) {
            String[] cmdParts = cmd.split(" - ");

            if (cmdParts.length < 2) {
                System.out.println("Invalid command!");
                continue;
            }

            String action = cmdParts[0];
            String heroName = cmdParts[1];

            Hero hero = heroesMap.get(heroName);

            switch (action) {

                case "CastSpell":

                    if (cmdParts.length < 4) {
                        System.out.println("Invalid command!");

                        break;
                    }
                    int mpNeed = Integer.parseInt(cmdParts[2]);
                    String spellName = cmdParts[3];

                    hero.castSpell(mpNeed, spellName);
                    break;

                case "TakeDamage":

                    if (cmdParts.length < 4) {

                        System.out.println("Invalid command!");
                        break;
                    }
                    int damage = Integer.parseInt(cmdParts[2]);
                    String attack = cmdParts[3];

                    hero.takeDamage(damage, attack);

                    if (hero.getHp() <= 0) {
                        heroesMap.remove(heroName);
                    }
                    break;

                case "Recharge":

                    if (cmdParts.length < 3) {

                        System.out.println("Invalid command!");
                        break;
                    }
                    int amountRecharge = Integer.parseInt(cmdParts[2]);

                    hero.recharge(amountRecharge);
                    break;

                case "Heal":

                    if (cmdParts.length < 3) {

                        System.out.println("Invalid command!");
                        break;
                    }
                    int amountHeal = Integer.parseInt(cmdParts[2]);

                    hero.heal(amountHeal);
                    break;

                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }

        for (Hero hero : heroesMap.values()) {
            System.out.println(hero);
        }
    }
}

class Hero {

    private String name;
    private int hp;
    private int mp;

    public Hero(String name, int hp, int mp) {

        this.name = name;
        this.hp = Math.min(hp, 100); // Ограничаване на HP до максимум 100
        this.mp = Math.min(mp, 200); // Ограничаване на MP до максимум 200
    }

    public int getHp() {
        return hp;
    }

    public void castSpell(int mpNeed, String spellName) {

        if (mp >= mpNeed) {
            mp -= mpNeed;

            System.out.printf
                    ("%s has successfully cast %s and now has %d MP!%n", name, spellName, mp);
        }
        else {
            System.out.printf
                    ("%s does not have enough MP to cast %s!%n", name, spellName);
        }
    }

    public void takeDamage(int damage, String attack) {
        hp -= damage;

        if (hp > 0) {
            System.out.printf
                    ("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attack, hp);
        }
        else {
            System.out.printf
                    ("%s has been killed by %s!%n", name, attack);
        }
    }

    public void recharge(int amount) {

        int recover = Math.min(amount, 200 - mp);
        mp += recover;

        System.out.printf
                ("%s recharged for %d MP!%n", name, recover);
    }

    public void heal(int amount) {

        int recover = Math.min(amount, 100 - hp);
        hp += recover;

        System.out.printf
                ("%s healed for %d HP!%n", name, recover);
    }

    @Override
    public String toString() {
        return name + "\n  HP: " + hp + "\n  MP: " + mp;
    }
}