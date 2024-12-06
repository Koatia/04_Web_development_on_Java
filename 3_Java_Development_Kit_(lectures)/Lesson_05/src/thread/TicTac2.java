package thread;

public class TicTac2 implements Runnable {
    private final String bracket;
    private final Object monitor;

    public TicTac2(String bracket) {
        this.bracket = bracket;
        this.monitor = TicTac2.class;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                System.out.print(bracket);
                try {
                    Thread.sleep(300);
                    monitor.notify();
                    monitor.wait();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}