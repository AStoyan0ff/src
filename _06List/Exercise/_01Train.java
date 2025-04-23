package _06List.Exercise;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        /*String [] inputWagon = scanner.nextLine().split(" ");
        List <Integer> wagons = new ArrayList<>();

        for (String wagon : inputWagon) {
            wagons.add(Integer.parseInt(wagon));
        }*/

        int maxCap = Integer.parseInt(scanner.nextLine());

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            }
            // The startsWith() method checks whether a string starts with the specified character(s).
            // Use the endsWith() method to check whether a string ends with the specified character(s).

            /*Returns:	A boolean value:
            true - if the string starts with the specified character(s)
            false - if the string does not start with the specified character(s)*/

            if (command.startsWith("Add")) {
                int passengers = Integer.parseInt(command.split(" ")[1]);

                wagons.add(passengers);
            }
            else {
                int passenger = Integer.parseInt(command);

                for (int pos = 0; pos < wagons.size(); pos++) {
                    int currPass = wagons.get(pos);

                    if (currPass + passenger <= maxCap) {
                        wagons.set(pos, currPass + passenger);

                        break;
                    }
                }
            }
        }

        wagons
            .stream()
            .mapToInt(wagon -> wagon)
            .mapToObj(wagon -> wagon + " ")
            .forEach(System.out::print);

        scanner.close();
    }
}
