package com.Datos1.Proyecto1.snake;

import javax.swing.*;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;

import java.io.IOException;

public class SnakeWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int width = 1000;
    public static final int height = 600;

    private SnakeBoard snakeBoard;

    public SnakeWindow(CircularDoublyLinkedList players) throws IOException {

        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        snakeBoard = new SnakeBoard(players);
        add(snakeBoard);

        addKeyListener(new SnakeEvent());

        SnakeThread snakeThread = new SnakeThread(snakeBoard);
        snakeThread.start();

    }


}
