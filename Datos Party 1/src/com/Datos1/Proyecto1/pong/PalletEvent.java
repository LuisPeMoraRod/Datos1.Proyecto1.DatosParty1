package com.Datos1.Proyecto1.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PalletEvent extends KeyAdapter {

    static boolean w, s, up, down;

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
    }

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
