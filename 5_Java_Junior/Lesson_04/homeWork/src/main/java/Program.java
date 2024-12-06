

import models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class Program {

    /**
     * Создайте базу данных SchoolDB. В этой базе данных создайте таблицу courses с полями id (ключ), title , duration.
     * Настройте Hibernate, связав его с вашей базой данных. Создайте класс Course в Java, аннотируя его как сущность
     * Hibernate. Используя Hibernate, реализуйте вставку, чтение, обновление и удаление данных в таблице courses.
     * Обратите внимание на использование сессий и транзакций в Hibernate.
     */

    public static void main(String[] args) throws SQLException {
        // Создам базу данных SchoolDB и таблицу courses с использованием провайдера JDBC
        MakeDB.prepareDB();

        SessionFactory sessionFactory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
                        .buildSessionFactory();

        // Создание сессии
        Session session = sessionFactory.getCurrentSession();

        try {
            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course course = Course.create();

            // Сохранение объекта в базе данных
            session.persist(course);  //вместо .save
            System.out.println("Object course save successfully");

            // Чтение объекта из базы данных
            Course retrievedCourse = session.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            // Обновление объекта
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.persist(retrievedCourse);  //вместо .update
            System.out.println("Object course update successfully");

            // Удаление объекта
            //session.delete(retrievedCourse);
            //System.out.println("Object course delete successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        } finally {
            // Закрытие фабрики сессий
            sessionFactory.close();
        }
    }
}
