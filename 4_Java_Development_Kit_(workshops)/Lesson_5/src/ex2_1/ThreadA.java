package ex2_1;

public class ThreadA implements Runnable {
    private volatile boolean switcher;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println(switcher);
            } catch (InterruptedException e) {
                System.out.println("Program is ended!");
                break;
            }
        }
    }

    public boolean isSwitcher() {
        return switcher;
    }
}