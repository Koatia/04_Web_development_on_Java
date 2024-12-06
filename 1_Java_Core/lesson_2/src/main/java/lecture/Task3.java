package lecture;

import java.util.Arrays;

public class Task3 {

    /**
     * Написать метод, которому можно передать в качестве аргумента массив, состоящий строго из единиц и нулей (целые
     * числа типа int). Метод должен заменить единицы в массиве на нули, а нули на единицы и не содержать ветвлений.
     * Написать как можно больше вариантов метода
     */

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0};

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(change(arr)));

    }

    private static int[] change(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 - a[i];
        }
        return a;
    }
}
