package ru.gb.jcore.sample;

import ru.gb.jcore.regular.Decorator;
import ru.gb.jcore.regular.OtherClass;

/**
 * Основной класс приложения. Здесь мы можем описать его основное назначение и способы взаимодействия с ним.
 * <p>
 * Скомпилировать .class:    javac -d ourclasses -sourcepath src ./src/ru/gb/jcore/sample/Main.java
 * <p>
 * и запускаем его:    java -cp ./ourclasses/ ru.gb.jcore.sample.Main
 * <p>
 * Генерируем документацию:  javadoc -d mydoc -sourcepath src -cp ./ourclasses/ -subpackages ru
 */
public class Main {
    /**
     * Точка входа в программу. С неё всегда всё начинается.
     *
     * @param args стандартные аргументы командной строки
     */
    public static void main(String[] args) {
        int result = OtherClass.add(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(2, 2);
        System.out.println(Decorator.decorate(result));
    }
}