package main.ru.example.ui;

import main.ru.example.domain.Controller;

import java.util.ArrayList;

public interface ClientView {
    void setController(Controller controller);

    void setLog(String text);

    String getPath();

    String getRepo();

    ArrayList<String> getMyListRepo();
}