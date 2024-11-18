package homeWork;

import java.util.Arrays;
import java.util.List;

public class HomeWork {
    /**
     * Напишите программу, которая использует Stream API для обработки списка чисел. Программа должна вывести на экран
     * среднее значение всех четных чисел в списке.
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Среднее значение всех четных чисел в списке: " +
                numbers.stream().filter(number -> number % 2 == 0).mapToInt(e -> e).average().orElse(Double.NaN));
    }
}