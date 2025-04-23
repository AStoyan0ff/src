package _11AssociativeArrays.LaB;
import java.util.*;
import java.util.Scanner;

public class _00DemoMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // мапове или речници
        // съркупност от еднотипни записи
        // всеки запис има ключ Key и стойност Value

        //създаване на празен Map в който ще съхераняваме инфо за ученик и оценката му
        Map<String, Double> studentGrades = new HashMap<String, Double>();

        //Добавяне на запис в мапа -> .put
        // добавяме записа без значение дали има запис с такъв ключ
        studentGrades.put("Andrey", 5.50);

        //.putIfAbsent ->добавя записа само ако няма друг запис със същия ключ
        studentGrades.putIfAbsent("Ivan", 4.50);

        // Премахване на записи от Мапа
        // премахва записа на ключа "Andrey"
        studentGrades.remove("Andrey");

        //Премахваме целия запис по ключа и стойност
        studentGrades.remove("Andrey", 5.50);

        //Достъпване на записи -> взима стойността на Key
        studentGrades.get("Andrey");

        //Проверка дали в даден МАП съществува някакъв Key
        // .containsKey -> boolean (true or false)
        studentGrades.containsKey("Andrey");

        // .containsValue -> Проверка дали в даден МАП съществува някаква стойност
        System.out.println(studentGrades.containsValue(4.50));

        //обхождане на МАП
        //.entrySet() -> съвкупност от записи
        for (Map.Entry<String, Double> input : studentGrades.entrySet()) {
            // всеки един запис се съхранява в променливата entry
            System.out.println(input.getKey());
            System.out.println(input.getValue());
            System.out.println(input.getKey() + "->" + input.getValue());
        }

        // HasMap  - нямаме гарантирана подредба ба записите
        // LinkedHasMap - записите се подреждат спрямо реда на добавяне
        // TreeMap - записите се подреждат по ключ в нарастващ ред

        Map<Integer, String> people = new LinkedHashMap<>();
        people.put(1, "Alex");
        people.put(2, "Ivan");


        Map<String, Double> students = new TreeMap<>();
        students.put("Petar", 5.60);
        students.put("Ivan", 3.40);

        // размер на мапа -> .size()
        System.out.println(students.size());

    }
}
