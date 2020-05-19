package com.Datos1.Proyecto1.snake;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Food {

    public int fx, fy;
    public int widthF, heightF;
    public Random random;

    public Food(int fx, int fy){
        this.widthF = 20;
        this.heightF = 20;
        this.fx = fx;
        this.fy = fy;
        random = new Random();
    }

    public void setCoords(boolean creatingFood){
        if(creatingFood){
            fx = random.nextInt(980);
            fy = random.nextInt(580);
        }
    }

    public Rectangle2D getFood(){
        return new Rectangle2D.Double(fx,fy,widthF,heightF);
    }

}
