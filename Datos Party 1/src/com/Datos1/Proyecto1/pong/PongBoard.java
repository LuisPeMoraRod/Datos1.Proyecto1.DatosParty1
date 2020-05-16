package com.Datos1.Proyecto1.pong;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PongBoard extends JPanel {

    Ball ball = new Ball(0,0);
    PongPallets pallet1 = new PongPallets(20,200);
    PongPallets pallet2 = new PongPallets(960,200);
    BufferedImage imgBackground = ImageIO.read(new File("images/bgPong.png"));
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

        g2.setColor(new Color(205, 220, 57));
        drawElement(g2);
        updateElement();

        g2.setColor(Color.WHITE);
        g2.fill(pallet1.getPallet());
        g2.fill(pallet2.getPallet());
        g2.drawString(String.valueOf(scoreP1),250,50);
        g2.drawString(String.valueOf(scoreP2),750,50);

    }

    public void drawElement(Graphics2D g){
        g.fill(ball.getBall());
    }

    public void updateElement(){
        ball.moveBall(getBounds(), collision(pallet1.getPallet()), collision(pallet2.getPallet()));
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
