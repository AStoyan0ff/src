package _03Methods.LaB;
import java.util.Scanner;

public class _02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        printGrades(grade);

    }
    private static void printGrades(double grades) {

        if (grades <= 2.99) {
            System.out.println("Fail");
        }
        else if (grades <= 3.49) {
            System.out.println("Poor");
        }
        else if (grades <= 4.49) {
            System.out.println("Good");
        }
        else if (grades <=5.49) {
            System.out.println("Very good");
        }
        else if (grades <= 6.00) {
            System.out.println("Excellent");
        }
    }
}
