1. Развернем docker container с MySQL
```angular2html
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin -p 3306:3306 -d mysql:latest
```
[Шпаргалка docker](https://habr.com/ru/companies/flant/articles/336654/)

[Как удалить образы, контейнеры и тома Docker](https://timeweb.cloud/tutorials/docker/kak-udalit-obrazy-kontejnery-i-toma-docker)

2. Установим зависимость (JDBC-драйвер)
```angular2html
<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.0.0</version>
</dependency>
```

3. Для поддержки hibernate в нашем проекте, добавим зависимость в pom.xml
```angular2html
<!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-java8</artifactId>
    <version>6.0.0.Alpha7</version>
    <type>pom</type>
</dependency>

```
