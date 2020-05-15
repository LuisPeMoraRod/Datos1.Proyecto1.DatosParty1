package com.Datos1.Proyecto1.pong;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball{

    private int x, y;

    private final int height = 20, width=20;
    private int dx=1, dy=1;

    public Ball(int x, int y){

        this.x = x;
        this.y = y;
    }

    public Rectangle2D getBall(){
        return new Rectangle2D.Double(x,y,width,height);
    }

    public void moveBall(Rectangle limits){
        x+=dx;
        y+=dy;

        if (x>limits.getMaxX()-width){
            dx = -dx;
        }

        if (x<0){
            dx=-dx;
        }

        if(y>limits.getMaxY()-height){
            dy = -dy;
        }

        if (y<0){
            dy=-dy;
        }
    }
}
