package org.example;

import org.example.components_gui.Board;
import org.example.components_gui.Cell;
import org.example.components_gui.DialogGamer;
import org.example.logic_gamer.GFG;
import org.example.logic_gamer.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SudokuGui extends JFrame implements KeyListener {
    private static final int SIZE = 9;
    private int difficulty;
    private final Cell[][] cells = new Cell[9][9];
    private  int[][] gamerBoard;
    private int x;
    private int y;
    public SudokuGui(){
        setTitle("Sudoku");
        setLayout(new GridLayout(3,3));
        drawGamer();
        addKeyListener(this);
        setSize(800,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void startGamer() {
        this.x = 4;
        this.y = 4;
        Sudoku sudoku = new Sudoku(9,difficulty);
        sudoku.fillValues();
        gamerBoard = new int[9][9];
        int[][] temp = sudoku.printSudoku();
        for (int i = 0; i < gamerBoard.length; i ++) {
            System.arraycopy(temp[i], 0, gamerBoard[i], 0, gamerBoard[0].length);
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int value = gamerBoard[i][j];
                String cellValue = (value != 0) ? String.valueOf(value) : "";
                boolean isVisible = (value == 0);
                cells[i][j].setBaseGamer(cellValue,isVisible);
            }
            cells[4][4].setBackground(Color.cyan);
        }
    }

    private void drawGamer(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Board board = new Board();
                for (int k = 0; k < SIZE ; k++) {
                    int rowIndex = k / 3;
                    int colIndex = k % 3;
                    cells[(i * 3) + rowIndex][(j * 3) + colIndex] = new Cell();
                    board.add(cells[(i * 3) + rowIndex][(j * 3) + colIndex]);
                }
                add(board);
            }
        }
        DialogGamer dialogGamer = new DialogGamer(this);
        dialogGamer.setVisible(true);
        difficulty = dialogGamer.getDifficulty();
        startGamer();

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        cells[y][x].setBackground(Color.gray);
        if (keyCode == KeyEvent.VK_LEFT) {
            x = (x - 1 + SIZE) % SIZE;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            x = (x + 1) % SIZE;
        } else if (keyCode == KeyEvent.VK_UP) {
            y = (y - 1 + SIZE) % SIZE;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            y = (y + 1) % SIZE;
        }
        switch (keyCode) {
            case KeyEvent.VK_NUMPAD1:
            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_NUMPAD5:
            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_NUMPAD7:
            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_NUMPAD9:
                cells[y][x].setNumber(String.valueOf(e.getKeyChar()));
                int newNumber = Integer.parseInt(String.valueOf(e.getKeyChar()));
                gamerBoard[y][x] = newNumber;
                break;
        }
        cells[y][x].setBackground(Color.cyan);

        if(GFG.isValidSudoku(gamerBoard)){
            DialogGamer dialogGamer = new DialogGamer(this);
            dialogGamer.setVisible(true);
            difficulty = dialogGamer.getDifficulty();
            cells[y][x].setBackground(Color.gray);
            this.x = 4;
            this.y = 4;
            startGamer();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
