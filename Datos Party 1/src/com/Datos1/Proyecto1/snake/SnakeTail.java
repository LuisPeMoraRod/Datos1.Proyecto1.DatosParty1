package com.Datos1.Proyecto1.snake;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 *
 * SnakeTail is a type of object that represents each one of the tiles that conform the body of the snake and controlls
 * its position and movement
 *
 * @author moniwaterhouse
 * @version 1.0
 */

public class SnakeTail {

    private int x,y;
    private int width = 20, height=20;

    public int getTailX(){
        return x;
    }

    public int getTailY(){
        return y;
    }

    public void setTailX(int x){
        this.x = x;
    }

    public void setTailY(int y){
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the position of the tail by adding dx and dy parameters to the actual position
     * @param dx
     * @param dy
     */
    public void moveTail(int dx, int dy){

        x += dx;
        y += dy;
    }

    /**
     *
     * @return Rectangle2D object that will represent one of the tiles of the snake body
     */

    public Rectangle2D getTail() {
        return new Rectangle2D.Double(x, y, width, height);
    }

    /**
     *  Checks if one of the tail tiles collides collides with an object of type SnakeTail
     * @param o
     * @return
     */

    public boolean isCollision(SnakeTail o){
        if(o == this){
            return false;
        }
        else{
            return getTail().intersects(o.getTail());
        }
    }

    public void render(Graphics2D g2){
        g2.fillRect(x+1,y+1,width-2,height-2);
    }
}
