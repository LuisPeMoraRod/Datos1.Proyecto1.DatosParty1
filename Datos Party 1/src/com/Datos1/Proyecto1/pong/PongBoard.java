package com.Datos1.Proyecto1.pong;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PongBoard extends JPanel {

    Ball ball = new Ball(0,0);
    PongPallets pallet1 = new PongPallets(20,200);
    PongPallets pallet2 = new PongPallets(960,200);
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

        g2.setColor(Color.WHITE);
        g2.fill(pallet1.getPallet());
        g2.fill(pallet2.getPallet());


    }

    public void drawElement(Graphics2D g){
        g.fill(ball.getBall());
    }

    public void updateElement(){
        ball.moveBall(getBounds());
        pallet1.movePallet1(getBounds());
        pallet2.movePallet2(getBounds());
    }

  /*  public void interateGame() throws InterruptedException {
        while(true){
            repaint();
            Thread.sleep(6);
        }
    }*/
}
