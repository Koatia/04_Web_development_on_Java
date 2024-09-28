package ex2_1;

public class ThreadB implements Runnable {
    private final ThreadA threadA;
    private int counter = 100;

    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        while (counter >= 0) {
            if (threadA.isSwitcher()) {
                try {
                    Thread.sleep(100);
                    System.out.println(counter--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}