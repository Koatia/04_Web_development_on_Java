package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод возвращает список всех пользователей из базы данных
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод добавляет в базу данных нового пользователя
     *
     * @param user пользователь (объект класса User)
     * @return пользователь (объект класса User)
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод удаляет пользователя с указанным ID из базы данных
     *
     * @param id ID пользователя
     */
    public void deleteById(Long id) {
        String sql = "DELETE FROM userTable WHERE id = ?";
        jdbc.update(sql, id);
    }

    /**
     * Метод обновляет данные о пользователе в базе данных
     *
     * @param user пользователь (объект класса User)
     */
    public void update(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }

    /**
     * Метод возвращает из базы пользователя с указанным ID
     *
     * @param id ID пользователя
     * @return пользователь
     */
    public User getUserById(Long id) {
        String sql = "SELECT * FROM userTable WHERE id = ?";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.queryForObject(sql, userRowMapper, id);
    }
}
