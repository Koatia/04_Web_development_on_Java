package jdk_server;

import jdk_server.client.ClientController;
import jdk_server.client.ClientGUI;
import jdk_server.repository.FileStorage;
import jdk_server.server.ServerController;
import jdk_server.server.SwingUI;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new SwingUI(), new FileStorage());

        new ClientController(new ClientGUI(), serverController);
        new ClientController(new ClientGUI(), serverController);
    }
}