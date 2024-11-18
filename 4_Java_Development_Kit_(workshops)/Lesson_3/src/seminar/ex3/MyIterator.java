/*
Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа,
содержащим любые типы данных. Итераторы обычно имеют только два метода – проверка на наличие
следующего элемента и переход к следующему элементу. Но также, особенно в других языках программирования,
возможно встретить итераторы, реализующие дополнительную логику.
 */

package seminar.ex3;

import java.util.Iterator;
import java.util.List;

public class MyIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int index;

    public MyIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}