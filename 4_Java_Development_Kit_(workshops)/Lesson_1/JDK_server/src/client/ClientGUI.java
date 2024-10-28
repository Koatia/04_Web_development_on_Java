package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import server.ServerWindow;

public class ClientGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField tfPassword;
    JButton btnLogin, btnSend;
    JPanel panelTop, panelBottom;
    private ServerWindow server;
    private boolean connected;
    private String name;

    public ClientGUI(ServerWindow server) {
        this.server = server;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(server.getX() - 400, server.getY());

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        // Панель Top
        panelTop = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Ivan Igorevich");
        tfPassword = new JPasswordField("123456");

        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(new JPanel());
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        // Панель Bottom
        panelBottom = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        panelBottom.add(tfMessage);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        // Поле log
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

    }

    public void answer(String text) {
        appendLog(text);
    }

    private void connectToServer() {
        if (server.connectUser(this)) {
            appendLog("Вы успешно подключились!\n");
            panelTop.setVisible(false);
            connected = true;
            name = tfLogin.getText();
            server.message(name + " подключился к беседе");
            String log = server.getLog();
            if (log != null) {
                appendLog(log);
            }
        } else {
            appendLog("Подключение не удалось");
        }
    }

    public void disconnectFromServer() {
        if (connected) {
            panelTop.setVisible(true);
            connected = false;
            server.disconnectUser(this);
            appendLog("Вы были отключены от сервера!");
        }
    }

    public void message() {
        if (connected) {
            String text = tfMessage.getText();
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
                tfMessage.setText("");
            }
        } else {
            appendLog("Нет подключения к серверу");
        }

    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }

    // Отключение клиента от сервера при нажатии кнопки закрытия окна (клиента)
    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectFromServer();
        }
        super.processWindowEvent(e);
    }
}