package _03Methods.LaB;
import java.util.Scanner;

public class _09GreaterTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int" -> {

                int one = Integer.parseInt(scanner.nextLine());
                int two = Integer.parseInt(scanner.nextLine());

                System.out.println(getMax(one, two));
            }
            case "char" -> {

                char one = scanner.nextLine().charAt(0);
                char two = scanner.nextLine().charAt(0);

                System.out.println(getMax(one, two));
            }
            case "string" -> {

                String one = scanner.nextLine();
                String two = scanner.nextLine();

                System.out.println(getMax(one, two));
            }
        }
        scanner.close();
    }

    private static int getMax(int first, int second) {
        return Math.max(first, second);
    }

    private static char getMax(char first, char second) {
        return (char) Math.max(first, second);
    }

    private static String getMax(String first, String second) {
        return first.compareTo(second) > 0 ? first : second;


    }
}