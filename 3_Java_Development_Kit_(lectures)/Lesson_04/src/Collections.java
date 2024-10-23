import java.util.*;

public class Collections {
    public static void main(String[] args) {

        // Массив Array
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);
        // Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // For each
        for (Integer value : collection) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Stream api
        collection.stream().forEach(value -> System.out.print(value + " "));
        System.out.println();

        collection.stream().forEach(System.out::print);   // второй вариант вместо лямбда-функции
        System.out.println();

        // Interface ArrayList
        ArrayList<Integer> list = new ArrayList<>(collection);

        // Interface Map
        Map<String, Integer> map = Map.of("Hallo", 1, "World", 2);
        // For each entrySet()
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // For each keySet()
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
        System.out.println();

        // Stream
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}