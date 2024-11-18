// Скомпилировать .class:    javac -d ourclasses ./src/MainExample1.java
//и запускаем на выполнение: java -cp ./ourclasses/ MainExample1

public class MainExample1 {
    public static void main(String[] args) {
        // используем универсальный перенос строки
        System.out.println(System.lineSeparator() + "Hello from java!");
    }
}