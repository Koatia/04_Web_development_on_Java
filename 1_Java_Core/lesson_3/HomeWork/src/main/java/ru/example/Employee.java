package ru.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private static final int CURRENT_YEAR = 2024;
    private String name;
    private String midName;
    private String surName;
    private String position;
    private String phone;
    private int salary;
    private int birth;


    public int getAge() {
        return CURRENT_YEAR - birth;
    }

    /**
     * Прототип компаратора - метод, сравнивающий две даты,
     * представленные в виде трёх чисел гггг-мм-дд,
     * без использования условного оператора.
     *
     * @param date1 дата в виде трёх чисел гггг-мм-дд
     * @param date2 дата в виде трёх чисел гггг-мм-дд
     * @return результат сравнения
     */
    public static Boolean dateCompare(int[] date1, int[] date2) {
        // Переводим дату в формат YYYYMMDD для простого сравнения
        int dateValue1 = date1[0] * 10000 + date1[1] * 100 + date1[2];
        int dateValue2 = date2[0] * 10000 + date2[1] * 100 + date2[2];
        // Возвращаем разницу для сравнения дат
        return dateValue1 == dateValue2;
    }

    /**
     * Форматированный вывод "ФИО Должность Оклад"
     * @param emp список сотрудников
     */
    public static void printEmployee(Employee[] emp) {
        for (Employee e : emp) {
            System.out.printf("Сотрудник: %-20s %-15s оклад: %d %n"
                    , e.getName() + " " + e.getMidName() + " " + e.getSurName(), e.getPosition(), e.getSalary());
        }
    }
}