package ru.example.lecture;

public class Task4 {
    /**
     * Давайте еще познакомимся с одним интерфейсом сериализации - Externalizable Требуется обязательный конструктор по
     * умолчанию (без параметров), а также два новых метода: writeExternal и readExternal — это и есть реализация
     * интерфейса Externalizable. Все используемые классы, как и раньше, должны быть сериализуемыми.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // "Сериализация"
        MyFCs2 myFCs = new MyFCs2("Ivanov", "Ivan", "Ivanovich");
        SerialObj.serialObj(myFCs, "ser");

        // "Десериализация"
        myFCs = (MyFCs2) DeSerialObj.deSerialObj("ser");
        System.out.println(myFCs);
    }
}
