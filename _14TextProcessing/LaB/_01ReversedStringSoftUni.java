package _14TextProcessing.LaB;
import java.util.*;
import java.util.Scanner;

public class _01ReversedStringSoftUni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!"end".equals(line)) {
            String reversed = "";

            for (int pos = line.length() - 1; pos >= 0; pos--) {
                reversed += line.charAt(pos);
            }

            System.out.printf("%s = %s%n", line, reversed);
            line = scanner.nextLine();
        }
        scanner.close();
    }
}
