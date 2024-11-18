package homework;

public class Main {
    private static final int count = 5; // Количество философов / вилок

    public static void main(String[] args) {
        Fork[] forks = new Fork[count];

        for (int i = 0; i < count; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < count; i++) {
            new Thread(new Philosopher(i, forks[(i + 1) % count], forks[i])).start();
        }
    }
}