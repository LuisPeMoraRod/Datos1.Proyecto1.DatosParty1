package com.Datos1.Proyecto1.SpaceRace;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Ship extends Sprite{
    private boolean movement;
    private final int width = 38;
    private final int height = 50;

    public Ship() throws IOException {
        start();
    }

    private void start() throws IOException {
        BufferedImage imageicon = ImageIO.read(new File("images/Ship1.png"));
        setImage(imageicon);
        movement = true;

        int X = 175 - 25;
        int Y = 300 - 19;

        setX(X);
        setY(Y);

    }

    @Override
    public void move() {
        y += dy;
        if(y<10){
            y=10;
        }else if(y>= 265){
            y=265;
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            dy = 0;
        }else if(key == KeyEvent.VK_S){
            dy = 0;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(movement) {
            if (key == KeyEvent.VK_W) {
                dy = -2;
            } else if (key == KeyEvent.VK_S) {
                dy = 2;
            }
        }
    }
    public void setMovement(boolean movement) {
        this.movement = movement;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
}
