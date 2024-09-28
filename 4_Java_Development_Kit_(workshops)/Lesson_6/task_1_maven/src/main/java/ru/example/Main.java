package ru.example;

/*
В рамках выполнения задачи необходимо:
● Создать свой Java Maven проект;
● Добавьте зависимость commons-math3 (предназначена для решения
математических задач) и изучить интерфейс библиотеки.
● Воспользоваться пакетом org.apache.commons.math3.stat и классом
DescriptiveStatistics.
    ○ Создать коллекцию из числовых элементов.
    ○ С помощью объекта DescriptiveStatistics вычислить минимальное и
    максимальное значение, сумму и среднее арифметическое.
● Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса
ArithmeticUtils найти:
    ○ факториал числа N.
    ○ Наименьшее общее частное двух чисел
    ○ Наибольший общий делитель двух чисел
    ○ Проверить, что число N это степень двойки
 */

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(array);

        System.out.println("Минимальное значение:    " + descriptiveStatistics.getMin());
        System.out.println("Максимальное значение:   " + descriptiveStatistics.getMax());
        System.out.println("Сумма элементов массива: " + descriptiveStatistics.getSum());
        System.out.println("Среднее арифметическое:  " + descriptiveStatistics.getMean());
        System.out.println();

        System.out.println("Факториал числа 5: " + ArithmeticUtils.factorial(5));
        System.out.println("Наименьшее общее частное чисел 15 и 25: " + ArithmeticUtils.lcm(15, 25));
        System.out.println("Наибольший общий делитель чисел 10 и 30: " + ArithmeticUtils.gcd(10, 30));
        System.out.println("Проверить, что число 1024 это степень двойки: " + ArithmeticUtils.isPowerOfTwo(1024));

    }
}