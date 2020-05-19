package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SnakeBoard extends JPanel {

    private BufferedImage imgBackground = ImageIO.read(new File("images/SnakeBackground.jpg"));


    private Snake snake;


    public int lastY, lastX;


    public BufferedImage snakeHead;

    public int fx1, fy1;

    public Food f1;

    public int score;

    Random random = new Random();

    Rectangle2D food1;

    Rectangle2D collisionDetector;

    ArrayList<SnakeTail> tail;

    int selector;

    public SnakeBoard() throws IOException {

        snake = new Snake(80,80);

        fx1 = random.nextInt(980);
        fy1 = random.nextInt(580);

        f1 = new Food();

        score = 0;

        tail = new ArrayList<>();

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
        detectFoodCollection();


        g2.setColor(new Color(124, 60, 171));
        g2.fill(collisionDetector);
        for (selector=0; selector<score; selector++){
            lastX = tail.get(selector).getPosX();
            lastY = tail.get(selector).getPosY();
            g2.fill(tail.get(selector).getTail(lastX, lastY));
        }

        g2.drawImage(snakeHead,snake.getHeadX(), snake.getHeadY(),20,20,this);

    }

    public void createSnake(){

        snakeHead = snake.getSnakeHead();
        collisionDetector = snake.setCollisionDetector(snake.getHeadX(),snake.getHeadY());
    }

    public void updateSnake(){

        snake.moveSnake();
        for (selector=0; selector<score; selector++){
            tail.get(selector).moveSnakeTail(lastX, lastY);
        }

    }

    public void detectFoodCollection(){
        if(collisionDetector.intersects(food1)){
            fx1 = f1.setCoordX();
            fy1 = f1.setCoordY();

            if(score == 0){
                tail.add(new SnakeTail(snake.getHeadX() - 25, snake.getHeadY()));
            }
            else{
                tail.add((new SnakeTail(tail.get(score-1).posX-25, tail.get(score-1).posY)));
            }
            score++;

        }
    }

}
