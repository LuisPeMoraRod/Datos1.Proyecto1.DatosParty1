package com.Datos1.Proyecto1.snake;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Food {

    public int widthF, heightF;
    public Random random;

    public Food(){
        this.widthF = 20;
        this.heightF = 20;
        random = new Random();
    }

    public int setCoordX(){

        return random.nextInt(980);
    }

    public int setCoordY(){

        return random.nextInt(580);
    }

    public Rectangle2D getFood(int fx, int fy){
        return new Rectangle2D.Double(fx,fy,widthF,heightF);
    }

}
