package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _05Courses_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String [] command = input.split(" \\:");
            String names = command[0];     // Key
            String students = command[1]; // Value

            if (!courseMap.containsKey(names)) {
                courseMap.put(names, new ArrayList<>());
            }
            courseMap.get(names).add(students);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> pair : courseMap.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue().size());

            for (String student : pair.getValue()) {
                System.out.println("--" + student);
            }
        }
        scanner.close();
    }
}
