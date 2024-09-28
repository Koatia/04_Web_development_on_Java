package gameWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int HEIGHT = 430;
    private static final int WIDHT = 350;

    private JButton btnStart;
    private JSlider sliderSizeField, sliderSizeCombo;
    private JRadioButton btnChoice1, btnChoice2;
    private GameWindow gameWindow;
    private JPanel settings, typeGame, panelSizeField, panelSizeCombo;
    private int mode, size, len;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setLocationRelativeTo(gameWindow);
        setSize(WIDHT, HEIGHT);

        createPanel();
    }

    private void createPanel() {

        createTypeGamePanel();  // Блок выбор типа игры
        choiceSizeCombo();      // Блок выбор длинны выигрышной комбинации
        choiceSizeField();      // Блок выбор размера поля

        // Заполнение панели настроек
        settings = new JPanel(new GridLayout(3, 1));
        settings.add(typeGame);
        settings.add(panelSizeField);
        settings.add(panelSizeCombo);
        add(settings);

        addBtnStart(); // Добавляем кнопку старта и настраиваем поведение при нажатии
    }

    private void addBtnStart() {
        btnStart = new JButton("Start new game");
        add(btnStart, BorderLayout.SOUTH);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
    }

    private void choiceSizeField() {
        panelSizeField = new JPanel(new GridLayout(3, 1));
        panelSizeField.add(new JLabel("Выберете размер поля"));
        JLabel labelChosenSizeField = new JLabel("Выбраный размер поля: 3");
        panelSizeField.add(labelChosenSizeField);
        sliderSizeField = new JSlider(3, 10);
        sliderSizeField.setValue(3);
        panelSizeField.add(sliderSizeField);

        sliderSizeField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sliderSizeField.getValue();
                labelChosenSizeField.setText("Выбраный размер поля: " + size);
                sliderSizeCombo.setMaximum(size);

            }
        });
    }

    private void choiceSizeCombo() {
        panelSizeCombo = new JPanel(new GridLayout(3, 1));
        panelSizeCombo.add(new JLabel("Выберете размер выигрышной комбинации"));
        JLabel labelChosenSizeCombo = new JLabel("Выбраный размер выигрышной комбинации: 3");
        panelSizeCombo.add(labelChosenSizeCombo);
        sliderSizeCombo = new JSlider(3, 10);
        sliderSizeCombo.setValue(3);
        panelSizeCombo.add(sliderSizeCombo);

        sliderSizeCombo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sliderSizeCombo.getValue();
                labelChosenSizeCombo.setText("Выбраный размер выигрышной комбинации: " + size);
            }
        });
    }

    private void createTypeGamePanel() {
        typeGame = new JPanel(new GridLayout(3, 1));
        typeGame.add(new JLabel("Выберете режим игры:"));
        ButtonGroup groupChoiceTypeGame = new ButtonGroup();

        btnChoice1 = new JRadioButton("Human vs AI");
        btnChoice1.setSelected(true);
        btnChoice2 = new JRadioButton("Human vs Human");

        groupChoiceTypeGame.add(btnChoice1);
        groupChoiceTypeGame.add(btnChoice2);
        typeGame.add(btnChoice1);
        typeGame.add(btnChoice2);
    }

    private void startNewGame() {
        if (btnChoice1.isSelected()) {
            mode = 0;
        } else if (btnChoice2.isSelected()) {
            mode = 1;
        }
        size = sliderSizeField.getValue();
        len = sliderSizeCombo.getValue();

        setVisible(false);
        gameWindow.startNewGame(mode, size, size, len);
    }
}