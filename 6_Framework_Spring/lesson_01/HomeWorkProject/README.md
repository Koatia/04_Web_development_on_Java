## Задание:

Создайте простое веб-приложение с использованием Maven и Gradle.
Сравните их возможности и поделитесь своими мыслями.

---

### 1: Создание веб-приложения с использованием Maven

#### Установка Maven

Убедитесь, что у вас установлен Maven. Проверить это можно командой:

```bash
mvn -v
```

Если Maven не установлен, вы можете установить его,
следуя [официальной документации](https://maven.apache.org/install.html).

#### Создание нового Maven проекта

Создайте новое веб-приложение с использованием архетипа для Java:

```bash
mvn archetype:generate -DgroupId=ru.example -DartifactId=MavenWebApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

#### Настройка Maven проекта

[Описание настройки проекта](MavenWebApp/MakeServlet.md)

---

### 2: Создание веб-приложения с использованием Gradle

#### Установка Gradle

Убедитесь, что Gradle установлен:

```bash
gradle -v
```

Если Gradle не установлен, вы можете установить его, следуя [официальной документации](https://gradle.org/install/).

#### Создание нового Gradle проекта

Создайте проект с простой структурой:

```bash
gradle init --type java-application
```

```
gradle init --type java-application
Starting a Gradle Daemon (subsequent builds will be faster)

Enter target Java version (min: 7, default: 21): 23

Project name (default: GradleWebApp): 

Select application structure:
  1: Single application project
  2: Application and library project
Enter selection (default: Single application project) [1..2] 

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] 

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no] 


> Task :init
Learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.10.2/samples/sample_building_java_applications.html

BUILD SUCCESSFUL in 59s
1 actionable task: 1 executed
[kostia@kostia-ms7d96 GradleWebApp]$ gradle init --type java-application

Enter target Java version (min: 7, default: 21): 23

Project name (default: GradleWebApp): 

Select application structure:
  1: Single application project
  2: Application and library project
Enter selection (default: Single application project) [1..2] 

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] 

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no] yes


> Task :init
Learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.10.2/samples/sample_building_java_applications.html

BUILD SUCCESSFUL in 32s
1 actionable task: 1 executed
```

[Описание настройки проекта](GradleWebApp/MakeServeletGradle.md)

---

### Сравнение Maven и Gradle

#### 1. **Файлы конфигурации**

- **Maven** использует XML-файл `pom.xml`, где все зависимости, плагины и конфигурации прописываются декларативно.
  Это делает его несколько более громоздким и сложным для чтения при увеличении количества зависимостей.
- **Gradle** использует файл `build.gradle`, который основан на языке Groovy (или Kotlin).
  Это делает его более лаконичным и гибким.
  Gradle позволяет писать скрипты и использовать программные конструкции, такие как циклы и условия.

#### 2. **Зависимости и плагины**

- В **Maven** зависимости указываются декларативно, а для работы с ними используются плагины.
  Maven централизованно использует репозитории (например, Maven Central).
- **Gradle** поддерживает все возможности Maven, но также более гибко управляет зависимостями, предоставляя больше
  возможностей для кастомизации сборочного процесса.

#### 3. **Скорость сборки**

- **Gradle** быстрее за счёт кэширования задач и инкрементальной сборки.
  В реальных проектах разница может быть значительной.
- **Maven** более линейный, и при изменениях в коде пересобирает проект целиком.

#### 4. **Учебная кривая и гибкость**

- **Maven** проще в освоении, так как имеет строго определённую структуру.
  Однако эта же строгая структура делает его менее гибким.
- **Gradle** более гибкий, что даёт больше возможностей для настроек и оптимизаций.
  Однако это делает его чуть сложнее для начинающих.

#### 5. **Поддержка и экосистема**

- **Maven** обладает более развитой и старой экосистемой, имеет много готовых плагинов и шаблонов для использования.
- **Gradle** стремительно набирает популярность благодаря своей гибкости и использованию в крупных проектах, таких как
  Android.

### Заключение

- **Maven** хорошо подходит для проектов с простой конфигурацией и стабильными зависимостями. Он проверен временем и
  используется в большом количестве проектов.
- **Gradle** лучше подходит для крупных и сложных проектов, где важна скорость сборки и гибкость в настройках.

Если вы только начинаете, Maven может быть проще, но для более сложных проектов с расширенными требованиями стоит
обратить внимание на Gradle.
