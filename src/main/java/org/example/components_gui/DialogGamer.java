package org.example.components_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogGamer extends JDialog {
    private int mode;

    public DialogGamer(JFrame parent){
        super(parent, "Novo Jogo", true);
        setSize(300,300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JLabel label = new JLabel("Selecione a dificuldade:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1));

        JButton facilButton = new JButton("Fácil");
        facilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mode = 2;
                dispose();
            }
        });
        buttonsPanel.add(facilButton);

        JButton medioButton = new JButton("Médio");
        medioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mode = 30;
                dispose();
            }
        });
        buttonsPanel.add(medioButton);

        JButton dificilButton = new JButton("Difícil");
        dificilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mode = 40;
                dispose();
            }
        });
        buttonsPanel.add(dificilButton);

        add(buttonsPanel, BorderLayout.CENTER);
    }

    public int getDifficulty() {
        return mode;
    }

}
