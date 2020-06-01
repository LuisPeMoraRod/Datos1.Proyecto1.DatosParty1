package com.Datos1.Proyecto1.snake;

import javax.swing.*;
import java.io.IOException;

public class SnakeWindow extends JFrame {

    public static final int width = 1000;
    public static final int height = 600;

    private SnakeBoard snakeBoard;

    public SnakeWindow() throws IOException {

        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        snakeBoard = new SnakeBoard();
        add(snakeBoard);

        addKeyListener(new SnakeEvent());

        SnakeThread snakeThread = new SnakeThread(snakeBoard);
        snakeThread.start();

    }


}
