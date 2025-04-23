package _02Arrays.Exercise;
import java.util.Scanner;

public class _03ZigZagArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int [] zigArrOne = new int[N];
        int [] zagArrTwo = new int[N];

        for (int rows = 0; rows < N; rows++) {

            if (rows % 2 == 0) {
                zigArrOne[rows] = scanner.nextInt();
                zagArrTwo[rows] = scanner.nextInt();
            }
            else {
                zigArrOne[rows] = scanner.nextInt();
                zagArrTwo[rows] = scanner.nextInt();

                int buff = zigArrOne[rows];

                zigArrOne[rows] = zagArrTwo[rows];
                zagArrTwo[rows] = buff;
            }
        }

        for (int num : zigArrOne) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int num : zagArrTwo) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
