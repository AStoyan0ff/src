package _20ExamPre.Lectures;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {

            String barcode = scanner.nextLine();
            getBarcode(barcode);

            scanner.close();
        }
    }

    public static void getBarcode(String barcode) {

        if (bFirstCode(barcode)) {

            String group = extractGroup(barcode);
            System.out.println("Product group: " + group);
        }
        else {
            System.out.println("Invalid barcode");
        }
    }

    public static boolean bFirstCode(String barcode) {

        String regEx = "@#+([A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(barcode);

        return matcher.matches();
    }

    public static String extractGroup(String barcode) {
        StringBuilder buffer = new StringBuilder();

        for (char c : barcode.toCharArray()) {

            if (Character.isDigit(c)) {
                buffer.append(c);
            }
        }

        return buffer.length() > 0 ? buffer.toString() : "00";
    }
}
