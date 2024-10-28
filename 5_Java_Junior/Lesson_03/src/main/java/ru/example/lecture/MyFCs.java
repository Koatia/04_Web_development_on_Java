package ru.example.lecture;

import java.io.Serializable;

public class MyFCs implements Serializable {
    public String lName;
    public String fName;
    public String patronymic;

    public MyFCs(String fName, String lName, String patronymic) {
        this.lName = lName;
        this.fName = fName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return String.format("%s %s.%s. ", fName, lName.toUpperCase().charAt(0), patronymic.toUpperCase().charAt(0));
    }
}