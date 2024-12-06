package thread;

public class Example1 {
    // Три способа запуска потоков
    public static void main(String[] args) {

        //  System.out.println(Thread.currentThread());   // [ID, имя, приоритет и группа] thread, который сейчас выполняется
        for (int i = 0; i < 3; i++) {
            new MyThread().start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new MyRunnable()).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("3. Hello from: " + Thread.currentThread());
            }).start();
        }
    }
}