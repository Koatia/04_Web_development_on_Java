package lecture;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Конструктор класса
        Class<?> car = Class.forName("lecture.Car");
        Constructor<?>[] constructor = car.getConstructors();

        Object gaz = constructor[0].newInstance("ГАЗ");
        System.out.println(gaz);
        System.out.println();

        // Изменения значений public полей класса
        Field[] fields = gaz.getClass().getFields();
        int temp = fields[fields.length - 1].getInt(gaz);
        fields[fields.length - 1].setInt(gaz, temp * 2);
        System.out.println(gaz);
        System.out.println();

        // Список методов класса
        Method[] methods = gaz.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}