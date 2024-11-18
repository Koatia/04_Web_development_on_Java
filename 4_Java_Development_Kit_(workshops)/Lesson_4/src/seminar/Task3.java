package seminar;

/*
Задание 3
В рамках выполнения задачи необходимо:
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
● Найдите человека с самым маленьким номером телефона
● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("89640003236", "Иван");
        phonebook.put("89640002233", "Олег");
        phonebook.put("89640005238", "Таня");
        phonebook.put("89640007235", "Женя");
        phonebook.put("89640009236", "Юрий");

        System.out.println(findByMinNumber(phonebook));
        System.out.println(findByMaxAlphabetName(phonebook));
    }

    // Сравниваем номера в числовом формате для корректной сортировки
    public static String findByMinNumber(Map<String, String> phonebook) {
        Set<Long> numbers = phonebook.keySet().stream().map(el -> Long.valueOf(el)).collect(Collectors.toSet());
        long num = numbers.stream().min(Comparator.naturalOrder()).get();

        return String.format("Наименьший номер: %s - %s", num, phonebook.get(String.valueOf(num)));
    }

    public static String findByMaxAlphabetName(Map<String, String> phonebook) {
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name =
                elements.stream().max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();

        return String.format("Человек, чье имя самое большое в алфавитном порядке: %s - %s", name.getValue(),
                name.getKey());
    }
}