package seminar;

/*
Задание 1
В рамках выполнения задачи необходимо:
● Создайте коллекцию мужских и женских имен с помощью интерфейса List
● Отсортируйте коллекцию в алфавитном порядке
● Отсортируйте коллекцию по количеству букв в слове
● Разверните коллекцию
 */

import java.util.*;

public class Task1 {
    public static List<String> makeList() {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Зоя", "Костя", "Ирина", "Екатерина"));
        return names;
    }

    public static List<String> sortByName(List<String> list) {
        Collections.sort(list);
        return list;
    }

    public static List<String> sortByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
        return list;
    }

    public static List<String> reversList(List<String> list) {
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(makeList());
        System.out.println(sortByName(makeList()));
        System.out.println(sortByLength(makeList()));
        System.out.println(reversList(makeList()));
    }
}