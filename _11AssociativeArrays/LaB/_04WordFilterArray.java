package _11AssociativeArrays.LaB;
import java.util.*;
import java.util.Scanner;

public class _04WordFilterArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] fruitsArray = Arrays
                .stream(scanner.nextLine()
                .split(" "))
                .filter(w -> w.length() % 2 == 0)
                .toArray(String []::new);

        /*for (String fruit : fruitsArray) {
            System.out.println(fruit);
        }*/

        // отпечатване с Stream API
        Arrays.stream(fruitsArray).forEach(System.out::println);
    }
}
