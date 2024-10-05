package main.ru.example.ui;

import main.ru.example.domain.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    private Controller controller;
    private String REPO_PATH = "/mnt/Data/_Repositories/";
    private ArrayList<String> myListRepo = new ArrayList<>(
            Arrays.asList("00_Codes", "01_Start_GeekBrains", "02_Final_Test", "02_Programming_GeekBrains",
                    "03_Analytics_GeekBrains", "03_Final_Test", "04_Web_development_on_Java"));
    private ArrayList<JRadioButton> myListBtnRepo = new ArrayList<>();
    private ArrayList<String> myListCommand = new ArrayList<>(
            Arrays.asList("gitStatus", "gitPull", "filesRename", "itWasChanged", "gitPush", "clearCommit"));
    private ArrayList<JButton> myListBtnCom = new ArrayList<>();
    private JTextArea log, pathField, repoName;

    public ClientGUI() {
        setting();
        createPanel();

        setVisible(true);
    }

    /**
     * Сеттер
     *
     * @param controller объект контроллера, описывающий логику поведения
     */
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private void setting() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Hello my repository");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createPanel() {
        add(createTop(), BorderLayout.NORTH);
        add(createLog());
        add(createBottom(), BorderLayout.SOUTH);
        add(createLeft(), BorderLayout.WEST);
        System.out.println(myListBtnRepo.get(1).getText());
    }

    private Component createTop() {
        JPanel panel = new JPanel(new GridLayout(1, myListCommand.size(), 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < myListCommand.size(); i++) {
            myListBtnCom.add(new JButton(myListCommand.get(i)));
            myListBtnCom.get(i).setFont(new Font("Ubuntu mono", Font.BOLD, 14));
            String cmd = myListCommand.get(i);

            myListBtnCom.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Проверка, является ли папка Git-репозиторием
                    String repoPath = pathField.getText() + repoName.getText();
                    File repoDir = new File(repoPath);
                    if (!new File(repoDir, ".git").exists()) {
                        setLog("Не является Git-репозиторием: " + repoPath);
                    } else {
                        try {
                            callByName(controller, cmd);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
            panel.add(myListBtnCom.get(i));
        }
        return panel;
    }

    private Component createLog() {

        log = new JTextArea();
        log.setEditable(false);
        log.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        log.setFont(new Font("Ubuntu mono", Font.PLAIN, 12));
        return new JScrollPane(log);
    }

    private Component createBottom() {
        JPanel panel = new JPanel(new GridLayout(1, 2));

        pathField = new JTextArea();
        pathField.setText(REPO_PATH);
        pathField.setFont(new Font("Ubuntu mono", Font.PLAIN, 16));
        pathField.setBorder(
                BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        panel.add(pathField);

        repoName = new JTextArea();
        repoName.setText(myListRepo.getFirst());
        repoName.setFont(new Font("Ubuntu mono", Font.PLAIN, 16));
        repoName.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        panel.add(repoName);

        return panel;
    }

    private Component createLeft() {
        JPanel panel = new JPanel(new GridLayout(myListRepo.size(), 1, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);
        ButtonGroup groupChoice = new ButtonGroup();

        for (int i = 0; i < myListRepo.size(); i++) {
            String repo = myListRepo.get(i);
            myListBtnRepo.add(new JRadioButton(repo));
            myListBtnRepo.get(i).setFont(new Font("Arial", Font.PLAIN, 12));

            groupChoice.add(myListBtnRepo.get(i));
            panel.add(myListBtnRepo.get(i));

            myListBtnRepo.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repoName.setText(repo);
                }
            });
        }
        myListBtnRepo.getFirst().setSelected(true);
        return panel;

    }

    public void setLog(String text) {
        log.append(text + "\n");
    }

    public void callByName(Object obj, String funcName) throws Exception {
        // Ignoring any possible result
        obj.getClass().getDeclaredMethod(funcName).invoke(obj);
    }

    @Override
    public String getPath() {
        return pathField.getText();
    }

    @Override
    public String getRepo() {
        return repoName.getText();
    }

    @Override
    public ArrayList<String> getMyListRepo() {
        return myListRepo;
    }
}