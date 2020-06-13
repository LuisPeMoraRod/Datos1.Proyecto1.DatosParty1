package com.Datos1.Proyecto1.snake;

import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Food is type of object that represents the food that the snake will collect for it to increase its tail size
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class Food {

    public int widthF, heightF;
    public Random random;

    public Food(){
        this.widthF = 20;
        this.heightF = 20;
        random = new Random();
    }

    /**
     *
     * @return random int that will represent the x position of the food
     */

    public int setCoordX(){

        return random.nextInt(980);
    }

    /**
     *
     * @return random int that will represent the y position of the food
     */

    public int setCoordY(){

        return random.nextInt(580);
    }

    /**
     *
     * @param fx x position for the food
     * @param fy y position for the food
     * @return Rectangle2D type of object that will represent the food in the board
     */
    public Rectangle2D getFood(int fx, int fy){
        return new Rectangle2D.Double(fx,fy,widthF,heightF);
    }

}
