import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задание: Класс «Эмуляция интернет-магазина».
 * <p>
 * Домашнее задание
 * <p>
 * 1. В класс покупателя добавить перечисление с гендерами, добавить в сотрудника свойство «пол» со значением созданного
 * перечисления. Добавить геттеры, сеттеры.
 * 2. Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля), написать
 * метод, принимающий массив сотрудников, поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта, а мужчин
 * с 23 февраля, если сегодня соответствующий день.
 */
public class HomeWork {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Employee("Ivanov", "Manager", 150000, Customer.Gender.MALE),
                new Employee("Petrov", "Seller", 100000, Customer.Gender.MALE),
                new Employee("Sidorova", "Adviser", 70000, Customer.Gender.FEMALE),
                new Employee("Popova", "Seller", 100000, Customer.Gender.FEMALE)
        ));

        compliments(employees, LocalDate.of(2024, 12, 31));
    }

    public static void compliments(List<Employee> employees, LocalDate date) {
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        Celebrations d = Celebrations.NO_CELEBRATION;
        ArrayList<Employee> outEmployees = new ArrayList<>();

        if (month == 2 && day == 23) {
            outEmployees = employees.stream().filter(employee -> employee.getGender() == Customer.Gender.MALE).collect(Collectors.toCollection(ArrayList::new));
            d = Celebrations.DEFENDERS_DAY;
        } else if (month == 3 && day == 8) {
            outEmployees = employees.stream().filter(employee -> employee.getGender() == Customer.Gender.FEMALE).collect(Collectors.toCollection(ArrayList::new));
            d = Celebrations.WOMENS_DAY;
        }else if (month == 12 && day == 31) {
            outEmployees = new ArrayList<>(employees);
            d = Celebrations.NEW_YEAR;}

        if (outEmployees.isEmpty()) {
            return;
        }

        System.out.printf("Сегодня праздник %s!!!%n", d.getDisplayName());
        for (Employee employee : outEmployees) {
            System.out.printf("Уважаемый(ая) %s, поздравляем с %s!!!%n", employee.getName(), d.getDisplayName());
        }
    }
}

