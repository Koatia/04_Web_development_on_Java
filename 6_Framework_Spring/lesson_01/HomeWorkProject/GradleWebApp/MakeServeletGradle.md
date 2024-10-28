## Структура Gradle-проекта (Groovy):

```
GradleWebApp
│
├── build.gradle
├── settings.gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ru
│   │   │       └── example
│   │   │           └── HelloServlet.java
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── web.xml
│   │       └── index.jsp
└── build
```

### 2. Настройка проекта

#### 2.1. `build.gradle`

Это основной файл сборки Gradle. Он содержит зависимости, плагины и другие настройки для сборки и запуска проекта.

```groovy
plugins {
    id 'java'
    id 'war' // Плагин для создания WAR-файла
}

group = 'ru.example'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    // Зависимость для Servlet API
    implementation 'jakarta.servlet:jakarta.servlet-api:6.1.0'

    // Зависимости для Jetty
    implementation 'org.eclipse.jetty:jetty-server:11.0.24'  // Обновленная версия Jetty
    implementation 'org.eclipse.jetty:jetty-servlet:11.0.24'
    implementation 'org.eclipse.jetty:jetty-webapp:11.0.24'  // Последняя версия для поддержки веб-приложений
    implementation 'org.eclipse.jetty:jetty-util:11.0.24'    // Последняя версия утилит Jetty

    // Логирование (SLF4J) — используем стабильную версию
    // Зависимость для Logback (вместо SLF4J Simple)
    implementation 'ch.qos.logback:logback-classic:1.5.11'
    implementation 'ch.qos.logback:logback-core:1.5.11'
}

// Настройка сборки для WAR
war {
    from("src/main/webapp") {
        include '**'
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // Игнорировать дубликаты
}

// Задача для запуска Jetty
tasks.register('runJetty', JavaExec) {
    classpath = sourceSets.main.runtimeClasspath
    mainClass.set('ru.example.JettyStart') // Используем mainClass вместо main (устаревший)
}
```

#### 2.2. `settings.gradle`

Файл для указания названия проекта:

```groovy
rootProject.name = 'GradleWebApp'
```

#### 2.3. `HelloServlet.java`

Класс сервлета, такой же, как в проекте на Maven. Убедитесь, что пакет совпадает с тем, что указано в `web.xml`.

```java
package ru.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello, World!</h1>");
    }
}
```

### для `Jetty 11`
Так как вы используете Jetty 11 (и выше), правильный способ запуска Jetty в режиме встроенного сервера с использованием JavaExec заключается в указании главного класса, который инициализирует Jetty сервер. Ниже приведен пример встроенного сервера Jetty:

Создайте класс для запуска Jetty, который будет использовать API Jetty для запуска сервера.

```java
package ru.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Java-класс, который будет использовать API Jetty для запуска сервера.
 * Этот код создаёт Jetty-сервер, который будет слушать на порту 8080 и обрабатывать запросы на /hello
 */
public class JettyStart {

    public static void main(String[] args) throws Exception {
        // Создаем сервер на порту 8080
        Server server = new Server(8080);

        // Создаем контекст для сервлетов
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Добавляем сервлет
        context.addServlet(new ServletHolder(new HelloServlet()), "/hello");

        // Запускаем сервер
        server.start();
        server.join();
    }
}
```

#### 2.4. `web.xml`

Файл конфигурации `web.xml` для регистрации сервлета, такой же, как в Maven-проекте:

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <servlet> <!--    здесь прописан путь к Java-классу-->
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>ru.example.HelloServlet</servlet-class>

    </servlet>
    <servlet-mapping> <!--        здесь прописан путь к куску адресной строки, вызывающей сервлет-->
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

</web-app>
```

#### 2.5. `index.jsp`

Файл JSP, который будет загружаться по умолчанию:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome to my web application!</h2>
</body>
</html>
```

### 3. Сборка и запуск проекта

#### 3.1. Сборка проекта

Для сборки проекта выполните команду:

```bash
gradle clean build
```

#### 3.2. Запуск проекта

Чтобы запустить проект на Jetty в `build.gradle` должен быть добавлен task `runJetty`

Затем выполните команду:

```bash
gradle runJetty
```

### 4. Пример запроса к сервлету

После успешного запуска проекта, сервлет будет доступен по URL:

[http://localhost:8080/hello](http://localhost:8080/hello)


Вы должны увидеть сообщение **Hello, World!**
