package thread;

import java.util.concurrent.CountDownLatch;

public class Task2 implements Runnable {

    private int value;
    private CountDownLatch cdl;

    public Task2(int value) {
        this.value = value;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void inc() {
        // public synchronized void inc() {
        synchronized (Task.class) {
            value++;
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown();
    }

}