
# Seminar 2 Spring Core
Домашнее задание
Базовое задание:
Добавить в простое CRUD веб-приложение, которое было разработано на семинаре функцию удаления данных о пользователе:
1) В класс UserRepository добавить метод public void deleteById(int id)(подсказка: SQL запрос "DELETE FROM userTable WHERE id=?", метод  jdbc.update) - удаления записи пользователя из БД по ID.
2) В класс UserService добавить метод public void deleteById(int id)(подсказка: в нем вызывается метод  userRepository.deleteById) - удаление пользователя через репозиторий.
3) В класс UserController добавить метод public String deleteUser(@PathVariable("id") int id)(с аннотацией:  @GetMapping("user-delete/{id}")) (подсказка: в нем вызывается метод userService.deleteById) - перехват команды на удаление студента от браузера.

Если задание выполнено верно, то при запуске приложения по адресу http://localhost:8080/users будет работать кнопка удаления пользователя по ID.

Задание "со звездочкой":
Реализовать метод обновления данных о пользователе.
- @GetMapping("/user-update/{id}")
- @PostMapping("/user-update")
- User update(User user) 
- User getOne(int id)

> SDK version 23, Language level SDK default

# Seminar 4

`mvn clean package` завершается с ошибкой...
Не видит гетеры и сетеры с lombok... С классическим кодом ошибок нет
Пока убрал lombok (ошибку не смог победить...) так как делаю docker- контейнер.

Для создания Docker контейнера со Spring Boot проектом, вам нужно создать `Dockerfile` и настроить его для сборки и запуска приложения. Вот пошаговое руководство.

### 1. Создание исполняемого JAR файла


Если вы используете Maven:
```bash
mvn clean package
```

Если вы используете Gradle:
```bash
gradle clean build
```

Эти команды создадут JAR файл в папке `target` (для Maven) или `build/libs` (для Gradle), например, `myapp-0.0.1-SNAPSHOT.jar`.

### 2. Создание Dockerfile
В корне вашего проекта создайте файл с именем `Dockerfile` со следующим содержимым:

```Dockerfile
# Используем базовый образ с поддержкой Java
FROM openjdk:23-slim

# Копируем JAR-файл приложения в контейнер
COPY target/*.jar /app/users.jar

# Указываем порт, который будет слушать контейнер
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app/users.jar"]
```

### 3. Сборка Docker образа

```bash
docker build -t myapp .
```

Здесь `-t myapp` задает имя образа как `myapp`.

### 4. Запуск контейнера
Когда образ будет создан, запускаю контейнер с помощью команды:

```bash
docker run -p 8080:8080 myapp
```

Здесь:
- `-p 8080:8080` пробрасывает порт `8080` из контейнера в порт `8080` на вашем компьютере. Убедитесь, что этот порт не занят другими приложениями.

Теперь Spring Boot приложение доступно по адресу `http://localhost:8080`.
