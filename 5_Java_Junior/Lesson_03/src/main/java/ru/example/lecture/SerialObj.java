package ru.example.lecture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Метод для выполнения сериализации
 */
public class SerialObj {
    public static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
}
