package ru.example;

/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
(https://ru.wikipedia.org/wiki/Парадокс_Монти_Холла) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).

Необходимо:
● Создать свой Java Maven или Gradle проект.
● Подключить зависимость lombok.
● Самостоятельно реализовать прикладную задачу.
● Сохранить результат в HashMap<шаг теста, результат>.
● Вывести на экран статистику по победам и поражениям.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static int strategy1, strategy2, choiceNumber, awardNumber;
    private static int COUNT_GAME = 1000;
    private static Map<Integer, Integer> resStrategy1, resStrategy2;

    public static void main(String[] args) {
        gameMontyHallParadox();
    }

    private static void gameMontyHallParadox() {

        // стратегия 1: игрок не меняет выбор
        // стратегия 2: игрок меняет выбор двери
        strategy1 = 0;
        strategy2 = 0;
        resStrategy1 = new HashMap<>();
        resStrategy2 = new HashMap<>();

        for (int i = 0; i < COUNT_GAME; i++) {
            // номер двери, за которой приз
            awardNumber = new Random().nextInt(1, 4);

            // номер двери, которую игрок выбрал первоначально
            choiceNumber = new Random().nextInt(1, 4);

            if (awardNumber == choiceNumber) {
                resStrategy1.put(i, 1);
                resStrategy2.put(i, 0);
            } else {
                resStrategy1.put(i, 0);
                resStrategy2.put(i, 1);
            }
        }

        // суммируем значения Java Hashmap с использованием Streams
        strategy1 = resStrategy1.values().stream().mapToInt(Integer::intValue).sum();
        strategy2 = resStrategy2.values().stream().mapToInt(Integer::intValue).sum();

        System.out.println(strategy1 + " побед из " + COUNT_GAME + " если игрок не меняет свой выбор");
        System.out.println(strategy2 + " побед из " + COUNT_GAME + " если игрок изменит свой выбор");
    }
}