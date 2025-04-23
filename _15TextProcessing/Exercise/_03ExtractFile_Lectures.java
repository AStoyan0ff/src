package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _03ExtractFile_Lectures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String partsPath = scanner.nextLine();
        String [] input = partsPath.split("\\\\");

        String fileName = input[input.length - 1].split("\\.")[0];
        String extensionFile = input[input.length - 1].split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extensionFile);

        scanner.close();

    }
}
