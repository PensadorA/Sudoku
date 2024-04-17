package org.example.components_gui;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private static final int SIZE = 3;
    public Board(){
        setLayout(new GridLayout(SIZE,SIZE));
        setBackground(Color.gray);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
    }
}
