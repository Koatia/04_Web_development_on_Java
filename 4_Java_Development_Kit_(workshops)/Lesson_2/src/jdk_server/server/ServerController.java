package jdk_server.server;

import jdk_server.client.ClientController;
import jdk_server.repository.InterfaceRepository;

import java.util.ArrayList;
import java.util.List;

public class ServerController {

    private final InterfaceServerView serverView;
    private final InterfaceRepository repository;
    private final List<ClientController> clientList;
    private boolean isServerWorking;

    public ServerController(InterfaceServerView serverView, InterfaceRepository repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientList = new ArrayList<>();
        serverView.setServerController(this);
    }

    public void start() {
        if (isServerWorking) {
            showOnWindow("Сервер уже был запущен");
        } else {
            isServerWorking = true;
            showOnWindow("Сервер запущен!");
        }
    }

    public void stop() {
        if (!isServerWorking) {
            showOnWindow("Сервер уже был остановлен");
        } else {
            isServerWorking = false;
            while (!clientList.isEmpty()) {
                disconnectUser(clientList.getLast());
            }
            showOnWindow("Сервер остановлен!");
        }
    }

    public void disconnectUser(ClientController clientController) {
        clientList.remove(clientController);
        if (clientController != null) {
            clientController.disconnectedFromServer();
            showOnWindow(clientController.getName() + " отключился от беседы");
        }
    }

    public boolean connectUser(ClientController clientController) {
        if (!isServerWorking) {
            return false;
        }
        clientList.add(clientController);
        showOnWindow(clientController.getName() + " подключился к беседе");
        return true;
    }

    public void message(String text) {
        if (!isServerWorking) {
            return;
        }
        showOnWindow(text);
        answerAll(text);
        saveLog(text);
    }

    private void answerAll(String text) {
        for (ClientController clientController : clientList) {
            clientController.answerFromServer(text);
        }
    }

    private void showOnWindow(String text) {
        serverView.showMessage(text + "\n");
    }

    public String readLog() {
        return (String) repository.read();
    }

    private void saveLog(String text) {
        repository.save(text);
    }
}