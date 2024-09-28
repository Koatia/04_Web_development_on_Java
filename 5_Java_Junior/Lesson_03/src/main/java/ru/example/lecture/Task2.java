package ru.example.lecture;

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) throws Exception {
        // "Сериализация"
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(Character.getName(i));
        }
        SerialObj.serialObj(list, "ser");

        // "Десериализация"
        list = (ArrayList<String>) DeSerialObj.deSerialObj("ser");
        System.out.println(list);
    }
}
