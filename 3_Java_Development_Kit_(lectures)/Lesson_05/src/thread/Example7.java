package thread;

import java.util.ArrayList;
import java.util.List;

public class Example7 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                list.add(i);
            }
        }
        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        };
        Runnable r2 = () -> {
            synchronized (list) {
                for (Integer value : list) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}