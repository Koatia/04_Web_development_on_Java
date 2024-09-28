package ru.example.lecture;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Task1 {

    /**
     * "Сериализация" В этом примере мы создаем поток записи байт в файл, поток записи объекта и выполняем запись
     * объекта. После этого мы закрываем потоки.
     * <p>
     * "Десериализация" В этом примере мы создаем поток чтения байт из файла, поток чтения объекта и выполняем чтение
     * объекта. После этого мы закрываем потоки.
     */
    public static void main(String[] args) throws Exception {
        // "Сериализация"
        String str = "Hello World";
        FileOutputStream fileOutputStream = new FileOutputStream("ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();

        // "Десериализация"
        FileInputStream fileInputStream = new FileInputStream("ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        str = (String) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(str);
    }
}