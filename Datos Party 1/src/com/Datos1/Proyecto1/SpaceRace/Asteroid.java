package com.Datos1.Proyecto1.SpaceRace;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Asteroid extends Sprite{
    public Asteroid() throws IOException {
        start();

    }

    private void start() throws IOException {
        BufferedImage imageicon = ImageIO.read(new File("images/asteroid.png"));
        setImage(imageicon);

        //int X = 175 - 35;
        //int Y = 300 - 35;

        //setX(X);
        //setY(Y);
    }

    @Override
    public void move() {

    }
}
