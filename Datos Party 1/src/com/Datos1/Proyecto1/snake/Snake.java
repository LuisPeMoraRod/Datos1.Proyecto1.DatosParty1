package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Snake {
    private int headX, headY;
    public BufferedImage snakeHead;
    protected final int width, height;

    public Snake(int headX, int headY) throws IOException {

        this.headX = headX;
        this.headY = headY;

        this.width = 20;
        this.height = 20;

        snakeHead = ImageIO.read(new File("images/P4.png"));

    }

    public BufferedImage getSnakeHead() {

        return snakeHead;

    }

    public int getHeadX(){
        return headX;
    }

    public int getHeadY(){
        return headY;
    }

    public void moveSnake(){

        if(SnakeEvent.up){
            headY--;

        }

        else if(SnakeEvent.down){
            headY++;

        }

        else if(SnakeEvent.right){
            headX++;

        }

        else if(SnakeEvent.left){
            headX--;

        }

    }


    public Rectangle2D setCollisionDetector(int x, int y){

        return new Rectangle2D.Double(x, y, width, height);
    }


}
