package com.Datos1.Proyecto1.SpaceRace;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Ship extends Sprite{

    public Ship() throws IOException {
        start();
    }

    private void start() throws IOException {
        BufferedImage imageicon = ImageIO.read(new File("images/Ship1.png"));
        setImage(imageicon);

        int X = 175 - 35;
        int Y = 300 - 35;

        setX(X);
        setY(Y);

    }

    @Override
    public void move() {
        y += dy;
        if(y<10){
            y=10;
        }
        if(y>= 265){
            y=265;
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            dy = 0;
        }
        if(key == KeyEvent.VK_S){
            dy = 0;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            dy = -2;
        }
        if(key == KeyEvent.VK_S){
            dy = 2;
        }
    }
}
