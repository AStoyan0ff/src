package _15TextProcessing.Exercise;
import java.util.Scanner;

public class _11ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {
            String input = scanner.nextLine();

            int startN = input.indexOf('@');
            int endN = input.indexOf('|', startN);
            String name = input.substring(startN + 1, endN);

            int startA = input.indexOf('#');
            int endA = input.indexOf('*', startA);
            String age = input.substring(startA + 1, endA);

            System.out.println(name + " is " + age + " years old." );
        }
        scanner.close();

        /*
        повтаря N пъти, за да прочете всеки входен ред.
        Името се извлича чрез намиране на индексите на @ и | използвайки indexOf().
        Поднизът между тези индекси се извлича с помощта на substring()
        Възрастта се извлича чрез намиране на индексите на # и * с помощта на indexOf().
        Поднизът между тези индекси се извлича с помощта на substring().
        */
    }
}
