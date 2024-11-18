package lecture;

public class Task1 {
    /**
     * 1. Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифрования и числовым ключом;
     */

    public static String input, output;

    public static void main(String[] args) {

        System.out.println(caesarCode("Привет!", 300, true));
        System.out.println(caesarCode("Ջլդ՞ածō", 300, false));

    }

    public static String caesarCode(String str, int shift, boolean code) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if (code == true) {
                output += Character.toString(str.charAt(i) + shift);
            } else {
                output += Character.toString(str.charAt(i) - shift);
            }

        }
        return output;
    }

    /**
     * Вариант решения из методички
     *
     * @param in
     * @param key
     * @param encrypt
     * @return
     */
    private static String caesar(String in, int key, boolean encrypt) {
        if (in == null || in.isEmpty()) return null;
        final int len = in.length();
        char[] out = new char[len];
        for (int i = 0; i < len; ++i) {
            out[i] = (char) (in.charAt(i) + ((encrypt) ? key : -key));
        }
        return new String(out);
    }
}
