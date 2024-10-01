1. Развернем docker container с MySQL
```angular2html
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin -p 3306:3306 -d mysql:latest
```
[Шпаргалка docker](https://habr.com/ru/companies/flant/articles/336654/)

[Как удалить образы, контейнеры и тома Docker](https://timeweb.cloud/tutorials/docker/kak-udalit-obrazy-kontejnery-i-toma-docker)

2. Установим зависимости (JDBC-драйвер и Hibernate)
```angular2html
        <!--   MySQL JDBC Driver   -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>9.0.0</version>
        </dependency>
        <!--   Hibernate   -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
        <!--   C3P0 Connection Pooling   -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-c3p0</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
```

3. Для конфигурации hibernate в нашем проекте, добавим hibernate.cfg.xml в resources
```angular2html
<hibernate-configuration>
    <session-factory>
        <!--  JDBC Database connection settings  -->
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/coursesDB</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">admin</property>
        <!--  JDBC connection pool settings  -->
        <property name="hibernate.c3p0.min_size">5</property>
        <property name="hibernate.c3p0.max_size">20</property>
        <property name="hibernate.c3p0.timeout">300</property>
        <property name="hibernate.c3p0.max_statements">50</property>
        <property name="hibernate.c3p0.idle_test_period">3000</property>
        <!--  Specify dialect  -->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <!--  Echo all executed SQL to stdout  -->
        <property name="hibernate.show_sql">true</property>
        <!--  Context configuration  -->
        <property name="hibernate.current_session_context_class">thread</property>
        <!--  Drop and re-create the database schema on startup  -->
        <property name="hibernate.hbm2ddl.auto">update</property>
        <!-- Mention annotated entity class -->
        <mapping class="models.Course"/>

    </session-factory>
</hibernate-configuration>

```
