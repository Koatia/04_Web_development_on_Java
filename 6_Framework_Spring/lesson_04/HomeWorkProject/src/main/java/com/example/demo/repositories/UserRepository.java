package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;
    private final SqlCMD sqlCMD;

    public UserRepository(JdbcTemplate jdbc, SqlCMD sqlCMD) {
        this.jdbc = jdbc;
        this.sqlCMD = sqlCMD;
    }

    /**
     * Метод возвращает список всех пользователей из базы данных
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sqlCMD.getFindAll(), userRowMapper);
    }

    /**
     * Метод добавляет в базу данных нового пользователя
     *
     * @param user пользователь (объект класса User)
     * @return пользователь (объект класса User)
     */
    public User save(User user) {
        jdbc.update(sqlCMD.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод удаляет пользователя с указанным ID из базы данных
     *
     * @param id ID пользователя
     */
    public void deleteById(Long id) {
        jdbc.update(sqlCMD.getDeleteById(), id);
    }

    /**
     * Метод обновляет данные о пользователе в базе данных
     *
     * @param user пользователь (объект класса User)
     */
    public void update(User user) {
        jdbc.update(sqlCMD.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }

    /**
     * Метод возвращает из базы пользователя с указанным ID
     *
     * @param id ID пользователя
     * @return пользователь
     */
    public User getUserById(Long id) {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(sqlCMD.getGetUserById(), userRowMapper, id);
    }
}
