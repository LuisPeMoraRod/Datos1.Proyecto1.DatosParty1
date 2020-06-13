package com.Datos1.Proyecto1.Start;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * PlayersEvent set the logic that will indicate the amount of players that will play the game using the mouse X and Y
 * positions and depending on them a specific flag will be set true.
 */

public class PlayersEvent implements MouseListener {

    public boolean twoFlash = false, threeFlash = false, fourFlash = false,submitPlayers = false;
    protected int players;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX(), mouseY = e.getY();

        if(mouseX>StartWindow.width/4-50 && mouseX < StartWindow.width/4+50 && mouseY>StartWindow.height/3 && mouseY<StartWindow.height/3+100){
            this.twoFlash = true;
            this.players = 2;
        }
        else if(mouseX>StartWindow.width/2-50 && mouseX < StartWindow.width/2+50 && mouseY>StartWindow.height/3 && mouseY<StartWindow.height/3+100){
            this.threeFlash = true;
            this.players = 3;
        }
        else if(mouseX>3*StartWindow.width/4-50 && mouseX < 3*StartWindow.width/4+50 && mouseY>StartWindow.height/3 && mouseY<StartWindow.height/3+100){
            this.fourFlash = true;
            this.players = 4;
        }

        if(twoFlash||threeFlash||fourFlash){
            if(mouseX>StartWindow.width/2-50 && mouseX<StartWindow.width+50 && mouseY>StartWindow.height-150 && mouseY<StartWindow.height-100){
                this.submitPlayers=true;
            }
        }

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

    /**
     *
     * @return the amount of players requested
     */

    public int getNumberPlayers(){
        return this.players;
    }
}
