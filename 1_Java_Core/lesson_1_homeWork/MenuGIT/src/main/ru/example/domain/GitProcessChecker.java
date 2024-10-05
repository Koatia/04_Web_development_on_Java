package main.ru.example.domain;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GitProcessChecker {

    // Метод для запуска процесса и захвата его вывода
    public static String runGitCommand(File repoDir, String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("git", command);
        builder.directory(repoDir); // Установка директории для выполнения команды
        builder.redirectErrorStream(true); // Объединяем стандартный поток вывода и ошибок

        Process process = builder.start();
        StringBuilder output = new StringBuilder();

        // Чтение вывода процесса
        try (Scanner s = new Scanner(process.getInputStream())) {
            while (s.hasNextLine()) {
                output.append(s.nextLine()).append("\n");
            }
        }

        process.waitFor(); // Ждём завершения процесса
        return output.toString(); // Возвращаем весь захваченный вывод
    }

    // Метод для проверки репозиториев на наличие изменений через Git-процесс
    public static void checkRepositories(List<String> repoPaths) {
        for (String repoPath : repoPaths) {
            File repoDir = new File(repoPath);

            // Проверка, является ли папка Git-репозиторием
            if (!new File(repoDir, ".git").exists()) {
                System.out.println("Не является Git-репозиторием: " + repoPath);
                continue;
            }

            try {
                System.out.println("Проверка репозитория: " + repoPath);

                // Запуск git status и захват вывода
                String statusOutput = runGitCommand(repoDir, "status");

                // Анализ вывода команды git status
                if (statusOutput.contains("нечего коммитить") ||
                        statusOutput.contains("nothing to commit, working tree clean")) {
                    System.out.println("Репозиторий чист.");
                } else {
                    System.out.println("Репозиторий содержит изменения:");
                    System.out.println(statusOutput);
                }

            } catch (IOException | InterruptedException e) {
                System.err.println("Ошибка при доступе к репозиторию " + repoPath + ": " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Пример списка репозиториев (замени на свои пути)
        List<String> repoPaths = List.of("/path/to/repo1", "/path/to/repo2", "/path/to/repo3");

        // Проверка репозиториев
        checkRepositories(repoPaths);
    }
}

/*

1. **Метод `runGitCommand()`**:  Этот метод запускает процесс выполнения команды Git (например, `git status`)
 для указанного репозитория и перехватывает его вывод с помощью `Scanner`, записывая его в переменную `StringBuilder`.
 После завершения процесса, результат возвращается как строка.
2. **Перехват вывода**: Поток вывода процесса (`process.getInputStream()`) считывается через `Scanner`.
 Каждая строка добавляется в `StringBuilder`, чтобы позже можно было её анализировать или вывести.
3. **Запуск команды `git status`**: В методе `checkRepositories()` для каждого репозитория запускается
 команда `git status`, и результат выводится или анализируется для определения состояния репозитория.

Пример использования:
1. В методе `main()` ты указываешь список путей к репозиториям.
2. Программа запускает команду `git status` для каждого репозитория.
3. Перехватывается вывод команды и выводится результат. Если в репозитории нет изменений,
 выводится сообщение о "чистоте" репозитория, иначе выводятся неотслеживаемые или изменённые файлы.

 */