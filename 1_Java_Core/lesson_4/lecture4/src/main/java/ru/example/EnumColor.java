package ru.example;

/**
 * Раз перечисление – это класс, возможно определять в нём поля, методы,
 * конструкторы и прочее. Перечисление Color определяет приватное поле code для
 * хранения кода цвета, а с помощью метода getCode он возвращается.
 */
public class EnumColor {
    enum Color {
        RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
        private String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.printf("%s(%s) ", color, color.getCode());
        }
    }
}