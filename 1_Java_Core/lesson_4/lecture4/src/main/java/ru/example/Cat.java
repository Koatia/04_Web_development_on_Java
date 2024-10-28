package ru.example;

/**
 * Статические вложенные классы
 * При объявлении такого класса используется ключевое слово static. Для примера в
 * классе котика заменим метод voice() на статический клас.
 */
public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static class Voice {
        private final int volume;

        public Voice(int volume) {
            this.volume = volume;
        }

        public void sayMur() {
            System.out.println("A cat says mur with volume " + volume);
        }
    }

    public static void main(String[] args) {
        Cat.Voice voice = new Cat.Voice(50);
        voice.sayMur();
    }
}
