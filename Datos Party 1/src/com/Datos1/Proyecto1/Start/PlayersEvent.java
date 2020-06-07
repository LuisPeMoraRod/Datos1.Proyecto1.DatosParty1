package com.Datos1.Proyecto1.Start;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayersEvent implements MouseListener {

    public static boolean twoFlash, threeFlash, fourFlash;
    protected int players;


    @Override
    public void mouseClicked(MouseEvent e) {

        int mouseX = e.getX(), mouseY = e.getY();

        if(mouseX>StartWindow.width/4-50 && mouseX < StartWindow.width/4+50 && mouseY>StartWindow.height/3 && mouseY<StartWindow.height/3+100){
            twoFlash = true;
            this.players = 2;
        }
        else if(mouseX>StartWindow.width/2-50 && mouseX < StartWindow.width/2+50 && mouseY>StartWindow.height/3 && mouseY<StartWindow.height/3+100){
            threeFlash = true;
            this.players = 3;
        }
        else if(mouseX>3*StartWindow.width/4-50 && mouseX < 3*StartWindow.width/4+50 && mouseY>StartWindow.height/3 && mouseY<StartWindow.height/3+100){
            fourFlash = true;
            this.players = 4;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {



    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getNumberPlayers(){
        return this.players;
    }
}
