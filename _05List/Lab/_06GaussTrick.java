package _05List.Lab;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> digits = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = sumList(digits);

        for (int pos = 0; pos < result.size(); pos++) {
            System.out.print(result.get(pos));

            if (pos < result.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static List<Integer> sumList(List<Integer> digits) {

        List<Integer> result = new ArrayList<>();

        int leftSum = 0;
        int rightSum = digits.size() - 1;

        while (leftSum <= rightSum) {

            if (leftSum == rightSum) {
                result.add(digits.get(leftSum));
            }
            else {
                result.add(digits.get(leftSum) + digits.get(rightSum));
            }
            leftSum++;
            rightSum--;
        }
        return result;
    }
}
