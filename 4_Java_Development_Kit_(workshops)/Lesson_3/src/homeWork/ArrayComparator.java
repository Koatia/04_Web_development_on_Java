package homeWork;
/*
2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class ArrayComparator {

    // Обобщённый метод для сравнения двух массивов
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        // Проверяем, одинаковой ли длины массивы
        if (array1.length != array2.length) {
            return false;
        }

        // Сравниваем классы элементов массивов
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().equals(array2[i].getClass())) {
                return false;
                // Сравниваем элементы массивов
            } else if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] arr1 = {"apple", "banana", "cherry"};
        String[] arr2 = {"pear", "banana", "cherry"};
        Integer[] arr3 = {1, 2, 3};
        String[] arr4 = {"apple", "banana", "cherry"};
        System.out.println(compareArrays(arr1, arr2)); // false
        System.out.println(compareArrays(arr1, arr3)); // false
        System.out.println(compareArrays(arr1, arr4)); // true
    }
}