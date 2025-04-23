package _17RegEx.Exercise;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {
            String password = scanner.nextLine();

            if (bFirstPass(password)) {

                String group = extraCt(password);
                System.out.println("Group: " + group);
            }
            else {
                System.out.println("Invalid pass!");
            }
        }
    }
    public static boolean bFirstPass(String password) {
                    // "^_+\\.+([A-Z][A-Za-z0-9]+{4,}[A-Z])_+\\.+$";
        String regEx = "^_+[.]+([A-Z][A-Za-z0-9]{4,}[A-Z])_+[.]*$";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
    public static String extraCt(String password) {
        StringBuilder buffer = new StringBuilder();

        for (char c : password.toCharArray()) {

            if (Character.isDigit(c)) {
                buffer.append(c);
            }
        }
        return buffer.length() > 0 ? buffer.toString() : "default";
    }
}
