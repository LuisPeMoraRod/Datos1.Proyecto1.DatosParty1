package com.Datos1.Proyecto1.snake;

import javax.swing.*;
import java.io.IOException;

public class SnakeWindow extends JFrame {

    public final int width = 1000, height = 600;

    private SnakeBoard snakeBoard;

    public SnakeWindow() throws IOException {

        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        snakeBoard = new SnakeBoard();
        add(snakeBoard);

    }


}
