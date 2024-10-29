package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Главная страница
     * @param model
     * @return список пользователей
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Форма для ввода данных в поля для нового пользователя
     * @param user создаваемый объект класса User
     * @return эта же форма
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /**
     * Обработчик нажатия кнопки Create user на форме для ввода данных нового пользователя
     * @param user создаваемый объект класса User
     * @return redirect на главную страницу
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Удаление пользователя (по Id)
     * @param id Id пользователя
     * @return redirect на главную страницу
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Форма редактирования полей пользователя
     * @param id Id пользователя
     * @param model
     * @return эта же форма
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Обработчик нажатия кнопки Update User
     * @param user Объект класса User
     * @return redirect на главную страницу
     */
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
