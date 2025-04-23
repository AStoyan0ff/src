package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("end")) {

            String [] partCmd = input.split(" \\:");
            String courseName = partCmd[0];
            String studentName = partCmd[1];

            coursesMap.putIfAbsent(courseName, new ArrayList<>());
            coursesMap.get(courseName).add(studentName);
        }

        for (Map.Entry<String, List<String>> pair : coursesMap.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue().size());

            for (String student : pair.getValue()) {
                System.out.println("--" + student);
            }
        }
        scanner.close();
    }
}
