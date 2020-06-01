package com.Datos1.Proyecto1.pong;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball{

    public double x, y;

    private final int height, width;
    private double dx=1, dy=1;
    private double accelerator = 1;
    private int counter = 0;

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

            if(counter == 4){
                counter=0;
                increaseSpeed();
            }

            x+=accelerator*dx;
            y+=accelerator*dy;

            if(collisionP1){
                dx = -dx;
                x = 55;
                counter++;
            }

            if (collisionP2) {
                dx = -dx;
                x = 935;
                counter++;
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

    public void increaseSpeed(){
        accelerator = 1.1*accelerator;

    }
}
