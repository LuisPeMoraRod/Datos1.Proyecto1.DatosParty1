package com.Datos1.Proyecto1.snake;

import java.io.IOException;

/**
 * SnakeHead represents one the initial the head of the snake
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class SnakeHead {
    private int headX, headY;
    protected final int width, height;

    public SnakeHead(int headX, int headY) throws IOException {

        this.headX = headX;
        this.headY = headY;

        this.width = 20;
        this.height = 20;

    }

    public int getHeadX(){
        return headX;
    }

    public int getHeadY(){
        return headY;
    }

    /**
     * Moves the snake the equivalent of the snake size to the right, left, up or down depending on the
     * the flags obtained from the SnakeEvent class
     */

    public void moveSnakeHead(){

        if(SnakeEvent.up){
            headY-=height;

        }

        else if(SnakeEvent.down){
            headY+=height;

        }

        else if(SnakeEvent.right){
            headX+=width;

        }

        else if(SnakeEvent.left){
            headX-=height;

        }

    }

    public void setHeadPosition(int headX, int headY) {
        this.headX = headX;
        this.headY = headY;
    }
}
