package classWork;

import java.util.Arrays;
import java.util.TreeMap;

public class Task2 {
    /**
     * Написать метод, осуществляющий сортировку одномерного массива подсчётом. Важное ограничение состоит в том, что
     * для этой сортировки диапазон значений исходного массива должен находиться в разумных пределах, например, не
     * более
     * 1000.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -5, 2, 3, 4, 12, 2, 3, 4, 5, 2, 3, 1, 5};
        System.out.println(Arrays.toString(arr));
        pigeon1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void pigeon1(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // для подсчета количества значений
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int arrIndex = 0;
        for (int key : map.keySet()) {
            for (int j = 0; j < map.get(key); j++) {
                arr[arrIndex++] = key;
            }
        }
    }

    public static void pigeon2(int[] arr) {
        int min = getMin(arr);
        int max = getMax(arr);
        int[] freq = new int[max - min + 1];  // Массив для подсчета количества значений

        for (int j : arr) freq[j - min]++;

        int arrIndex = 0;
        for (int i = 0; i < freq.length; i++)
            for (int elems = freq[i]; elems > 0; elems--)
                arr[arrIndex++] = i + min;
    }

    private static int getMin(int[] a) { // returns the minimum value
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    private static int getMax(int[] a) {
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
