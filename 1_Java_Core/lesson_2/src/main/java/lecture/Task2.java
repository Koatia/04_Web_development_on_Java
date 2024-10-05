package lecture;

import java.util.Arrays;

public class Task2 {

    /**
     * Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический (последний
     * элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(shift(arr, 3)));

    }

    public static int[] shift(int[] arr, int count) {
        int temp;
        for (int i = 0; i < count; i++) {
            temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
        return arr;
    }

    /**
     * Вариант решения из методички
     *
     * @param a
     * @param n
     */
    private static void shifter(int[] a, int n) {
        n %= a.length;
        int shift = a.length + n;
        shift %= a.length;
        for (int i = 0; i < shift; i++) {
            int temp = a[a.length - 1];
            System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0] = temp;
        }
    }
}
