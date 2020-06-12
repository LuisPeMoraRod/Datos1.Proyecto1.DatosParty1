package com.Datos1.Proyecto1.pong;

import javax.swing.*;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;

import java.io.IOException;

public class PongWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int width =1000,height=600;

    private PongBoard pongBoard;
    private PongThread pongThread;


    public PongWindow(CircularDoublyLinkedList players) throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        
        setUndecorated(true);
        setResizable(false);

        pongBoard = new PongBoard(players);
        add(pongBoard);
        addKeyListener(new PalletEvent());

        pongThread = new PongThread(pongBoard);
        pongThread.start();
    }
}
