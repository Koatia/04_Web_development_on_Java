package jdk_server.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI extends JFrame implements InterfaceServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private JButton btnStart, btnStop;
    private JTextArea log;

    private ServerController serverController;

    public SwingUI() {
        setting();
        createPanel();

        setVisible(true);
    }

    @Override
    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    private void setting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        //        serverController = new ServerController(this, new FileStorage());
    }

    private void createPanel() {
        add(createLog());
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.start();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.stop();
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    @Override
    public void showMessage(String msg) {
        log.append(msg);
    }

    public ServerController getConnection() {
        return serverController;
    }
}