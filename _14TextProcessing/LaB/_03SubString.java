package _14TextProcessing.LaB;
import java.util.*;
import java.util.Scanner;

public class _03SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removeString = scanner.nextLine(); // ice
        String word = scanner.nextLine();  // kicegiciceeb

        while (word.contains(removeString)) {
            word = word.replace(removeString, "");
        }

        System.out.println(word);
        scanner.close();
    }
}
