package _11AssociativeArrays.LaB;
import java.util.*;
import java.util.Scanner;

public class _05WordFilterArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> fruitsList = Arrays
                .asList(scanner.nextLine()
                .split(" "));

        fruitsList
                .stream()
                .filter(word -> word.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
