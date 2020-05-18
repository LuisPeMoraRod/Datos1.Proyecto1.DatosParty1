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

    private SnakeFood food;

    private Snake snake;

    public int tailX, tailY, lastY, lastX;

    private boolean creatingFood1,  creatingFood2, creatingFood3, creatingFood4;

    public Rectangle2D food1, food2, food3, food4;

    public BufferedImage snakeHead;

    public int posX1, posY1, posX2, posY2, posX3, posY3, posX4, posY4;

    Random random = new Random();

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

        food1 = setCreatingFood1();
        food2 = setCreatingFood2();
        food3 = setCreatingFood3();
        food4 = setCreatingFood4();

        g2.setColor(new Color(205, 220, 57));
        g2.fill(food1);
        g2.fill(food2);
        g2.fill(food3);
        g2.fill(food4);

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

    public Rectangle2D setCreatingFood1(){
        if(creatingFood1){
            posX1 = random.nextInt(980);
            posY1 = random.nextInt(580);
            creatingFood1 = false;
        }

        return food.getFood1(posX1,posY1);
    }

    public Rectangle2D setCreatingFood2(){
        if(creatingFood2){
            posX2 = random.nextInt(980);
            posY2 = random.nextInt(580);
            creatingFood2 = false;
        }

        return food.getFood2(posX2, posY2);

    }

    public Rectangle2D setCreatingFood3(){
        if(creatingFood3){
            posX3 = random.nextInt(980);
            posY3 = random.nextInt(580);
            creatingFood3 = false;

        }

        return food.getFood3(posX3,posY3);

    }

    public Rectangle2D setCreatingFood4(){
        if(creatingFood4){
            posX4 = random.nextInt(980);
            posY4 = random.nextInt(580);
            creatingFood4 = false;
        }

        return food.getFood4(posX4, posY4);
    }


}
