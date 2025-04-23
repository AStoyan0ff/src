package _17RegEx.Exercise;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<String> attackList = new ArrayList<>();
        List<String> destroyList = new ArrayList<>();

        String regEx = "@(?<planet>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attack>[AD])![^@!:>-]*->(?<soldiers>\\d+)";
        Pattern pattern = Pattern.compile(regEx);

        for (int i = 0; i < N; i++) {
            String encryptMsg = scanner.nextLine();

            int decryptKey = 0;
            for (char c : encryptMsg.toLowerCase().toCharArray()) {

                if (c == 's' || c == 't' || c == 'a' || c == 'r') {
                    decryptKey++;
                }
            }

            StringBuilder decryptMsg = new StringBuilder();

            for (char symbol : encryptMsg.toCharArray()) {
                decryptMsg.append((char) (symbol - decryptKey));
            }

            Matcher matcher = pattern.matcher(decryptMsg.toString());
            if (matcher.find()) {

                String planet = matcher.group("planet");
                String population = matcher.group("population");
                String attack = matcher.group("attack");
                String soldiers = matcher.group("soldiers");

                if (planet != null && population != null && attack != null && soldiers != null) {

                    if (attack.equals("A")) {
                        attackList.add(planet);
                    }
                    else if (attack.equals("D")) {
                        destroyList.add(planet);
                    }
                }
            }
        }

        Collections.sort(attackList);
        Collections.sort(destroyList);

        System.out.println("Attacked planets: " + attackList.size());
        attackList.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyList.size());
        destroyList.forEach(planet -> System.out.println("-> " + planet));
    }
}
