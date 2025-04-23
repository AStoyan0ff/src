package _05List.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02RemoveNegativeReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> negativeDigits = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        negativeDigits.removeIf(N -> N < 0);

        Collections.reverse(negativeDigits);

        if (negativeDigits.isEmpty()) {
            System.out.println("empty");
        }
        else {
            System.out.println(negativeDigits.toString().replaceAll("[\\[\\],]", ""));
        }
        scanner.close();
    }
}
