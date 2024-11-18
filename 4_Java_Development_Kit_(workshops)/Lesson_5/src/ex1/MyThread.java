package ex1;

public class MyThread extends Thread {
    private final Friend friend1;
    private final Friend friend2;

    public MyThread(Friend friend1, Friend friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    @Override
    public void run() {
        friend1.bow(friend2);
    }
}