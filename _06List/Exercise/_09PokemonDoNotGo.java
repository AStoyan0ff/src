package _06List.Exercise;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> DigitsList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!DigitsList.isEmpty()) {
            int position = Integer.parseInt(scanner.nextLine());

            if (position < 0) {

                int firstElement = DigitsList.get(0);
                DigitsList.remove(0);
                sum += firstElement;

                int lastElement = DigitsList.get(DigitsList.size() - 1);
                DigitsList.add(0, lastElement);

                modifyList(DigitsList, firstElement);
            }
            else if (position > DigitsList.size() - 1) {

                int lastElement = DigitsList.get(DigitsList.size() - 1);
                DigitsList.remove(DigitsList.size() - 1);
                sum += lastElement;

                int firstElement = DigitsList.get(0);
                DigitsList.add(firstElement);

                modifyList(DigitsList, lastElement);
            }
            else {
                int elementForRemove = DigitsList.get(position);
                DigitsList.remove(position);
                sum += elementForRemove;

                modifyList(DigitsList, elementForRemove);
            }
        }
        System.out.println(sum);
    }

    private static void modifyList (List<Integer> numbers, int removedElement) {

        for (int position = 0; position <= numbers.size() - 1; position++) {
            int currentElement = numbers.get(position);

            if (currentElement <= removedElement) {
                currentElement += removedElement;
            }
            else {
                currentElement -= removedElement;
            }
            numbers.set(position, currentElement);
        }
    }
}
