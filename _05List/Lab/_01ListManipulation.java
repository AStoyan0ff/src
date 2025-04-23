package _05List.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01ListManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Integer> manipulationList = new ArrayList<>();

        for (String number : input) {
            manipulationList.add(Integer.parseInt(number));
        }

        while (true) {
            String cmnd = scanner.nextLine();

            if (cmnd.equals("end")) {
                break;
            }

            String[] parts = cmnd.split(" ");
            String attempt = parts[0];

            switch (attempt) {

                case "Add":
                    int digitAdd = Integer.parseInt(parts[1]);
                    manipulationList.add(digitAdd);
                    break;

                case "Remove":
                    int digitRemove = Integer.parseInt(parts[1]);
                    manipulationList.remove(Integer.valueOf(digitRemove));
                    break;

                case "RemoveAt":
                    int indexRemove = Integer.parseInt(parts[1]);
                    manipulationList.remove(indexRemove);
                    break;

                case "Insert":
                    int digitInsert = Integer.parseInt(parts[1]);
                    int digitIndex = Integer.parseInt(parts[2]);
                    manipulationList.add(digitIndex, digitInsert);
                    break;
            }
        }

        for (int num : manipulationList) {
            System.out.print(num + " ");
        }
    }
}
