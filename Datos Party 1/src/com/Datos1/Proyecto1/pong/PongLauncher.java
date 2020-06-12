package com.Datos1.Proyecto1.pong;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class PongLauncher {

    protected static PongWindow pongWindow;

    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	CircularDoublyLinkedList players = new CircularDoublyLinkedList();
    	players.insertHead(new Player("Luis", 1));
    	players.insertEnd(new Player("Moni", 2));
    	players.insertEnd(new Player("Gabo", 3));
    	players.insertEnd(new Player("Mariana", 4));
    	
        pongWindow = new PongWindow(players);
        pongWindow.setVisible(true);

    }

}
