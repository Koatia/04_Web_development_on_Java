package ru.example.lecture;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task6 {

    /**
     * Ещё два класса FileReader и FileWriter позволяют работать с файлами посимвольно.
     */
    public static void main(String[] args) {
        String fileName = "example.txt";
        // "FileInputStream"
        try (FileWriter fWriter = new FileWriter(fileName)) {
            fWriter.write("Это классические примеры потокового чтения и записи файла.\n");
            fWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // "FileOutputStream"
        try (FileReader fReader = new FileReader(fileName)) {
            char[] a = new char[200];
            fReader.read(a);
            for (char c : a) {
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}