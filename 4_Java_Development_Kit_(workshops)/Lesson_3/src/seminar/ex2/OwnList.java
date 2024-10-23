/*
Описать собственную коллекцию – список на основе массива.
Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
 */

package seminar.ex2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class OwnList<T> {
    private Object[] arr;
    private int size;

    public OwnList() {
        arr = new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[size++] = item;
    }

    public T remove() {
        if (size == 0)
            throw new NoSuchElementException();
        T temp = (T) arr[--size];
        arr[size] = null;
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}