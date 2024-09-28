package ru.example.lecture;

public class Task3 {
    /**
     * Любой класс, который мы хотим сериализовать, должен реализовывать интерфейс Serializable
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // "Сериализация"
        MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
        SerialObj.serialObj(myFCs, "ser");

        // "Десериализация"
        myFCs = (MyFCs) DeSerialObj.deSerialObj("ser");
        System.out.println(myFCs);
    }
}
