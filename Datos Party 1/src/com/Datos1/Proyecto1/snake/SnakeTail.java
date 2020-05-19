package com.Datos1.Proyecto1.snake;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SnakeTail {

    public int posX, posY;
    public final int tWidth, tHeight;

    public SnakeTail(int x, int y){
        this.tWidth = 20;
        this.tHeight = 20;
        this.posX = x;
        this.posY = y;
    }

    public Rectangle2D getTail(int x, int y){
        return new Rectangle2D.Double(x, y, tWidth, tHeight );
    }

    public void moveSnakeTail(int lastX, int lastY){

        if(SnakeEvent.up){

            if(posX<lastX){
                posX++;
            }
            else if(posX>lastX){
                posX--;
            }
            else {
                posY--;
            }

        }

        else if(SnakeEvent.down){

            if(posX<lastX){
                posX++;
            }
            else if(posX>lastX){
                posX--;
            }
            else {
                posY++;
            }

        }

        else if(SnakeEvent.right){

            if(posY<lastY){
                posY++;
            }
            else if(posY>lastY){
                posY--;
            }
            else {
                posX++;
            }

        }

        else if(SnakeEvent.left){

            if(posY<lastY){
                posY++;
            }
            else if(posY>lastY){
                posY--;
            }
            else {
                posX--;
            }

        }
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

}
