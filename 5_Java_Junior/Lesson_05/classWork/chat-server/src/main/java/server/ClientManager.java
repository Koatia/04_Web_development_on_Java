package server;

import java.io.*;
import java.net.Socket;

public class ClientManager implements Runnable {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    //public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            ClientManagerSingleton.getInstance().add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Завершение работы всех потоков, закрытие соединения с клиентским сокетом, удаление клиентского сокета из
     * коллекции
     *
     * @param socket         клиентский сокет
     * @param bufferedReader буфер для чтения данных
     * @param bufferedWriter буфер для отправки данных
     */
    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Удаление клиента из коллекции
        removeClient();
        try {
            // Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление клиента из коллекции
     */
    private void removeClient() {
        ClientManagerSingleton.getInstance().remove(this);
        System.out.println(name + " покинул чат.");
    }

    @Override
    public void run() {
        String massageFromClient;

        // Цикл чтения данных от клиента
        while (socket.isConnected()) {
            try {
                // Чтение данных
                massageFromClient = bufferedReader.readLine();
                // Если сообщение начинается с @, то оно персональное
                String[] messages = massageFromClient.split(" ");
                if (messages[1].charAt(0) == '@') {
                    privateMessage(massageFromClient);
                } else {
                    broadcastMessage(massageFromClient);
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void privateMessage(String message) {
        String[] messages = message.split(" ");
        String person = messages[1].substring(1);
        message = message.replaceFirst(person, "");
        message = message.replaceFirst("\\@ ", "");
        message = "@" + message;
        for (ClientManager client : ClientManagerSingleton.getInstance()) {
            try {
                // Если клиент равен по наименованию person, указанному в сообщении,
                // отправим сообщение
                if (client.name.equals(person)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    /**
     * Отправка сообщения всем слушателям
     *
     * @param massage сообщение
     */
    private void broadcastMessage(String massage) {
        for (ClientManager client : ClientManagerSingleton.getInstance()) {
            try {
                // Если клиент не равен по наименованию клиенту-отправителю,
                // отправим сообщение
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(massage);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }

            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }
}
