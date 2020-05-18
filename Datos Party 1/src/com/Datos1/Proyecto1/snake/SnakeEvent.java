package com.Datos1.Proyecto1.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeEvent extends KeyAdapter {

    static boolean up, right, left, down;

    public SnakeEvent(){

        right = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int id = e.getKeyCode();


        if(id == KeyEvent.VK_DOWN && !up){
            down = true;
            right = false;
            left = false;

        }

        else if (id == KeyEvent.VK_UP && !down){
            up = true;
            right = false;
            left = false;
        }

        else if (id == KeyEvent.VK_RIGHT && !left){
            right = true;
            up = false;
            down = false;
        }

        else if(id == KeyEvent.VK_LEFT && !right){
            left = true;
            up = false;
            down = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);


    }
}
