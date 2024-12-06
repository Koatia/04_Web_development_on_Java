package classWork.task1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    /*
    - Найти все книги, написанные определенным автором
    - Найти все книги, написанные после определенного года
    - Найти все уникальные названия книг в библиотеке
    */

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достаевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мистер и Маргарита", "Михаил Булгаков", 1967));

        // Поиск книг, написанных определенным автором
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if ("Лев Толстой".equals(book.getAuthor())) {
                authorBooks.add(book);
            }
        }
        System.out.println("Лев Толстой: " + authorBooks);

        // Поиск книг, написанных определенным автором
        List<Book> authorAfterYear = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 1866) {
                authorAfterYear.add(book);
            }
        }
        System.out.println("Книги после 1866: " + authorAfterYear);

        // Все уникальные названия книг в библиотеке
        List<String> uniqueTitles = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitles.contains(book.getTitle())) {
                uniqueTitles.add(book.getTitle());
            }
        }
        System.out.println("Все уникальные названия книг: " + uniqueTitles);
    }
}