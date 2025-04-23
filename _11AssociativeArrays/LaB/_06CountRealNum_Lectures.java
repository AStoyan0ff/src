package _11AssociativeArrays.LaB;
import java.util.*;
import java.util.Scanner;

public class _06CountRealNum_Lectures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbersArr = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> myMap = new TreeMap<>();

        for (int number : numbersArr) {

            if (!myMap.containsKey(number)) {
                myMap.put(number, 1);
            }
            else {
                int currNumber = myMap.get(number);
                myMap.put(number, currNumber + 1);
            }
        }

        for (Map.Entry<Integer, Integer> pair : myMap.entrySet()) {
            System.out.println(pair.getKey() + " -> " + pair.getValue());

            // System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
        // Lectures solution
    }
}
