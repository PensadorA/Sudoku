package org.example.components_gui;
import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {
    private final JLabel jLabel;
    private boolean isVisible = true;

    public Cell(){
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        jLabel = new JLabel();
        jLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        add(jLabel);
    }

    public void setNumber(String text){
        if (isVisible){
            jLabel.setFont(new Font("Arial", Font.BOLD, 30));
            jLabel.setText(text);
        }
    }
    public void setBaseGamer(String text, boolean isVisible){
        this.isVisible = isVisible;
        jLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        jLabel.setText(text);

    }
}

