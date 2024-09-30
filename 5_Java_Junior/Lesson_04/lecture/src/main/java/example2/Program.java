package example2;

public class Program {
    public static void main(String[] args) {
        Db.deleted();  //Удаляем записи из таблицы
        Db.insert();  // Заполняем БД
        Db.select();  //Читаем из БД
        Db.update();  //Меняем значения полей
        Db.select();  //Читаем из БД
    }
}
