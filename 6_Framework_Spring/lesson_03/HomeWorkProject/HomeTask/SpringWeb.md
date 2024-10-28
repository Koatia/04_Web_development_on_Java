Создание веб-приложения с использованием Spring Web — это процесс построения серверного приложения на Java, где Spring Web играет роль основного фреймворка для обработки HTTP-запросов и ответов. Давай разберем основные этапы создания такого приложения.

### 1. **Создание проекта**

Для начала можно создать проект с использованием Spring Initializr. Это веб-инструмент, который позволяет быстро сгенерировать структуру проекта Spring:

- Перейди на [Spring Initializr](https://start.spring.io/).
- Выбери нужные параметры, такие как:
  - **Project**: Maven или Gradle (оба поддерживаются Spring).
  - **Language**: Java.
  - **Spring Boot**: последняя версия.
  - **Dependencies**: добавь **Spring Web** для создания веб-приложений.

Нажми на **Generate** — скачанный архив будет содержать базовую структуру проекта.

### 2. **Структура проекта**

При создании проекта Spring Boot автоматически формирует базовую структуру:

- **src/main/java** – содержит основной код приложения.
  - **Application** – основной класс приложения с аннотацией `@SpringBootApplication`. Это точка входа для запуска Spring Boot-приложения.
- **src/main/resources** – хранит ресурсы, такие как:
  - **application.properties** или **application.yml** – файл конфигурации для настройки приложения.

### 3. **Настройка основного класса приложения**

В основном классе приложения, как правило, будет аннотация `@SpringBootApplication`, которая включает сразу несколько других аннотаций (`@Configuration`, `@EnableAutoConfiguration`, и `@ComponentScan`). Этот класс отвечает за запуск Spring Boot-приложения.

Пример кода:

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### 4. **Создание контроллеров (Controller)**

Контроллеры обрабатывают HTTP-запросы и возвращают ответы. Для этого создается класс с аннотацией `@RestController` или `@Controller`.

Пример REST-контроллера:

```java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Web!";
    }
}
```

Здесь:
- `@RestController` указывает, что это REST-контроллер.
- `@RequestMapping("/api")` устанавливает базовый URL.
- `@GetMapping("/hello")` маппит GET-запрос на метод `hello()`.

### 5. **Работа с сервисами (Service)**

Логика приложения обычно выносится в отдельные сервисные классы, помеченные аннотацией `@Service`. Это помогает структурировать код, делая контроллеры "чистыми" от бизнес-логики.

```java
package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getGreeting() {
        return "Hello from Service!";
    }
}
```

### 6. **Работа с репозиториями (Repository)**

Если приложение работает с базой данных, то для этого используется слой доступа к данным с аннотацией `@Repository`. Spring Data JPA, например, предоставляет готовые методы для взаимодействия с базой данных.

```java
package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

### 7. **Создание модели (Model)**

Модели описывают данные, с которыми работает приложение. В Spring такие классы обычно помечают аннотациями JPA, если данные хранятся в базе.

```java
package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Геттеры и сеттеры
}
```

### 8. **Конфигурация в `application.properties`**

В файле `application.properties` или `application.yml` можно указать различные параметры, такие как:

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=user
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update
```

### 9. **Запуск и тестирование приложения**

Запустить приложение можно, вызвав команду `mvn spring-boot:run` (если используешь Maven) или запустив основной класс приложения. После запуска приложение будет доступно по адресу `http://localhost:8081` (если порт не изменен).

Проверить, работает ли контроллер, можно, перейдя по адресу `http://localhost:8081/api/hello`, и увидеть в ответе `Hello, Spring Web!`.

### Итоги

Вот общая схема построения Spring Web-приложения:

1. **Инициализация проекта** через Spring Initializr.
2. **Конфигурация основного класса приложения**.
3. **Создание контроллеров** для обработки HTTP-запросов.
4. **Создание сервисов** для бизнес-логики.
5. **Создание репозиториев** для работы с базой данных.
6. **Настройка моделей** для данных.
7. **Конфигурация параметров** в файле `application.properties`.
8. **Запуск и тестирование**.

Эти шаги помогут создать простое веб-приложение на Spring Web.