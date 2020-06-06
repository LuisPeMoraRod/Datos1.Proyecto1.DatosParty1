package com.Datos1.Proyecto1.Start;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartBoard extends JPanel {

    private boolean cover = true, instructions, mainWindow;
    private BufferedImage coverBackground;

    public StartBoard() throws IOException {

        coverBackground = ImageIO.read(new File("images/coverBackground.png"));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(coverBackground,0,0,1400,800,this);


    }
}
