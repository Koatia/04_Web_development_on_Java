package seminar;
/*
Задание 2
В рамках выполнения задачи необходимо:
● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
добавьте повторяющиеся значения
● Получите уникальный список Set на основании List
● Определите наименьший элемент (алфавитный порядок)
● Определите наибольший элемент (по количеству букв в слове но в обратном
порядке)
● Удалите все элементы содержащие букву ‘A’
 */

import java.util.*;

public class Task2 {
    public static List<String> makeList() {
        List<String> names =
                new ArrayList<>(Arrays.asList("Иван", "Зоя", "Костя", "Ирина", "Костя", "Ирина", "Екатерина", "Анна"));
        return names;
    }

    public static Set<String> convertListToSet(List<String> list) {
        return new HashSet<>(list);
    }

    public static String minSortedName(Set<String> setNames) {
        return setNames.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public static String maxLengthName(Set<String> setNames) {
        return setNames.stream().max(Comparator.comparing(String::length)).orElse(null);
    }

    public static Set<String> removeMember(Set<String> setNames, String alpha) {
        Set<String> set = new HashSet<>(setNames);
        set.removeIf(name -> name.toLowerCase().contains(alpha.toLowerCase()));
        return set;
    }

    public static void main(String[] args) {
        Set<String> setNames = convertListToSet(makeList());

        System.out.println("List: " + makeList());
        System.out.println("Set:  " + setNames);
        System.out.println("Наименьшее отсортированное по алфавиту имя: " + minSortedName(setNames));
        System.out.println("Наибольшее по длине имя: " + maxLengthName(setNames));
        System.out.println("Имена без буквы 'а'    : " + removeMember(setNames, "а"));
    }
}