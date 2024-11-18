package homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {
    private final Lock lock = new ReentrantLock();

    public boolean pickUp() {
        return lock.tryLock(); // Попытка захватить вилку (true, если успешно)
    }

    public void putDown() {
        lock.unlock(); // Освобождаем вилку
    }
}