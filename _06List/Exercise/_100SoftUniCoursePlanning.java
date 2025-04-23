package _06List.Exercise;
import java.util.Scanner;
import java.util.*;

public class _100SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] course = scanner.nextLine().split(", ");
        List<String> courseList = new ArrayList<>(List.of(course));

        while (true) {
            String cmd = scanner.nextLine();

            if (cmd.equals("course start")) {
                break;
            }

            String[] parts = cmd.split(":");
            String command = parts[0];
            String unit, unit2;

            int index;
            switch (command) {

                case "Add" -> {
                    unit = parts[1];

                    if (!courseList.contains(unit)) {
                        courseList.add(unit);
                    }
                }
                case "Insert" -> {
                    unit = parts[1];
                    index = Integer.parseInt(parts[2]);

                    if (!courseList.contains(unit) && index >= 0 && index <= courseList.size()) {
                        courseList.add(index, unit);
                    }
                }
                case "Remove" -> {

                    unit = parts[1];
                    courseList.remove(unit);

                    String exercise = unit + "-Exercise";
                    courseList.remove(exercise);
                }
                case "Swap" -> {

                    unit = parts[1];
                    unit2 = parts[2];

                    if (courseList.contains(unit) && courseList.contains(unit2)) {

                        int position = courseList.indexOf(unit);
                        int position2 = courseList.indexOf(unit2);

                        courseList.set(position, unit2);
                        courseList.set(position2, unit);

                        String exercise1 = unit + "-Exercise";
                        String exercise2 = unit2 + "-Exercise";

                        if (courseList.contains(exercise1)) {

                            courseList.remove(exercise1);
                            courseList.add(position2 + 1, exercise1);
                        }
                        if (courseList.contains(exercise2)) {

                            courseList.remove(exercise2);
                            courseList.add(position + 1, exercise2);
                        }
                    }
                }
                case "Exercise" -> {
                    unit = parts[1];

                    String exerciseUnit = unit + "-Exercise";

                    if (courseList.contains(unit)) {
                        int unitPosition = courseList.indexOf(unit);

                        if (unitPosition + 1 >= courseList.size() || !courseList.get(unitPosition + 1)
                                .equals(exerciseUnit)) {
                            courseList.add(unitPosition + 1, exerciseUnit);
                        }
                    } else {
                        courseList.add(unit);
                        courseList.add(exerciseUnit);
                    }
                }
            }
        }
        for (int pos = 0; pos < courseList.size(); pos++) {
            System.out.println((pos + 1) + "." + courseList.get(pos));
        }
    }
}
