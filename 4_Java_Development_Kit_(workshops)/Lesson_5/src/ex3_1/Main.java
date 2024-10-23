package ex3_1;

/*
В рамках выполнения задачи необходимо:
3 бегуна должны прийти к старту гонки
Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
Программа должна отсчитать “На старт”, “Внимание”, “Марш”
Программа должна завершиться когда все участники закончат гонку.
Подумайте об использовании примитива синхронизации
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        int COUNT_RUNERS = 3;
        CountDownLatch readySignal = new CountDownLatch(COUNT_RUNERS);
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(COUNT_RUNERS);

        List<Runners> runers = new ArrayList<>(
                Arrays.asList(new Runners("Вася", readySignal, startSignal, finishSignal),
                        new Runners("Петя", readySignal, startSignal, finishSignal),
                        new Runners("Ваня", readySignal, startSignal, finishSignal)));
        new Thread(new Rice(readySignal, startSignal, finishSignal)).start();
        for (Runners runner : runers) {
            new Thread(runner).start();
        }
    }
}