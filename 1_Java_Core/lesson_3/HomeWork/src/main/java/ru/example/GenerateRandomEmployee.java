package ru.example;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class GenerateRandomEmployee {
    private static final Random random = new Random();
    // Пример списков значений для каждого поля
    private static final List<String> names = List.of("John", "Jane", "Alex", "Chris", "Taylor");
    private static final List<String> midNames = List.of("M.", "A.", "B.", "C.", "D.");
    private static final List<String> surNames = List.of("Doe", "Smith", "Brown", "Johnson", "Williams");
    private static final List<String> positions = List.of("Developer", "Cleaner", "Analyst", "Designer", "Engineer");
    private static final List<String> phones = List.of("+123456789", "+987654321", "+112233445", "+998877665", "+554433221");
    private static final List<Integer> salaries = List.of(75000, 85000, 95000, 65000, 55000);
    private static final List<Integer> birthYears = List.of(1990, 1985, 1995, 1980, 1975);

    /**
     * Генератор сотрудников
     *
     * @return сотрудник (Employee)
     */
    public static Employee generateEmployee() {
        // Выбираем случайные значения из каждого списка
        String name = names.get(random.nextInt(names.size()));
        String midName = midNames.get(random.nextInt(midNames.size()));
        String surName = surNames.get(random.nextInt(surNames.size()));
        String position = positions.get(random.nextInt(positions.size()));
        String phone = phones.get(random.nextInt(phones.size()));
        int salary = salaries.get(random.nextInt(salaries.size()));
        int birthYear = birthYears.get(random.nextInt(birthYears.size()));

        return new Employee(name, midName, surName, position, phone, salary, birthYear);
    }

    /**
     * Генератор руководителей
     *
     * @return руководитель (Manager)
     */
    public static Employee generateManager() {
        // Выбираем случайные значения из каждого списка
        String name = names.get(random.nextInt(names.size()));
        String midName = midNames.get(random.nextInt(midNames.size()));
        String surName = surNames.get(random.nextInt(surNames.size()));
        String position = "";
        String phone = phones.get(random.nextInt(phones.size()));
        int salary = salaries.get(random.nextInt(salaries.size()));
        int birthYear = birthYears.get(random.nextInt(birthYears.size()));

        return new Manager(name, midName, surName, position, phone, salary, birthYear);
    }
}
