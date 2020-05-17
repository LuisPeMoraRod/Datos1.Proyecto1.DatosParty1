package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SnakeBoard extends JPanel {

    private BufferedImage imgBackground = ImageIO.read(new File("images/SnakeBackground.jpg"));

    public SnakeBoard() throws IOException {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(imgBackground,0,0,1000,600,this);

        g2.setColor(Color.YELLOW);
        g2.fillRect(0,0,20,20);

    }
}
