package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SnakeBoard extends JPanel {

    private BufferedImage imgBackground = ImageIO.read(new File("images/SnakeBackground.jpg"));


    private Snake snake;


    public int tailX, tailY, lastY, lastX;


    public BufferedImage snakeHead;

    public int fx1, fy1;

    public Food f1;

    Random random = new Random();

    Rectangle2D food1;

    Rectangle2D collisionDetector;


    public SnakeBoard() throws IOException {

        snake = new Snake(80,80);

        tailX = snake.getHeadX()-25;
        tailY = snake.getHeadY();

        fx1 = random.nextInt(980);
        fy1 = random.nextInt(580);

        f1 = new Food();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;


        g2.drawImage(imgBackground,0,0,1000,600,this);

        g2.setColor(new Color(205, 220, 57));

        food1 = f1.getFood(fx1,fy1);
        g2.fill(food1);

        createSnake();
        updateSnake();
        moveSnakeTail();
        detectFoodCollection();

        g2.setColor(new Color(124, 60, 171));
        g2.fill(snake.firstTail(tailX, tailY));
        g2.fill(collisionDetector);
        g2.drawImage(snakeHead,snake.getHeadX(), snake.getHeadY(),20,20,this);

    }

    public void createSnake(){

        snakeHead = snake.getSnakeHead();
        collisionDetector = snake.setCollisionDetector(snake.getHeadX(),snake.getHeadY());
    }

    public void updateSnake(){

        snake.moveSnake();

    }

    public void moveSnakeTail(){

        if(SnakeEvent.up){

            lastX = snake.getHeadX();

            if(tailX<lastX){
                tailX++;
            }
            else if(tailX>lastX){
                tailX--;
            }
            else {
                tailY--;
            }

        }

        else if(SnakeEvent.down){
            lastX = snake.getHeadX();

            if(tailX<lastX){
                tailX++;
            }
            else if(tailX>lastX){
                tailX--;
            }
            else {
                tailY++;
            }

        }

        else if(SnakeEvent.right){
            lastX = snake.getHeadX();
            lastY = snake.getHeadY();

            if(tailY<lastY){
                tailY++;
            }
            else if(tailY>lastY){
                tailY--;
            }
            else {
                tailX++;
            }

        }

        else if(SnakeEvent.left){
            lastX = snake.getHeadX();
            lastY = snake.getHeadY();

            if(tailY<lastY){
                tailY++;
            }
            else if(tailY>lastY){
                tailY--;
            }
            else {
                tailX--;
            }

        }
    }


    public void detectFoodCollection(){
        if(collisionDetector.intersects(food1)){
            fx1 = f1.setCoordX();
            fy1 = f1.setCoordY();
        }
    }
}
