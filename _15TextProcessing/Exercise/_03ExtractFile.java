package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder buffer = new StringBuilder(scanner.nextLine());
        // I add "\\" because '\' is a special character
        int lastPos = buffer.lastIndexOf("\\");

        String fileExe = buffer.substring(lastPos + 1);
        // I find the index of the last point
        int lastDotPos = fileExe.lastIndexOf(".");

        // I separate the file name and extension
        String file = fileExe.substring(0, lastDotPos);
        String fileJava = fileExe.substring(lastDotPos + 1);

        System.out.println("File name: " + file);
        System.out.println("File extension: " + fileJava);
        scanner.close();
    }
}
