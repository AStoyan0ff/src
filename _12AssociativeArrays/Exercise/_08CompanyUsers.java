package _12AssociativeArrays.Exercise;
import java.util.*;
import java.util.Scanner;

public class _08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> companyMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String [] cmd = input.split(" -> ");
            String company = cmd[0];
            String iD = cmd[1];

            companyMap.putIfAbsent(company, new LinkedHashSet<>());
            companyMap.get(company).add(iD);
        }
        for (Map.Entry<String, Set<String>> pair : companyMap.entrySet()) {
            System.out.println(pair.getKey());

            for (String company : pair.getValue()) {
                System.out.println("-- " + company);
            }
        }
        scanner.close();  // I love Java  =)
    }
}
