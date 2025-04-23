package _06List.Exercise;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05BombNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> specialBombNumber = Arrays
                .stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors
                .toList());

        String[] input = scanner.nextLine().split("\\s+");
        String bombNumber = input[0];

        int power = Integer.parseInt(input[1]);

        while (specialBombNumber.contains(bombNumber)) {
            int elementIndex = specialBombNumber.indexOf(bombNumber);

            int start = elementIndex - power;
            if (start < 0) {
                start = 0;
            }

            int end = elementIndex + power;
            if (end > specialBombNumber.size() - 1) {
                end = specialBombNumber.size() - 1;
            }

            if (end >= start) {
                specialBombNumber
                        .subList(start, end + 1)
                        .clear();
            }
        }

        System.out.println(specialBombNumber
                .stream()
                .mapToInt(Integer::parseInt)
                .sum());
    }
}
