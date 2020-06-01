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
    private BufferedImage snakeLogo = ImageIO.read(new File("images/snakeLogo.png"));
    private BufferedImage snakeCL = ImageIO.read(new File("images/snakeCL.png"));
    private BufferedImage snakeCR = ImageIO.read(new File("images/snakeCR.png"));
    private BufferedImage snakeInstructions = ImageIO.read(new File("images/snakeInstructions.png"));
    private BufferedImage enterPress = ImageIO.read(new File("images/enterPress.png"));
    private BufferedImage spacePress = ImageIO.read(new File("images/spacePress.png"));

    private SnakeHead snakeHead;


    public BufferedImage headImg;

    public int fx1, fy1;

    public Food f1;

    public int score;

    private int dx, dy;

    private final int snakeSize = 20;


    Random random = new Random();

    Rectangle2D food1;

    SnakeTail collisionDetector;

    ArrayList<SnakeTail> snakeTail;


    private boolean gameOver = false;

    public SnakeBoard() throws IOException {

        snakeHead = new SnakeHead(80,80);

        fx1 = random.nextInt(980);
        fy1 = random.nextInt(580);

        f1 = new Food();

        score = 0;

        snakeTail = new ArrayList<>();

        collisionDetector = new SnakeTail();
        collisionDetector.setPosition(snakeHead.getHeadX(), snakeHead.getHeadY());

        snakeTail.add(collisionDetector);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;


        g2.drawImage(imgBackground,0,0,1000,600,this);

        if(SnakeEvent.startCover){

            g2.drawImage(snakeLogo,SnakeWindow.width/2-200,SnakeWindow.height/2-100,400,200,this);
            g2.drawImage(enterPress,SnakeWindow.width/2-132,SnakeWindow.height/2+250,264,46,this);

        }

        else if(SnakeEvent.instructions){

            g2.drawImage(snakeCL,20,20,168,114,this);
            g2.drawImage(snakeCR,SnakeWindow.width-188,SnakeWindow.height-124,168,104,this);
            g2.drawImage(snakeInstructions,SnakeWindow.width/2-247,SnakeWindow.height/2-111,494,222,this);
            g2.drawImage(spacePress,SnakeWindow.width/2-142,SnakeWindow.height/2+250,284,46,this);

            g2.setColor(new Color(205, 220, 57));
            g2.setFont(new Font("Eurostile", Font.BOLD,15));
            g2.drawString("Left player controls", 25, 145);
            g2.drawString("Right player controls", SnakeWindow.width-185 , 450);

        }

        else{
            g2.setColor(new Color(205, 220, 57));

            food1 = f1.getFood(fx1,fy1);
            g2.fill(food1);

            createSnake();

            if(!gameOver){
                updateSnake();
            }
            else{
                g.setColor(Color.WHITE);
                g.setFont(new Font("Lao Sangam LM", Font.BOLD,40));
                g.drawString("Game over", 400,280);
                g.setColor(new Color(173, 20, 87));
                g.setFont(new Font("Lao Sangam LM", Font.BOLD,30));
                g.drawString("Score: " + score, 450,320);
            }

            detectColliion();
            detectFoodCollection();


            g2.setColor(new Color(124, 60, 171));
            for (SnakeTail t: snakeTail){
                t.render(g2);
            }

            g2.drawImage(headImg, snakeHead.getHeadX(), snakeHead.getHeadY(),20,20,this);
        }


    }

    public void createSnake(){

        headImg = snakeHead.getSnakeHead();
    }

    public void updateSnake(){

        snakeHead.moveSnakeHead();

        if(SnakeEvent.up && dy == 0){
            dy = -snakeSize;
            dx = 0;
        }

        else if(SnakeEvent.down && dy == 0){
            dy = snakeSize;
            dx = 0;
        }

        else if(SnakeEvent.left && dx == 0){
            dx = -snakeSize;
            dy = 0;
        }

        else if(SnakeEvent.right && dx == 0){
            dx = snakeSize;
            dy = 0;
        }

        if (dx != 0 || dy != 0){

            for(int i = snakeTail.size()-1; i>0; i--){

                snakeTail.get(i).setPosition(snakeTail.get(i-1).getTailX(), snakeTail.get(i-1).getTailY());
            }

            collisionDetector.moveTail(dx,dy);
        }



        if(collisionDetector.getTailX()<0) {
            collisionDetector.setTailX(1000);
        }

        if(collisionDetector.getTailY()<0){
            collisionDetector.setTailY(600);
        }

        if(collisionDetector.getTailX()>1000) {
            collisionDetector.setTailX(0);
        }

        if(collisionDetector.getTailY()>600){
            collisionDetector.setTailY(0);
        }

    }

    public void detectFoodCollection(){
        if(snakeTail.get(0).getTail().intersects(food1)){
            fx1 = f1.setCoordX();
            fy1 = f1.setCoordY();
            SnakeTail t = new SnakeTail();
            t.setPosition(collisionDetector.getTailX() + ((snakeTail.size()+1)*20), collisionDetector.getTailY());
            snakeTail.add(t);
            score++;
        }

    }

    public void detectColliion(){
        for(SnakeTail t : snakeTail){
            if(t.isCollision(collisionDetector) || collisionDetector.getTailX()==0 || collisionDetector.getTailX()==980 || collisionDetector.getTailY() == 0 || collisionDetector.getTailY()==580){
                gameOver=true;
            }
        }
    }

}
