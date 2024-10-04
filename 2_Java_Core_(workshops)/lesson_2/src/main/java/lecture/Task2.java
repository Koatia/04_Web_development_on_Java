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
}
