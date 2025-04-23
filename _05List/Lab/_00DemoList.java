package _05List.Lab;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _00DemoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Списък от стрингове
        List<String> nameList = new ArrayList<>();

        //Добавяме елемент в nameList (списъка)
        nameList.add("Andrey"); // -> позиция 0
        nameList.add("Stoyanov"); // -> позиция 1
        nameList.add("Student"); // -> позиция 2

        //Вмъкваме елемент на конкретна позиция
        nameList.add(1, "Andrey");

        //Списък от цели числа
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(20);
        numbersList.add(30);
        numbersList.add(40);
        numbersList.add(50);

        //премахваме елементи от списъка
        nameList.remove("Stoyanov");

        //Премахване елемент от списъка на конкретна позиция
        nameList.remove(2);

        //Достъпване на елемент от List
        String name = nameList.get(0);
        System.out.println(nameList.get(0));

        //Обхождане на Листа от цели числа с for
        for (int pos = 0; pos < numbersList.size(); pos++) {
            System.out.println(numbersList.get(pos));
        }

        // Обхождане с forEach -> когато ни трябват само елементите, без позициите им
        for (int current : numbersList) {
            System.out.println(current);
        }

        //Проверяваме дали в Листа съществува даден елемент
        // contains : -> нещо като boolean
        // true -> ако елемента е в списъка
        // false -> ако елемента го няма в списъка

        if (numbersList.contains(20)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        //-> set() Заместване на елементи в Листа, не променя размера на листа
        numbersList.set(0, 30); // -> Заместваме на позиция 0 да стои стойността 30

        // Проверява дали списъка е празен
        // isEmpty :
        if (numbersList.isEmpty()) {
            System.out.println("List is Empty");
        }
        else {
            System.out.println("List is not Empty");
        }

        // clear -> премахва всички елементи в списъка
        numbersList.clear();

        //Списък с константни стойности

        List<Integer> digitList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<String> namesList = new ArrayList<>(Arrays.asList("Ivan", "Dragan"));

        //Четене на Списък от конзолата

        List<Integer> numList = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //Списък с дробни числа

        List<Double> priceList = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        // Лист от стрингове

        List<String> goodList = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .collect(Collectors.toList());
    }
}
