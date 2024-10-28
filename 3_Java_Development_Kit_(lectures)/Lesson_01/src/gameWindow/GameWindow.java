package gameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int HEIGHT = 555;
    private static final int WIDHT = 507;

    private JButton btnStart, btnExit;
    private SettingsWindow settingsWindow;
    private Map map;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDHT, HEIGHT);
        setLocationRelativeTo(null);    // помещает окно в центр экрана

        setTitle("TicTacToe");
        setResizable(false);
        btnStart = new JButton("New Game");
        btnExit = new JButton("Exit");
        settingsWindow = new SettingsWindow(this);
        map = new Map();

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);

        add(panBottom, BorderLayout.SOUTH);
        add(map);

        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}