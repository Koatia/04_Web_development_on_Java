package classWork.task2;

import java.lang.reflect.Field;

public class Task2 {

    /**
     * Задача 2.
     * <p>
     * Реализуйте обобщенный метод, который принимает объект и выводит в консоль значения всех его полей. Создайте класс
     * "Car" с различными полями. Примените Reflection API для вывода значений полей созданного объекта класса "Car" с
     * использованием ранее созданного метода.
     */

    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("Toyota", "Blue", 2022);
        task2(car);
    }

    private static <T> void task2(T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();

        // Получить список всех полей
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
    }
}
