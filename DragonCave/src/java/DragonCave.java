import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
public class DragonCave {
    String position;
    public int score = 0;


    //set layout
    JFrame window;
    JPanel titlePanel, startButtonPanel, introPanel, decisionPanel, namePanel, cave1Panel, cave2Panel;
    Container container;
    JLabel titleLabel;
    JButton startButton, walkButton, tryAgainButton, quitButton, nameButton;
    JTextArea introTextArea, cave1TextArea, cave2TextArea, quitTextArea;
    JTextField decisionTextField, nameTextField;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);

    public DragonCave() {
        position = "Start";
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        container = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.black);

        titleLabel = new JLabel();
        titleLabel.setText("Dragon Cave");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                getDecision();
            }
        });
        //Get Name
        namePanel = new JPanel();
        namePanel.setBackground(Color.black);
        namePanel.setBounds(500, 400, 300, 100);

        nameTextField = new JTextField();
        nameTextField.setText("Enter Name");
        nameTextField.setBackground(Color.black);
        nameTextField.setForeground(Color.white);
        nameTextField.setBounds(500, 400, 300, 100);

        nameButton = new JButton("ENTER NAME");
        nameButton.setBackground(Color.white);
        nameButton.setForeground(Color.black);
        nameButton.setFont(normalFont);
        nameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                titleLabel.setText("Hello,\t" + name);
            }
        });

        namePanel.add(nameTextField);
        namePanel.add(nameButton);

        startButtonPanel.add(startButton);
        titlePanel.add(titleLabel);

        container.add(titlePanel);
        container.add(startButtonPanel);
        container.add(namePanel);

        window.setVisible(true);
    }

    public void getDecision() {
        position = "Decesion";
        Intro intro = new Intro();
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        namePanel.setVisible(false);

        introPanel = new JPanel();
        introPanel.setBounds(100, 100, 600, 255);
        introPanel.setBackground(Color.black);

        introTextArea = new JTextArea(intro.intro);
        introTextArea.setBackground(Color.black);
        introTextArea.setForeground(Color.white);
        introTextArea.setFont(normalFont);
        introPanel.add(introTextArea);

        decisionPanel = new JPanel();
        decisionPanel.setBackground(Color.black);
        decisionPanel.setBounds(500, 440, 100, 100);

        walkButton = new JButton("Walk");
        walkButton.setBackground(Color.black);
        walkButton.setFont(normalFont);
        walkButton.setBounds(500, 440, 100, 55);
        walkButton.setActionCommand("Walk");
        walkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String getDecision = decisionTextField.getText();
                if (getDecision.replaceAll("\\s", "").equals("1")) {
                    introPanel.setVisible(false);
                    walkButton.setVisible(false);
                    decisionTextField.setVisible(false);
                    getCave1();
                } else if (getDecision.replaceAll("\\s", "").equals("2")) {
                    introPanel.setVisible(false);
                    walkButton.setVisible(false);
                    decisionTextField.setVisible(false);
                    getCave2();
                }
            }
        });

        decisionTextField = new JTextField("Enter Choice");
        decisionTextField.setBounds(300, 400, 200, 100);
        decisionTextField.setBackground(Color.black);
        decisionTextField.setForeground(Color.white);
        decisionTextField.setFont(normalFont);

        decisionPanel.add(walkButton);

        window.add(introPanel);
        window.add(walkButton);
        window.add(decisionTextField);
        introPanel.setVisible(true);
        decisionPanel.setVisible(true);
        decisionTextField.setVisible(true);
    }

    public void getCave1() {
        position = "1";
        decisionTextField.setVisible(false);
        walkButton.setVisible(false);
        decisionPanel.remove(walkButton);
        WinLose winLose = new WinLose();
        Dragon dragon = new Dragon();
        String getDecision = decisionTextField.getText();
        int decision = Integer.parseInt(getDecision);

        cave1Panel = new JPanel();
        cave1Panel.setBounds(100, 100, 600, 255);
        cave1Panel.setBackground(Color.black);

        cave1TextArea = new JTextArea();
        cave1TextArea.setBackground(Color.black);
        cave1TextArea.setForeground(Color.white);
        cave1TextArea.setFont(normalFont);
        cave1Panel.add(cave1TextArea);

        if (dragon.dragon != decision) {
            cave1TextArea.setText(winLose.winLine);
            score += 1;
        } else {
            cave1TextArea.setText(winLose.loseLine);
        }

        tryAgainButton = new JButton("PLAY AGAIN");
        tryAgainButton.setBackground(Color.black);
        tryAgainButton.setFont(normalFont);
        tryAgainButton.setBounds(500, 440, 150, 55);
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                getDecision();
                tryAgainButton.setVisible(false);
                quitButton.setVisible(false);
                cave1Panel.setVisible(false);
            }
        });

        quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.black);
        quitButton.setFont(normalFont);
        quitButton.setBounds(300, 440, 100, 55);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cave1TextArea.setText("Your score was\t" + score);
                cave1TextArea.setFont(normalFont);
                tryAgainButton.setVisible(false);
                quitButton.setVisible(false);
            }
        });


        decisionPanel.add(tryAgainButton);
        decisionPanel.add(quitButton);

        window.add(tryAgainButton);
        window.add(quitButton);
        window.add(cave1Panel);

        tryAgainButton.setVisible(true);
        quitButton.setVisible(true);
        cave1Panel.setVisible(true);
    }

    public void getCave2() {
        position = "2";
        decisionTextField.setVisible(false);
        walkButton.setVisible(false);
        decisionPanel.remove(walkButton);
        WinLose winLose = new WinLose();
        Dragon dragon = new Dragon();
        String getDecision = decisionTextField.getText();
        int decision = Integer.parseInt(getDecision);

        cave2Panel = new JPanel();
        cave2Panel.setBounds(100, 100, 600, 255);
        cave2Panel.setBackground(Color.black);

        cave2TextArea = new JTextArea();
        cave2TextArea.setBackground(Color.black);
        cave2TextArea.setForeground(Color.white);
        cave2TextArea.setFont(normalFont);
        cave2Panel.add(cave2TextArea);

        if (dragon.dragon != decision) {
            cave2TextArea.setText(winLose.winLine);
            score += 1;
        } else {
            cave2TextArea.setText(winLose.loseLine);
        }

        tryAgainButton = new JButton("PLAY AGAIN");
        tryAgainButton.setBackground(Color.black);
        tryAgainButton.setFont(normalFont);
        tryAgainButton.setBounds(500, 440, 150, 55);
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                getDecision();
                tryAgainButton.setVisible(false);
                quitButton.setVisible(false);
                cave2Panel.setVisible(false);
            }
        });

        quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.black);
        quitButton.setFont(normalFont);
        quitButton.setBounds(300, 440, 100, 55);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cave2TextArea.setText("Your score was\t" + score);
                cave2TextArea.setFont(normalFont);
                tryAgainButton.setVisible(false);
                quitButton.setVisible(false);
            }
        });

        decisionPanel.add(tryAgainButton);
        decisionPanel.add(quitButton);

        window.add(tryAgainButton);
        window.add(quitButton);
        window.add(cave2Panel);

        tryAgainButton.setVisible(true);
        quitButton.setVisible(true);
        cave2Panel.setVisible(true);
    }
}