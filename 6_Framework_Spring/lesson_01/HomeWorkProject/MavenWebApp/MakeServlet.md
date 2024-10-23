### 1. Структура Maven-проекта с простым сервлетом.

```
MavenWebApp
│
├── pom.xml
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
└── target
```

### 2. Детали проекта

#### 2.1. `pom.xml`

Файл `pom.xml` является основным конфигурационным файлом для Maven.
В нём указываем необходимые зависимости и плагины.

```xml

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>ru.example</groupId>
    <artifactId>MavenWebApp</artifactId>
    <packaging>war</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>MavenWebApp Maven Webapp</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.1.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
    <build>
        <finalName>MavenWebApp</finalName>
        <plugins>
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>11.0.24</version>
            </plugin>
        </plugins>
    </build>
</project>
```

#### 2.2. `HelloServlet.java`

Это пример простого сервлета, который возвращает текст "Hello, World!".

```java
package ru.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello, World!</h1>");
    }
}
```

Этот сервлет будет доступен по URL `http://localhost:8080/hello`.

#### 2.3. `web.xml`

Файл `web.xml` находится в папке `WEB-INF` и отвечает за конфигурацию веб-приложения.
Для использования сервлетов начиная с версии Java EE 6 и выше можно не добавлять сервлет в `web.xml`, но вот минимальный пример:

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

#### 2.4. `index.jsp`

Это простой JSP файл, который можно использовать как домашнюю страницу:

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

Чтобы собрать проект и запустить его, выполните следующие команды:

1. Соберите проект с помощью Maven:

   ```bash
   mvn clean install
   ```

2. Запустите Jetty сервер:

   ```bash
   mvn jetty:run
   ```

После этого приложение будет доступно по адресу: `http://localhost:8080/`.

### 4. Пример запроса к сервлету

Для обращения к сервлету перейдите по адресу:

[http://localhost:8080/](http://localhost:8080/)

Вы должны увидеть сообщение **Hello, World!**