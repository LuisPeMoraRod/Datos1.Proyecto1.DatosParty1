package com.Datos1.Proyecto1.snake;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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

    public void moveTail(int dx, int dy){

        x += dx;
        y += dy;
    }

    public Rectangle2D getTail() {
        return new Rectangle2D.Double(x, y, width, height);
    }

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
