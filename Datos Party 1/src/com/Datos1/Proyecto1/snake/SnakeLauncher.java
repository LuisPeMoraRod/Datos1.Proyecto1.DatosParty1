package com.Datos1.Proyecto1.snake;

import java.io.IOException;

public class SnakeLauncher {

    protected static SnakeWindow snakeWindow;

    public static void main(String[] args) throws IOException {

        snakeWindow = new SnakeWindow();
        snakeWindow.setVisible(true);
    }
}
