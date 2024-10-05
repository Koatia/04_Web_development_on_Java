package homeWork;

import java.util.Arrays;

public class Program {
    /**
     * Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2,
     * 2, 0]) → 3 countEvens([1, 3, 5]) → 0
     * <p>
     * Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого
     * массива.
     * <p>
     * Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым
     * значением.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, -5, 2, 0, 1, 2, 3, 1, 5};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Количество чётных: " + countEvens(arr));
        System.out.println("Разница между max & min: " + diffMaxAndMin(arr));
        System.out.println("Есть два нуля подряд: " + doubleZerro(arr));
    }

    public static int countEvens(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) count++;
        }
        return count;
    }

    public static int diffMaxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return max - min;
    }

    public static boolean doubleZerro(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("В массиве меньше двух элементов...");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0) return true;
        }
        return false;
    }
}
