package classWork.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Задача 1.
 * <p>
 * Получите информацию о классе "Person" используя Reflection API:
 * - выведите на экран все поля и методы класса
 * - создайте экземпляр класса "Person" используя Reflection API
 * - установите значения полей и вызовите методы.
 * <p>
 * Реализуйте обработку исключений для обеспечения корректного взаимодействия с Reflection API *
 */

public class Task1 {
    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException,
            NoSuchFieldException {

        // Создать описатель класса
        Class<?> personalClass = Class.forName("classWork.task1.Person");

        // Получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName());
        }

        // Получить список всех методов
        Method[] methods = personalClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Метод: " + method.getName());
        }

        // Получить список всех конструкторов класса
        Constructor[] constructors = personalClass.getDeclaredConstructors();

        // Создаем экземпляр класса с использованием первого конструктора
        Object personInstance = constructors[0].newInstance(null);

        // Вызов первого метода из полученного списка методов
        methods[0].invoke(personInstance);

        // Изменяем значения полей
        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);  // Делаем приватное поле доступным для изменения
        nameField.set(personInstance, "Alice");

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);  // Делаем приватное поле доступным для изменения
        ageField.set(personInstance, 30);

        // Вызов первого метода из полученного списка методов
        methods[0].invoke(personInstance);
    }
}
