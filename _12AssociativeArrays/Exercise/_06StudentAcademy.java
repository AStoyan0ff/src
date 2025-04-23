package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentAcademyMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {
            String names = scanner.nextLine();
            double grades = Double.parseDouble(scanner.nextLine());

            //Check if the student already exists and if not - add him.
            studentAcademyMap.putIfAbsent(names, new ArrayList<>());
            studentAcademyMap.get(names).add(grades);
        }

        for (Map.Entry<String, List<Double>> pair : studentAcademyMap.entrySet()) {
            // find the average value
            double avrGrade = pair.getValue()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);

            // average grade higher or equal to 4.50
            if (avrGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", pair.getKey(), avrGrade);
            }
        }
        scanner.close();
    }
}
