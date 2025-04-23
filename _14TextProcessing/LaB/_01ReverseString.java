package _14TextProcessing.LaB;
import java.util.Scanner;
import java.util.*;

public class _01ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();

            if (word.equals("end")) break;
            String reverseWord = new StringBuilder(word).reverse().toString();

            System.out.println(word + " = " + reverseWord);
        }
        scanner.close();
    }
}
