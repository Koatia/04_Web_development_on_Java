# Используем официальный образ с Java
FROM openjdk:17-jdk-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем проект в контейнер
COPY . /app

# Создаём директорию для документации с правами записи
RUN mkdir -p /app/docs && chmod -R 777 /app/docs

# Команда для генерации Javadoc
CMD ["javadoc", "-d", "/app/docs", "-sourcepath", "src", "-subpackages", "main.ru.example"]
