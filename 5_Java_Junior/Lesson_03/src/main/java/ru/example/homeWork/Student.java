package ru.example.homeWork;

import java.io.*;

public class Student implements Serializable, Externalizable {

    private String name;

    private int age;

    private transient double GPA;

    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);
        // out.writeDouble(GPA);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        age = in.readInt();
        // GPA = in.readDouble();
    }

    // Геттеры и сеттеры для всех полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public double getGPA() {
//        return GPA;
//    }
//
//    public void setGPA(double GPA) {
//        this.GPA = GPA;
//    }

    @Override
    public String toString() {
        return "Student{" + "Имя: " + name + ", Возраст: " + age + ", GPA: " + GPA + '}';
    }
}
