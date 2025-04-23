package _05List.Lab;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> digits = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        label:
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break label;
            }

            String[] parts = input.split(" ");
            String command = parts[0];

            if (command.equals("Contains")) {
                int number = Integer.parseInt(parts[1]);

                System.out.println(digits.contains(number)
                        ? "Yes"
                        : "No such number");
            }
            else if (command.equals("Print")) {
                String type = parts[1];

                if (type.equals("even")) {
                    digits
                        .stream()
                        .filter(n -> n % 2 == 0)
                        .forEach(n -> System.out.print(n + " "));

                    System.out.println();
                }
                else if (type.equals("odd")) {
                    digits
                        .stream()
                        .filter(n -> n % 2 != 0)
                        .forEach(n -> System.out.print(n + " "));

                    System.out.println();
                }
            }
            else if (command.equals("Get")) {
                if (parts[1].equals("sum")) {

                    int result = digits
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();

                    System.out.println(result);
                }
            }
            else if (command.equals("Filter")) {
                String condition = parts[1];
                int filterNumber = Integer.parseInt(parts[2]);

                if (condition.equals("<")) {
                    digits
                        .stream()
                        .filter(n -> n < filterNumber)
                        .forEach(n -> System.out.print(n + " "));

                    System.out.println();
                }
                else if (condition.equals(">")) {
                    digits
                        .stream()
                        .filter(n -> n > filterNumber)
                        .forEach(n -> System.out.print(n + " "));

                    System.out.println();
                }
                else if (condition.equals("<=")) {
                    digits
                        .stream()
                        .filter(n -> n <= filterNumber)
                        .forEach(n -> System.out.print(n + " "));

                    System.out.println();
                }
                else if (condition.equals(">=")) {
                    digits
                        .stream()
                        .filter(n -> n >= filterNumber)
                        .forEach(n -> System.out.print(n + " "));

                    System.out.println();
                }
            }
        }
    }
}
