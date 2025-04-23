package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {
            String cmd = scanner.nextLine();
            String [] partCmd = cmd.split(" ");

            if (partCmd[0].equals("register")) {
                String name = partCmd[1];
                String license = partCmd[2];

                if (parkingMap.containsKey(name)) {
                    System.out.println
                            ("ERROR: already registered with plate number " + parkingMap.get(name));
                }
                else {
                    parkingMap.put(name, license);
                    System.out.println
                            (name + " registered " + license + " successfully");
                }
            }
            else if (partCmd[0].equals("unregister")) {
                String name = partCmd[1];

                if (!parkingMap.containsKey(name)) {
                    System.out.println
                            ("ERROR: user " + name + " not found");
                }
                else {
                    parkingMap.remove(name);
                    System.out.println
                            (name + " unregistered successfully");
                }
            }
        }
        for (Map.Entry<String, String> input : parkingMap.entrySet()) {
            System.out.println
                    (input.getKey() + " => " + input.getValue());
        }
        scanner.close();
    }
}
