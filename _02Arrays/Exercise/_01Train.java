package _02Arrays.Exercise;
import java.util.Scanner;

public class _01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int [] train = new int[N];

        int peopleCnt = 0;

        for (int i = 0; i < N; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());

            peopleCnt += train[i];
        }

        for (int wagon : train) {
            System.out.print(wagon + " ");
        }

        System.out.println();
        System.out.println(peopleCnt);

        scanner.close();

    }
}
