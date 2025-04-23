package _06List.Exercise;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String cmd = scanner.nextLine();
        while (!cmd.equals("end")) {

            if (cmd.contains("Delete")) {
                int currDigit = Integer.parseInt(cmd.split(" ")[1]);

                numbers.removeAll(List.of(currDigit)); //премахва всички срещания на повтарящ се елемет
            }
            else if (cmd.contains("Insert")) {

                int digitInsert = Integer.parseInt(cmd.split(" ")[1]);
                int pos = Integer.parseInt(cmd.split(" ")[2]);

                numbers.add(pos, digitInsert);
            }
            cmd = scanner.nextLine();
        }
        numbers
                .stream()
                .mapToInt(num -> num)   // forEach new methods
                .mapToObj(num -> num + " ")
                .forEach(System.out::print);

        scanner.close();
    }
}
