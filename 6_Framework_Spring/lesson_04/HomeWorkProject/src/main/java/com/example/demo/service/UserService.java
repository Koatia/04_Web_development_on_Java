package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Вызов метода, который возвращает список всех пользователей из базы данных
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Вызов метода, который добавляет в базу данных нового пользователя
     *
     * @param user пользователь (объект класса User)
     * @return пользователь (объект класса User)
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Вызов метода, который удаляет пользователя с указанным ID из базы данных
     *
     * @param id ID пользователя
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Вызов метода, который обновляет данные о пользователе в базе данных
     *
     * @param user пользователь (объект класса User)
     */
    public void updateUser(User user) {
        userRepository.update(user);
    }

    /**
     * Вызов метода, который возвращает из базы пользователя с указанным ID
     *
     * @param id ID пользователя
     * @return пользователь
     */
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
