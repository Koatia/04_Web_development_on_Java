import client.ClientGUI;
import server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}