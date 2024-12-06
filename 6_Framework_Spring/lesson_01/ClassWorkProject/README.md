### Установка `maven` & `gradle`

```bash
sudo pacman -S maven gradle
```
---
## Maven
Для создания простого Java-проекта выполните следующую команду:

```bash
mvn archetype:generate -DgroupId=ru.kostia -DartifactId="myMavenProject" -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Здесь `ru.kostia` — это пример groupId, а `myMavenProject` — artifactId вашего проекта. Вы можете заменить их на свои значения. После выполнения команды Maven создаст новую директорию с именем `myMavenProject`, содержащую структуру проекта.

Чтобы собрать ваш проект, перейдите в директорию `myMavenProject` и выполните следующую команду:
```bash
cd myMavenProject
mvn package
```
Maven выполнит сборку проекта, запустит тесты и создаст исполняемый JAR-файл в
директории target.
Для запуска собранного приложения выполните команду:
```bash
cd myMavenProject
java -cp target/myProject-1.0-SNAPSHOT.jar ru.kostia.App
```
Эта команда запустит класс App из пакета com.mycompany.app. Если все сделано
правильно, вы увидите следующий вывод:
Hello, World!

---
## Gradle

Для создания простого Java-проекта:

Для начала создайте новую папку для вашего проекта и перейдите в нее с помощью терминала.
Затем выполните следующую команду для инициализации Gradle-проекта с использованием шаблона Java-проекта:
```bash
gradle init --type java-application
```

Эта команда создаст структуру каталогов проекта, файл build.gradle со стандартной
конфигурацией и пример Java-класса с методом main().
