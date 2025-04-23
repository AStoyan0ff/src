package _04Methods.Exercise;
import java.util.Scanner;

public class _07NxN_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        printMatrix(input);
        scanner.close();
    }

    public static void printMatrix(int N) {

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                System.out.print(N + " ");
            }
            System.out.println();
        }
    }
}

