package jdk_server.client;

/**
 * Интерфейс описывающий абстракцию GUI
 */
public interface InterfaceClientView {

    void disconnectedFromServer();

    void showMessage(String text);

    void setClientController(ClientController clientController);
}