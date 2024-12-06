package ru.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Manager extends Employee {

    public Manager(String name, String midName, String surName,
                   String phone, String position, int salary, int birth) {
        super(name, midName, surName, "Manager", phone, salary, birth);
    }

    /**
     * Повышение оклада (кроме Manager)
     * @param emp список сотрудников
     * @param increment сумма прибавки оклада
     */
    public static void increaser(Employee[] emp, int increment) {
        for (int i = 0; i < emp.length; i++) {
            if (!(emp[i] instanceof Manager))
                emp[i].setSalary(emp[i].getSalary() + increment);
        }
    }
}
