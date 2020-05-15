package com.Datos1.Proyecto1.pong;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.*;

public class PongBoard extends JPanel {

    Ball ball = new Ball(0,0);
    BufferedImage imgBackground = ImageIO.read(new File("images/bgPong.png"));

    public PongBoard() throws IOException {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBackground,0,0,1000,600,this);

        g2.setColor(new Color(205, 220, 57));
        drawElement(g2);
        updateElement();



    }

    public void drawElement(Graphics2D g){
        g.fill(ball.getBall());
    }

    public void updateElement(){
        ball.moveBall(getBounds());
    }

    public void interateGame() throws InterruptedException {
        while(true){
            repaint();
            Thread.sleep(6);
        }
    }
}
