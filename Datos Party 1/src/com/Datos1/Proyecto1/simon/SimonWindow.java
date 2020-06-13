package com.Datos1.Proyecto1.simon;

import javax.swing.*;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;

import java.io.IOException;

/**
 * SimonWindow extends from JFrame to create the frame that contains the components that form the simon game
 *
 * @author Monica Waterhouse
 * @version 1.0
 * @since 05/01/2020
 *
 */

public class SimonWindow extends JFrame {


	private static final long serialVersionUID = 1L;

	protected SimonBoard simonBoard;

    public static final int width =1000,height=600;
    
    protected CircularDoublyLinkedList players;

    protected static SimonThread simonThread;

    /**
     * The constructor receives a list of players that will play the game
     *
     * @param players
     * @throws IOException
     */

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
