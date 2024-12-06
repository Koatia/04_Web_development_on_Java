/**
 * Задание: Класс «Проверка логина и пароля».
 * 1. Создать статический метод который принимает на вход три параметра:
 * login, password и confirmPassword.
 * 2. Длина login должна быть меньше 20 символов. Если login не соответствует
 * этому требованию, необходимо выбросить WrongLoginException.
 * 3. Длина password должна быть не меньше 20 символов. Также password и confirmPas
 * должны быть равны. Если password не соответствует этим требованиям, необходимо
 * выбросить WrongPasswordException.
 * 4. WrongPasswordException и WrongLoginException – пользовательские классы
 * исключения с двумя конструкторами –- один по умолчанию, второй принимает
 * параметры исключения (неверные данные) и возвращает пользователю в
 * виде «ожидалось/фактически».
 * 5. В основном классе программы необходимо по-разному обработать исключения.
 * 6. Метод возвращает true, если значения верны или false в противном случае.
 */

public class Task1 {
    private static int LENGHT = 20;

    public static Boolean checkLogin(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= LENGHT) {
                throw new WrongLoginException(LENGHT, login.length());
            }
            if (password.length() < LENGHT) {
                String expected = "20";
                String actual = String.format("%02d", password.length());
                throw new WrongPasswordException(expected, actual);
            }
            if (!confirmPassword.equals(password)) {
                String expected = "password и confirmPas должны быть равны";
                String actual = String.format("%s != %s", password, confirmPassword);
                throw new WrongPasswordException(expected, actual);
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class WrongLoginException extends RuntimeException {
        WrongLoginException() {
            super("Wrong login or password");
        }

        WrongLoginException(int expected, int actual) {
            super(String.format("Wrong login length: expected '%s', actual '%s'", expected, actual));
        }
    }

    private static class WrongPasswordException extends RuntimeException {
        WrongPasswordException() {
            super("Wrong password");
        }

        WrongPasswordException(String expected, String actual) {
            super(String.format("Wrong password: expected '%s', actual '%s'", expected, actual));
        }
    }

    public static void main(String[] args) {
        System.out.println(checkLogin("login", "passwordpasswordpassword", "passwordpasswordpasswordpassword"));
    }
}
