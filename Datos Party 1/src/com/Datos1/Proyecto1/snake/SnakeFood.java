package com.Datos1.Proyecto1.snake;

import java.awt.geom.Rectangle2D;

public class SnakeFood {

    private final int width, height;

    public SnakeFood(){

        this.width = 20;
        this.height = 20;

    }

    public Rectangle2D getFood1(int posX1, int posY1){

        return new Rectangle2D.Double(posX1,posY1,width,height);
    }

    public Rectangle2D getFood2(int posX2, int posY2){

        return new Rectangle2D.Double(posX2,posY2,width,height);
    }

    public Rectangle2D getFood3(int posX3, int posY3){

        return new Rectangle2D.Double(posX3,posY3,width,height);
    }

    public Rectangle2D getFood4(int posX4, int posY4){

        return new Rectangle2D.Double(posX4,posY4,width,height);
    }


}
