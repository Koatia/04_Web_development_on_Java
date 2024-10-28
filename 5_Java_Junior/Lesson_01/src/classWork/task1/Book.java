package classWork.task1;

public class Book {
    //region Поля
    private final String title;
    private final String author;
    private final int year;
    //endregion

    //region Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    //endregion

    //region Методы
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "{" + "Наименование: '" + title + '\'' + ", Автор: '" + author + '\'' + ", Год издания: " + year + '}';
    }

    //endregion
}