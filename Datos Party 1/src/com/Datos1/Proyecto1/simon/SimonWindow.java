package com.Datos1.Proyecto1.simon;

import javax.swing.*;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;

import java.io.IOException;

public class SimonWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected SimonBoard simonBoard;

    public static final int width =1000,height=600;
    
    protected CircularDoublyLinkedList players;

    protected static SimonThread simonThread;

    public SimonWindow(CircularDoublyLinkedList players) throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);

        simonBoard = new SimonBoard(players);
        add(simonBoard);

        simonThread = new SimonThread(simonBoard);
        simonThread.start();


    }
}
