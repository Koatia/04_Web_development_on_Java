package server;

import client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;

public class ServerWindow extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    public static final String LOG_FILE = "src/server/log.txt";

    List<ClientGUI> clientGUIList;

    private JButton btnStart, btnStop;
    private JTextArea log;
    private boolean isServerWorking;

    public ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);

        clientGUIList = new ArrayList<>();
        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        // Текстовое поле для сообщений (scroll)
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

        // Добавляем панель с кнопками и обработчики кнопок
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    appendLog("Сервер уже был запущен");
                } else {
                    isServerWorking = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    isServerWorking = false;
                    while (!clientGUIList.isEmpty()) {
                        disconnectUser(clientGUIList.getLast());
                    }
                    appendLog("Сервер остановлен!");
                }
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);

        add(panel, BorderLayout.SOUTH);
    }

    public boolean connectUser(ClientGUI clientGUI) {
        if (!isServerWorking) {
            return false;
        }
        this.clientGUIList.add(clientGUI);
        return true;
    }

    public String getLog() {
        return readLog();
    }

    public void disconnectUser(ClientGUI clientGUI) {
        clientGUIList.remove(clientGUI);
        if (clientGUI != null) {
            clientGUI.disconnectFromServer();
        }
    }

    public void message(String text) {
        if (!isServerWorking) {
            return;
        }
        text += "";
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text) {
        for (ClientGUI clientGUI : clientGUIList) {
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_FILE);) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }
}