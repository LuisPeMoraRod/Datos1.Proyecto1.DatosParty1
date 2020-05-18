package com.Datos1.Proyecto1.snake;

        import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;

public class SnakeBoard extends JPanel {

    private BufferedImage imgBackground = ImageIO.read(new File("images/SnakeBackground.jpg"));


    private Snake snake;

    public int tailX, tailY, lastY, lastX;

    public BufferedImage snakeHead;

    public SnakeBoard() throws IOException {


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




}
