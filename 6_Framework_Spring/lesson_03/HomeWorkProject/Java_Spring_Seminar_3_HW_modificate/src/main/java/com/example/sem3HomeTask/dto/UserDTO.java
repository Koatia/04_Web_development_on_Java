package com.example.sem3HomeTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
@Schema(description = "UserDto")
public class UserDTO {

    @Schema(description = "Имя пользователя", example = "Ivan")
    @Size(min = 2, max = 50,
            message = "Имя должно быть более 2 символов и менее 50 символов!")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]+", message = "Имя должно состоять из букв!")
    private String name;
    @Schema(description = "Возраст пользователя", example = "35")
    @NotNull
    @Min(value = 1, message = "Возраст не может быть меньше 1 года!")
    @Max(value = 120, message = "Возраст не может быть больше 120!")
    private int age;

    @Schema(description = "email пользователя", example = "ivan@mail.ru")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]+",
            message = "Формат email должен быть ivan@mail.ru")
    private String email;

    // region геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // endregion
}
