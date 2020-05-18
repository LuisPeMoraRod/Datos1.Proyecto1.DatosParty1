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

    private boolean creatingFood1,  creatingFood2, creatingFood3, creatingFood4;

    public int headX, headY;

    public BufferedImage snakeHead;

    public SnakeBoard() throws IOException {

        food = new SnakeFood();
        creatingFood1 = true;
        creatingFood2 = true;
        creatingFood3 = true;
        creatingFood4 = true;

        headX = 80;
        headY = 80;

        snake = new Snake(headX,headY);

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

        g2.drawImage(snakeHead,headX, headY,20,20,this);


    }

    public void createSnake(){

        snakeHead = snake.getSnakeHead();
    }



}
