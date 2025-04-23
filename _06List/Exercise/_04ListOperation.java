package _06List.Exercise;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04ListOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> operationList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String cmd = scanner.nextLine();

        while (!cmd.equals("End")) {
            String[] commandParts = cmd.split(" ");
            String name = commandParts[0];

            switch (name) {
                case "Add" -> {

                    int digitAdd = Integer.parseInt(commandParts[1]);
                    operationList.add(digitAdd);
                }

                case "Insert" -> {

                    int digitInsert = Integer.parseInt(commandParts[1]);
                    int indexInsertion = Integer.parseInt(commandParts[2]);

                    if (indexInsertion >=  0 && indexInsertion <= operationList.size() - 1) {
                        operationList.add(indexInsertion, digitInsert);
                    }
                    else {
                        System.out.println("Invalid index");
                    }

                }

                case "Remove" -> {

                    int indexRemove = Integer.parseInt(commandParts[1]);

                    if (indexRemove >= 0 && indexRemove <= operationList.size() - 1) {
                        operationList.remove(indexRemove);
                    }
                    else {
                        System.out.println("Invalid index");
                    }

                }

                case "Shift" -> {

                    String index = commandParts[1];
                    int count = Integer.parseInt(commandParts[2]);

                    if (index.equals("left")) {

                        for (int i = 1; i <= count; i++) {

                            int firstNumber = operationList.getFirst();

                            operationList.removeFirst();
                            operationList.add(firstNumber);
                        }
                    }
                    else if (index.equals("right")) {

                        for (int i = 1; i <= count ; i++) {

                            int lastNumber = operationList.getLast();
                            operationList.removeLast();
                            operationList.addFirst(lastNumber);
                        }

                    }
                }
            }
            cmd = scanner.nextLine();
        }

        for (int number : operationList) {
            System.out.print(number + " ");
        }
    }
}
