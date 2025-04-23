package _14TextProcessing.LaB;
//import java.util.*;
import java.util.Scanner;

public class _02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] word = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (String input : word) {
            int cnt = input.length();

            result.append(input.repeat(cnt));
        }
        System.out.println(result);
        scanner.close();
    }
}
