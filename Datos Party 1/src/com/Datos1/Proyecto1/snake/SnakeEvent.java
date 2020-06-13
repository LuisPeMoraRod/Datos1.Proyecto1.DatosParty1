package com.Datos1.Proyecto1.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * SnakeEvent extends KeyAdapter to detect a specific key input that will activate the class flags
 * to control actions such as the direction of the snake and the start of the game.
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class SnakeEvent extends KeyAdapter {

    static boolean up, right, left, down, instructions, startCover = true;

    public SnakeEvent(){

        right = true;
    }

    /**
     * Invoked when a key has been pressed.
     */

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int id = e.getKeyCode();

        if(id == KeyEvent.VK_ENTER){
            startCover= false;
            instructions = true;
        }

        if(id == KeyEvent.VK_SPACE && startCover==false){
            instructions = false;
        }

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
