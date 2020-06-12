package com.Datos1.Proyecto1.snake;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class SnakeLauncher implements Observer {

    protected static SnakeWindow snakeWindow;

    protected CircularDoublyLinkedList players;

    public SnakeLauncher(CircularDoublyLinkedList players){
        this.players = players;
    }

    public void launch() throws IOException {
        snakeWindow = new SnakeWindow(players);
        snakeWindow.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
