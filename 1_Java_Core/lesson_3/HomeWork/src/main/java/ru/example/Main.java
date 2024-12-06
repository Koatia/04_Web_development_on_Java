package ru.example;

public class Main {

    public static void main(String[] args) {

        // Task 1
        int[] date1 = {2024, 10, 20}; // 25 октября 2023
        int[] date2 = {2024, 10, 25}; // 10 мая 2024

        Boolean result = Employee.dateCompare(date1, date2);

        System.out.printf("Результат сравнения %04d-%02d-%02d и %04d-%02d-%02d: %s %n", date1[0], date1[1], date1[2],
                date2[0], date2[1], date2[2], result);

        // Task 2
        Employee[] employees = new Employee[6];

        for (int i = 0; i < 5; i++) {
            employees[i] = GenerateRandomEmployee.generateEmployee();
        }
        employees[5] = GenerateRandomEmployee.generateManager();
        Employee.printEmployee(employees);

        int inc = 5000; // Размер повышения окладов
        System.out.printf("%nПовышение окладов на %d у.е. %n", inc);
        Manager.increaser(employees, inc);

        Employee.printEmployee(employees);
    }
}