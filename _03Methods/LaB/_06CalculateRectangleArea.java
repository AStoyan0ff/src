package _03Methods.LaB;
import java.util.Scanner;

public class _06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = Integer.parseInt(scanner.nextLine());
        int w = Integer.parseInt(scanner.nextLine());

        System.out.println(rangeTriangle(l, w));
    }

    private static int rangeTriangle(int x, int y) {
        int S = x * y;

        return S;
    }
}
