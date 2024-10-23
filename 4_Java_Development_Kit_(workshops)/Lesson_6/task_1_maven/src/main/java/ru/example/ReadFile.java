package ru.example;

import java.io.IOException;
import java.io.InputStream;

public class ReadFile {

    public static void main(String[] args) {
        System.out.println(new ReadFile().readFile());
    }

    public String readFile() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.txt")) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}