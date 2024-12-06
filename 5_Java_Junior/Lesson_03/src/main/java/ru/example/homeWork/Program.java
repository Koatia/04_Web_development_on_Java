package ru.example.homeWork;

public class Program {
    /**
     * Задание 1: Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
     * Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
     * Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла. Выведите все поля объекта,
     * включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
     * <p>
     * Задание 2: Выполните задание 1 используя другие типы сериализаторов (в xml & json документы).
     */

    public static final String FILE_JSON = "student.json";
    public static final String FILE_BIN = "student.bin";
    public static final String FILE_XML = "student.xml";

    public static void main(String[] args) throws Exception {
        Student student = new Student("Иван", 20, 7.6);

        System.out.println("Initialization: " + student);

        // Serializable
        // Сохранение в бинарный файл
        ReadWriteFile.saveStudentToBIN(student, FILE_BIN);
        Student binStudent1 = ReadWriteFile.loadStudentFromBIN(FILE_BIN);
        System.out.println("\nSerializable");
        System.out.println("student.bin:    " + binStudent1);

        // Externalizable
        // Сохранение в JSON
        ReadWriteFile.saveStudentToFile(student, "student.json");
        Student jsonStudent = ReadWriteFile.loadStudentFromFile("student.json");
        System.out.println("\nExternalizable");
        System.out.println("student.json:   " + jsonStudent);

        // Сохранение в бинарный файл
        ReadWriteFile.saveStudentToFile(student, "student.bin");
        Student binStudent2 = ReadWriteFile.loadStudentFromFile("student.bin");
        System.out.println("student.bin:    " + binStudent2);

        // Сохранение в XML
        ReadWriteFile.saveStudentToFile(student, "student.xml");
        Student xmlStudent = ReadWriteFile.loadStudentFromFile("student.xml");
        System.out.println("student.xml:    " + xmlStudent);

    }
}

