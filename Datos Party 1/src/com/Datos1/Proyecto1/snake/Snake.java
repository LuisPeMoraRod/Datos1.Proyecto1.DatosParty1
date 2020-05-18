package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Snake {
    public int headX, headY;
    public ArrayList<Rectangle2D> tail;
    public BufferedImage snakeHead;
    protected final int  width, height;
    int position;
    int tailX, tailY;

    Rectangle2D lastTail;

    public Snake(int headX, int headY) throws IOException {

        this.headX = headX;
        this.headY = headY;
        this.width = 20;
        this.height = 20;
        tail = new ArrayList<>();
        snakeHead = ImageIO.read(new File("images/P4.png"));
        tail.add( new Rectangle2D.Double(headX-22, headY -22, width, height));

    }

    public BufferedImage getSnakeHead(){

        return snakeHead;

    }


}
