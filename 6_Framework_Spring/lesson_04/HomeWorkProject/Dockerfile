# Используем базовый образ с поддержкой Java
FROM openjdk:23-slim

# Копируем JAR-файл приложения в контейнер
COPY target/*.jar /app/users.jar

# Указываем порт, который будет слушать контейнер
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app/users.jar"]