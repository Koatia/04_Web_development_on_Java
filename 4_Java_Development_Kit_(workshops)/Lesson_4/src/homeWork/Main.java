package homeWork;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление сотрудников
        directory.addEmployee(new Employee(1231, "79640008642", "Иван", 10));
        directory.addEmployee(new Employee(1232, "79640008647", "Иван", 5));
        directory.addEmployee(new Employee(1233, "79640008641", "Петр", 3));
        directory.addEmployee(new Employee(1234, "79640008645", "Юрий", 5));
        directory.addEmployee(new Employee(1234, "79640008645", "Юрий", 5));

        // Поиск сотрудников по стажу
        System.out.println("\nСотрудники со стажем 5 лет:");
        List<Employee> employeesWith5Years = directory.findEmployeesByExperience(5);
        employeesWith5Years.forEach(System.out::println);

        // Поиск номеров телефона по имени
        System.out.println("\nТелефоны сотрудников с именем Иван:");
        List<String> alicePhones = directory.findPhoneNumberByName("Иван");
        alicePhones.forEach(System.out::println);

        // Поиск сотрудника по табельному номеру
        System.out.println("\nПоиск сотрудника с табельным номером 1233:");
        Employee employee = directory.findEmployeeById(1233);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }
}