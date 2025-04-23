package _05List.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03MergingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> fitstList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int maxSize = Math.max(fitstList.size(), secondList.size());

        for (int pos = 0; pos < maxSize; pos++) {

            if (pos < fitstList.size()) {
                result.add(fitstList.get(pos));
            }

            if (pos < secondList.size()) {
                result.add(secondList.get(pos));
            }
        }

        result.forEach(num -> System.out.print(num + " "));

        scanner.close();
    }
}
