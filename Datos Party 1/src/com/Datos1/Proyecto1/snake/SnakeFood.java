package com.Datos1.Proyecto1.snake;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class SnakeFood {

    private final int width, height;
    public int posX1, posY1, posX2, posY2, posX3, posY3, posX4, posY4;

    Random random = new Random();

    public SnakeFood(){

        this.width = 20;
        this.height = 20;

    }

    public Rectangle2D getFood1(){


        posX1 = random.nextInt(980);
        posY1 = random.nextInt(580);

        return new Rectangle2D.Double(posX1,posY1,width,height);
    }

    public Rectangle2D getFood2(){

        posX2 = random.nextInt(980);
        posY2 = random.nextInt(580);

        return new Rectangle2D.Double(posX2,posY2,width,height);
    }

    public Rectangle2D getFood3(){

        posX3 = random.nextInt(980);
        posY3 = random.nextInt(580);

        return new Rectangle2D.Double(posX3,posY3,width,height);
    }

    public Rectangle2D getFood4(){

        posX4 = random.nextInt(980);
        posY4 = random.nextInt(580);

        return new Rectangle2D.Double(posX4,posY4,width,height);
    }


}
