package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SnakeBoard extends JPanel {

    private BufferedImage imgBackground = ImageIO.read(new File("images/SnakeBackground.jpg"));

    private SnakeFood food;

    private Snake snake;

    public int tailX, tailY, lastY, lastX;

    private boolean creatingFood1,  creatingFood2, creatingFood3, creatingFood4;

    boolean beginGame;


    public BufferedImage snakeHead;

    public SnakeBoard() throws IOException {

        food = new SnakeFood();
        creatingFood1 = true;
        creatingFood2 = true;
        creatingFood3 = true;
        creatingFood4 = true;


        snake = new Snake(80,80);

        tailX = snake.getHeadX()-25;
        tailY = snake.getHeadY();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(imgBackground,0,0,1000,600,this);

        g2.setColor(new Color(205, 220, 57));
        g2.fill(food.getFood1());
        g2.fill(food.getFood2());
        g2.fill(food.getFood3());
        g2.fill(food.getFood4());

        createSnake();
        updateSnake();
        moveSnake();

        g2.drawImage(snakeHead,snake.getHeadX(), snake.getHeadY(),20,20,this);
        g2.setColor(new Color(124, 60, 171));
        g2.fill(snake.fistTail(tailX, tailY));


    }

    public void createSnake(){

        snakeHead = snake.getSnakeHead();
    }

    public void updateSnake(){

        snake.moveSnake();

    }

    public void moveSnake(){

        if(SnakeEvent.up){

            lastX = snake.getHeadX();

            if(tailX<lastX){
                tailX++;
            }
            else if(tailX>lastX){
                tailX--;
            }
            else if (tailX == lastX){
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
            else if (tailX == lastX){
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
            else if (tailY == lastY){
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
            else if (tailY == lastY){
                tailX--;
            }

        }
    }



}
