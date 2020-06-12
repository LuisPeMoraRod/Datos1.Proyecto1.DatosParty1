package com.Datos1.Proyecto1.snake;

import java.io.IOException;

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
