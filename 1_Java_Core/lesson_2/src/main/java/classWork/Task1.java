package classWork;

import java.util.Arrays;

public class Task1 {
    /**
     * Написать функцию добавления элемента в конец массива таким образом, чтобы она расширяла массив при необходимости.
     * Написать функцию добавления элемента в указанную позицию массива таким образом, чтобы она расширяла массив при
     * необходимости.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        arr = insertIntoArray(arr, 9);
        System.out.println(Arrays.toString(arr));

        arr = insertIntoArray(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Вставка в конец
     *
     * @param arr
     * @param n
     * @return
     */
    public static int[] insertIntoArray(int[] arr, int value) {
        return insertIntoArray(arr, value, arr.length);
    }

    /**
     * Вставка в указанную позицию
     *
     * @param arr
     * @param value
     * @param index
     * @return
     */
    public static int[] insertIntoArray(int[] arr, int value, int index) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Индекс за пределами массива...");
        }
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = value;
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        return newArr;
    }
}
