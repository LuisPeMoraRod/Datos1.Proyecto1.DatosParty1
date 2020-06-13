package com.Datos1.Proyecto1.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * PalletEvent extends from KeyAdapter to get specific key entrances that will activate certain flags
 * that will set the direction of the pallets
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class PalletEvent extends KeyAdapter {

    static boolean w, s, up, down, cover=true, instructions;

    /**
     * Each time a specific key is pressed the pallet will move up or down
     * @param e
     */

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int id = e.getKeyCode();

        if(id == KeyEvent.VK_W){
            w = true;
        }
        else if(id == KeyEvent.VK_S){
            s = true;
        }

        if (id == KeyEvent.VK_UP){
            up = true;
        }
        else if (id == KeyEvent.VK_DOWN){
            down = true;
        }

        if(id== KeyEvent.VK_ENTER){
            cover= false;
            instructions = true;
        }

        if(id == KeyEvent.VK_SPACE && cover==false){
            instructions = false;
        }
    }

    /**
     * When the specific keys are released the flag that it controls will become false and the pallet wont move
     * @param e
     */

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);

        int id = e.getKeyCode();

        if(id == KeyEvent.VK_W){
            w = false;
        }
        else if(id == KeyEvent.VK_S){
            s = false;
        }

        if (id == KeyEvent.VK_UP){
            up = false;
        }
        else if (id == KeyEvent.VK_DOWN){
            down = false;
        }
    }
}
