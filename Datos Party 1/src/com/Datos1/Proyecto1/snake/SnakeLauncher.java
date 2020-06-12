package com.Datos1.Proyecto1.snake;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class SnakeLauncher {

    protected static SnakeWindow snakeWindow;

    public static void main(String[] args) throws IOException {
    	
    	CircularDoublyLinkedList players = new CircularDoublyLinkedList();
    	
    	players.insertHead(new Player("Luis",1));
    	players.insertEnd(new Player("Moni",2));
    	players.insertEnd(new Player("Sofia",3));
    	
        snakeWindow = new SnakeWindow(players);
        snakeWindow.setVisible(true);
    }
}
