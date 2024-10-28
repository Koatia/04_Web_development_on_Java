package ru.example;

/**
 * Локальный класс объявляется только в блоке кода. Чаще всего —
 * внутри какого-то метода внешнего класса.
 */
public class Animal {
    void performBehavior(boolean state) {
        class Brain {
            void sleep() {
                if (state)
                    System.out.println("Brain sleeping");
                else
                    System.out.println("Brain not sleeping");
            }
        }
        Brain brain = new Brain();
        brain.sleep();
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.performBehavior(false);
    }
}

