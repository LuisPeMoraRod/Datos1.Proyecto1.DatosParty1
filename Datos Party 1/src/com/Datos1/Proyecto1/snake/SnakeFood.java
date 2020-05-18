package com.Datos1.Proyecto1.snake;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class SnakeFood {

    public final int width, height;
    public int posX, posY;

    Random random;


    public SnakeFood(){

        width = 20;
        height = 20;

    }

    public Rectangle2D generateFood(){

        posX = setPosX();
        posY = setPosY();

        return new Rectangle2D.Double(posX, posY, width, height);

    }

    public int setPosX(){
        return random.nextInt(980);
    }

    public int setPosY(){
        return random.nextInt(580);
    }

}
