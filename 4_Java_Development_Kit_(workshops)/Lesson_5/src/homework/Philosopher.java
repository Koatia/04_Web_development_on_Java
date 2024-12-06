package homework;

import java.util.Random;

class Philosopher extends Thread {
    private final int number;
    private final Fork leftFork;
    private final Fork rightFork;
    private final int COUNT_EATING = 3;
    private int countEating = 0;

    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() {
        System.out.println("Philosopher № " + number + " is thinking");
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher № " + number + " is eating " + (++countEating));
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            think();
            while (countEating < COUNT_EATING) {
                if (tryToPickUpBothForks()) {
                    try {
                        eat(); // философ ест
                    } finally {
                        // освобождаем вилки после еды
                        leftFork.putDown();
                        rightFork.putDown();
                        think();
                    }
                }
                Thread.sleep(new Random().nextInt(200, 600));  // пауза перед следующей попыткой
            }
            System.out.println("Philosopher № " + number + " is full");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean tryToPickUpBothForks() {
        if (leftFork.pickUp()) {
            if (rightFork.pickUp()) {
                return true;
            } else {
                leftFork.putDown(); // Если не удалось взять правую вилку, освобождаем левую
            }
        }
        return false;
    }
}