package _11AssociativeArrays.LaB;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        Map<Integer, Integer> digitCount = new TreeMap<>();

        for (String num : input) {
           int number = Integer.parseInt(num);

            digitCount.put(number, digitCount.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> attempt : digitCount.entrySet()) {
            System.out.println(attempt.getKey() + " -> " + attempt.getValue());
        }
    }
}
