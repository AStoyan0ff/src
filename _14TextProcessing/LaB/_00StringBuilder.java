package _14TextProcessing.LaB;
import java.util.Scanner;

public class _00StringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // StringBuilder - пространство в което си изграждаме текс
        StringBuilder buffer = new StringBuilder();

        // добавяне на текст
        buffer.append("Andrey");
        buffer.append("26");
        buffer.append("years old");

        // достъпвме текста чрез променлива
        String buff = buffer.toString();
        System.out.println(buff);

        // достъпване на дължината на текста -> .length
        System.out.println(buffer.length());

        //изчистваме StringBuilder -> .length
        buffer.length();

        //достъпване на текст по индекс
        System.out.println(buffer.charAt(0));

        // вмъквме текст в builder-a
        buffer.insert(0, "Stoyanoff");

        // премахване на текст от builder
        buffer.delete(0, 3);





    }
}
