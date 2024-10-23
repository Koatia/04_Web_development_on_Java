package homeWork;
/*
3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair<T, U> {
    private final T first;
    private final U second;

    // Конструктор для инициализации пары значений
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "один");
        Pair<String, Double> pair2 = new Pair<>("pi", 3.14);

        System.out.println(pair1.getFirst());  // 1
        System.out.println(pair1.getSecond()); // one
        System.out.println(pair1);             // (1, one)

        System.out.println(pair2.getFirst());  // pi
        System.out.println(pair2.getSecond()); // 3.14
        System.out.println(pair2);             // (pi, 3.14)
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}