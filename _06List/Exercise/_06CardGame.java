package _06List.Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        List<Integer> firstPlayer = new ArrayList<>();

        for (String card : firstInput) {
            firstPlayer.add(Integer.parseInt(card));
        }

        String[] secondInput = scanner.nextLine().split(" ");
        List<Integer> secondPlayer = new ArrayList<>();

        for (String card : secondInput) {
            secondPlayer.add(Integer.parseInt(card));
        }

        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {

            int firstPlayerCard = firstPlayer.removeFirst();
            int secondPlayerCard = secondPlayer.removeFirst();

            if (firstPlayerCard > secondPlayerCard) {

                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            }
            else if (secondPlayerCard > firstPlayerCard) {

                secondPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPlayerCard);
            }
        }

        if (firstPlayer.isEmpty()) {

            int sum = secondPlayer.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Second player wins! Sum: " + sum);
        }
        else {

            int sum = firstPlayer.stream().mapToInt(Integer::intValue).sum();
            System.out.println("First player wins! Sum: " + sum);
        }
    }
}
