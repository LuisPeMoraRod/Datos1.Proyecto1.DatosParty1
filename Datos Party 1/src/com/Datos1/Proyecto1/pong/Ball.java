package com.Datos1.Proyecto1.pong;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball{

    public int x, y;

    private final int height, width;
    private int dx=1, dy=1;

    public Ball(int x, int y){

        this.x = x;
        this.y = y;
        this.height = 20;
        this.width = 20;
    }

    public Rectangle2D getBall(){

        return new Rectangle2D.Double(x,y,width,height);
    }

    public void moveBall(Rectangle limits, boolean collisionP1, boolean collisionP2, int scoreP1, int scoreP2){

        if(scoreP1 == 5 || scoreP2 == 5){
            stopBall();
        }

        else{

            x+=dx;
            y+=dy;

            if(collisionP1){
                dx = -dx;
                x = 55;
            }

            if (collisionP2) {
                dx = -dx;
                x = 935;
            }


            if (x>=limits.getMaxX()-width){
                dx = -dx;
            }

            if (x<=0){
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

    public void stopBall(){

        x = 490;
        y=290;

    }
}
