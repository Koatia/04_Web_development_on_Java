package ru.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
В рамках выполнения задачи необходимо:
● Создать свой Java Gradle проект;
● Добавить зависимость Guava (популярная библиотека от Google, содержащая набор
утилитарных механизмов).
● Воспользоваться утилитарным классом Lists:
    ○ Развернуть список элементов
    ○ Получить лист Character из строки
    ○ Разделить лист на группы по 2 элемента
● Воспользоваться утилитарным классом Sets
    ○ Получить итоговый Set из двух коллекций
    ○ Получить итоговый Set из общих элементов двух коллекций
    ○ Получить итоговый Set из непересекающихся элементов двух коллекций
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("Создать лист: " + list1);

        System.out.println("Развернуть список элементов: " + Lists.reverse(list1));
        System.out.println("Получить лист Character из строки: " + Lists.charactersOf("abcde"));
        System.out.println("Разделить лист на группы по 2 элемента: " + Lists.partition(list1, 2));

        System.out.println();
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 10));
        System.out.println(
                "Получить итоговый Set из двух коллекций: " + Sets.union(Set.copyOf(list1), Set.copyOf(list2)));
        System.out.println("Получить итоговый Set из общих элементов двух коллекций: " +
                Sets.intersection(Set.copyOf(list1), Set.copyOf(list2)));
        System.out.println("Получить итоговый Set из непересекающихся элементов двух коллекций: " +
                Sets.symmetricDifference(Set.copyOf(list1), Set.copyOf(list2)));
    }
}