package main.ru.example;

import main.ru.example.domain.Controller;
import main.ru.example.ui.ClientGUI;

public class Main {
    public static void main(String[] args) {
        new Controller(new ClientGUI());
    }
}