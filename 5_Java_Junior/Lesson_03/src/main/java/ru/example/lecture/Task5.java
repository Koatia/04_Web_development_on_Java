package ru.example.lecture;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Task5 {

    /**
     * Java IO основывается на двух классах: InputStream и OutputStream. Эти классы позволяют организовать потоки чтения
     * и записи данных. В качестве примера для чтения можно использовать удобный наследник — FileInputStream. А в
     * качестве примера для записи FileOutputStream.
     * <p>
     * Это классические примеры потокового чтения и записи файла.
     */
    public static void main(String[] args) throws Exception {
        // "FileInputStream"
        try (FileInputStream in = new FileInputStream("in.txt")) {
            System.out.println("Size of file is " + in.available() + " bytes");
            byte[] inArray = in.readAllBytes();
            System.out.println(Arrays.toString(inArray));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // "FileOutputStream"
        String text = "Hello world!";
        try (FileOutputStream out = new FileOutputStream("out.txt")) {
            byte[] buffer = text.getBytes();
            out.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}