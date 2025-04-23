package _00Arrays.More.Exercise;
import java.util.*;
import java.util.Scanner;

public class _01EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Integer> encryptList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String input = scanner.nextLine();

            encryptList.add(encryptStr(input));
        }

        Collections.sort(encryptList);

        for (int val : encryptList) {
            System.out.println(val);
        }
    }

    private static boolean bVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    // (return ... != -1) е стандартен начин за тази проверка в Java.
    /*if ("AEIOUaeiou".indexOf(c) != -1) {
        return true;
    } else {
        return false;
    }*/

    private static int encryptStr(String str) {

        int result = 0;
        int size = str.length();

        for (int pos = 0; pos < size; pos++) {
            char curr = str.charAt(pos);

            if (bVowel(curr)) {
                result += curr * size;
            }
            else {
                result += curr / size;
            }
        }
        return result;
    }
}
