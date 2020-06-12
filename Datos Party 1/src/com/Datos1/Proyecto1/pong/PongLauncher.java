package com.Datos1.Proyecto1.pong;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class PongLauncher implements Observer {

    protected static PongWindow pongWindow;
    protected CircularDoublyLinkedList players;

    public PongLauncher(CircularDoublyLinkedList players){
        this.players = players;
    }

    public void launch() throws IOException{
    	
        pongWindow = new PongWindow(players);
        pongWindow.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
