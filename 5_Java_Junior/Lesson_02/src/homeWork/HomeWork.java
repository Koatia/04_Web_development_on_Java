package homeWork;

import java.lang.reflect.Method;

/**
 * Java Junior (семинары) Урок 2. Reflection API
 * -----------------------
 * <p>
 * Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
 */

public class HomeWork {
    public static void main(String[] args) throws ClassNotFoundException {

        // Создать описатель класса
        Class<?> stringClass = Class.forName("java.lang.String");

        // Получаем все методы класса String
        Method[] methods = stringClass.getDeclaredMethods();

        // Выводим на экран все методы
        for (Method method : methods) {
            System.out.printf("Method %s: %s\n", method.getName(), method);
        }
    }
}
