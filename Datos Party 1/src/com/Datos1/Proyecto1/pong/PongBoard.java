package com.Datos1.Proyecto1.pong;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PongBoard extends JPanel {

    Ball ball = new Ball(490,290);
    PongPallets pallet1 = new PongPallets(20,275);
    PongPallets pallet2 = new PongPallets(960,275);
    BufferedImage imgBackground = ImageIO.read(new File("images/bgPong.png"));
    BufferedImage pongLogo = ImageIO.read(new File("images/pongLogo.png"));
    BufferedImage leftControls = ImageIO.read(new File("images/leftControls.png"));
    BufferedImage rightControls = ImageIO.read(new File("images/rightControls.png"));

    public PongScore pongScore;
    public int scoreP1, scoreP2;

    public PongBoard() throws IOException {

        pongScore = new PongScore();
        scoreP1 = 0;
        scoreP2 = 0;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBackground,0,0,1000,600,this);

        if(!PalletEvent.start){

            g2.drawImage(pongLogo, PongWindow.width/2-200,PongWindow.height/2 -75,400,150,this);
            g2.drawImage(leftControls, 50,PongWindow.height/2-65,50,130,this);
            g2.drawImage(rightControls, 905,PongWindow.height/2-55,45,110,this);
        }

        else{
            g2.setColor(new Color(205, 220, 57));
            drawElement(g2);
            updateElement();

            g2.setColor(Color.WHITE);
            g2.fill(pallet1.getPallet());
            g2.fill(pallet2.getPallet());
            g2.drawString(String.valueOf(scoreP1),250,50);
            g2.drawString(String.valueOf(scoreP2),750,50);

            if(scoreP2 == 5 || scoreP1 == 5){
                g.setFont(new Font("Lao Sangam LM", Font.BOLD,40));
                g.drawString("Game over", 400,280);
            }
        }



    }

    public void drawElement(Graphics2D g){

        g.fill(ball.getBall());
    }

    public void updateElement(){
        ball.moveBall(getBounds(), collision(pallet1.getPallet()), collision(pallet2.getPallet()),scoreP1,scoreP2);
        pallet1.movePallet1(getBounds());
        pallet2.movePallet2(getBounds());
        setScore();
    }

    private boolean collision(Rectangle2D r){
        return ball.getBall().intersects(r);
    }

    private void setScore(){
        scoreP1 = pongScore.setScoreP1(ball);
        scoreP2 = pongScore.setScoreP2(ball);
    }

}
