package ru.example;

/**
 * Внутренние классы создаются внутри другого класса.
 */
public class Orange {
    private Juice juice;

    public Orange() {
        this.juice = new Juice();
    }

    public void squeezeJuice() {
        System.out.println("Squeeze juice ...");
        juice.flow();
    }

    private class Juice {
        public void flow() {
            System.out.println("Juice dripped ...");
        }
    }

    public static void main(String[] args) {
        Orange orange = new Orange();
        orange.squeezeJuice();
    }
}
