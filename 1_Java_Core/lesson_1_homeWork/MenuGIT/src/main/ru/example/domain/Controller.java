package main.ru.example.domain;

import main.ru.example.ui.ClientView;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    private StringBuilder text = new StringBuilder();
    private ClientView clientView;
    private ArrayList<String> myListRepo;
    private String pathRepo, repo;

    private String GITHUB_URL = "git@github.com:Koatia/";
    private String GITVERSE_URL = "ssh://git@gitverse.ru:2222/Kostia/";

    public Controller(ClientView clientView) {
        this.clientView = clientView;
        clientView.setController(this);
    }

    private String getCommitMessage() {
        return new SimpleDateFormat("'Сommitted on' E dd.MM.yyyy hh:mm:ss a zzz").format(new Date());
    }

    public void gitStatus() throws IOException, InterruptedException {
        pathRepo = clientView.getPath() + clientView.getRepo();
        text.setLength(0);

        text.append("GIT STATUS " + pathRepo).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "status"}, pathRepo)).append("\n");

        text.append("GIT REMOTE -V " + pathRepo).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "remote", "-v"}, pathRepo)).append("\n");

        text.append("GIT LOG ").append(pathRepo).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "log", "--oneline", "--all", "--graph"}, pathRepo));
        clientView.setLog(text.toString());
    }

    public void gitPush() throws IOException, InterruptedException {
        pathRepo = clientView.getPath() + clientView.getRepo();
        repo = clientView.getRepo();
        text.setLength(0);

        clientView.setLog("\nRename Files And Directories " + pathRepo);
        renameFilesAndDirectories(pathRepo, "_");

        text.append("\nProcess renamed is finished\n");
        text.append("GIT PUSH ").append(pathRepo).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "remote", "add", "origin", GITHUB_URL + repo + ".git"},
                pathRepo)).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "remote", "add", "mirror", GITVERSE_URL + repo + ".git"},
                pathRepo)).append("\n");

        text.append(linuxCommandRunner(new String[]{"git", "add", "."}, pathRepo)).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "commit", "-m", getCommitMessage()}, pathRepo)).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "push", "origin", "master"}, pathRepo)).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "push", "mirror", "master"}, pathRepo)).append("\n");

        text.append("\nGIT LOG ").append(pathRepo).append("\n");
        text.append(linuxCommandRunner(new String[]{"git", "log", "--oneline", "--all", "--graph"}, pathRepo));
        clientView.setLog(text.toString());
    }

    public void filesRename() {
        pathRepo = clientView.getPath() + clientView.getRepo();

        clientView.setLog("\nRename files and directories:  " + pathRepo);
        renameFilesAndDirectories(pathRepo, "_");
        clientView.setLog("\nProcess finished\n");
    }

    // Метод для проверки репозиториев на наличие изменений через Git-процесс
    public void itWasChanged() {
        myListRepo = clientView.getMyListRepo();
        pathRepo = clientView.getPath();
        text.setLength(0);

        clientView.setLog(statusChecker());
    }

    private String statusChecker() {
        for (String repoPath : myListRepo) {
            File repoDir = new File(pathRepo + repoPath);

            // Проверка, является ли папка Git-репозиторием
            if (!new File(repoDir, ".git").exists()) {
                text.append("Не является Git-репозиторием: ").append(repoPath).append("\n");
                continue;
            }

            try {
                // Запуск git status и захват вывода
                String statusOutput = linuxCommandRunner(new String[]{"git", "status"}, pathRepo + repoPath);

                // Анализ вывода команды git status
                if (statusOutput.contains("нечего коммитить, нет изменений в рабочем каталоге") ||
                        statusOutput.contains("nothing to commit, working tree clean")) {
                    text.append("Репозиторий без изменений: ").append(repoPath).append("\n");
                } else {
                    text.append("Репозиторий содержит изменения: ").append(repoPath).append("\n");
                    text.append(statusOutput).append("\n");
                }

            } catch (IOException | InterruptedException e) {
                text.append("Ошибка при доступе к репозиторию: ").append(repoPath).append(": ").append(e.getMessage())
                        .append("\n");
            }
        }
        return text.toString();
    }

    private String linuxCommandRunner(String[] command, String pathRepo) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(new File(pathRepo)); // Установка директории для выполнения команды
        builder.redirectErrorStream(true); // Объединяем стандартный поток вывода и ошибок
        Process process = builder.start();

        // Чтение вывода процесса
        Scanner s = new Scanner(process.getInputStream());
        StringBuilder output = new StringBuilder();
        while (s.hasNextLine()) {
            output.append(s.nextLine());
            output.append("\n");
        }
        s.close();

        int exitCod = process.waitFor(); // Ждём завершения процесса

        // Возвращаем весь захваченный вывод
        return String.format("Process exited with result %d.\n%s%n", exitCod, output);
    }

    private void renameFilesAndDirectories(String rootDir, String replaceWith) {
        File rootDirectory = new File(rootDir);
        File[] files = rootDirectory.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory()) {
                renameFilesAndDirectories(file.getAbsolutePath(), replaceWith);
                renameFileOrDirectory(file, replaceWith);
            } else {
                renameFileOrDirectory(file, replaceWith);
            }
        }
    }

    private void renameFileOrDirectory(File file, String replaceWith) {
        String newName = file.getName().replace(" ", replaceWith);
        if (!newName.equals(file.getName())) {
            File newFile = new File(file.getParent(), newName);
            if (file.renameTo(newFile)) {
                clientView.setLog("Переименован: " + file.getAbsolutePath() + " ⟹ " + newFile.getName());
            } else {
                clientView.setLog("Не удалось переименовать: " + file.getAbsolutePath());
            }
        }
    }
}