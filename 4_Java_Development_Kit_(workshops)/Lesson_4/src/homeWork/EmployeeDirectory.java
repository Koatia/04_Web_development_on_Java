package homeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class EmployeeDirectory {
    private final List<Employee> employees;

    // Конструктор для инициализации справочника
    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    // Метод добавления нового сотрудника
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Сотрудник добавлен: " + employee);
    }

    // Метод поиска сотрудников по стажу (возвращает список)
    public List<Employee> findEmployeesByExperience(int experience) {
        return employees.stream().filter(employee -> employee.getExperience() == experience)
                .collect(Collectors.toList());
    }

    // Метод поиска номера телефона по имени (возвращает список номеров, если есть несколько сотрудников с одним именем)
    public List<String> findPhoneNumberByName(String name) {
        return employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(name))
                .map(Employee::getPhoneNumber).collect(Collectors.toList());
    }

    // Метод поиска сотрудника по табельному номеру (возвращает сотрудника)
    public Employee findEmployeeById(int employeeId) {
        return employees.stream().filter(employee -> employee.getEmployeeId() == employeeId).findFirst()
                .orElse(null); // Возвращает null, если сотрудник не найден
    }
}