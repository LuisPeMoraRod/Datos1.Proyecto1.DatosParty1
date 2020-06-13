package com.Datos1.Proyecto1.simon;

import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.Datos1.Proyecto1.GameBoard.*;

public class SimonLauncher implements Observer {

    protected static SimonWindow simonWindow;
    static boolean startPlaying = false;
    protected static Cover simonCover;
    protected String pathLogo;
    protected String pathEnterPress;
    protected String pathSpacePress;
    protected String pathInstructions;
    protected String pathBackground;
    protected CircularDoublyLinkedList players;

    public SimonLauncher(CircularDoublyLinkedList players) throws IOException {

        this.pathLogo = "images/simonLogo.png";
        this.pathEnterPress = "images/enterPress.png";
        this.pathSpacePress = "images/spacePress.png";
        this.pathInstructions = "images/simonInstructions.png";
        this.pathBackground = "images/SimonBackground.png";

        this.simonCover = new Cover(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
        simonCover.createWindow();
        
        this.players = players;

    }

    public void launch() throws IOException {

        while(!startPlaying){

            System.out.println("cover");

            if(CoverEvent.closeCover){
                startPlaying = true;
            }
        }

        if (startPlaying) {

            simonCover.getWindow().setVisible(false);
            simonCover.getWindow().dispose();
            simonWindow = new SimonWindow(players);
            simonWindow.setVisible(true);

        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
