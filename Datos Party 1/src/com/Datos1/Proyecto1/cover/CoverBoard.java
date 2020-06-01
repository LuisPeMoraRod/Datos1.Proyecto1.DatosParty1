package com.Datos1.Proyecto1.cover;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoverBoard extends JPanel {

    BufferedImage logo;
    BufferedImage background;
    BufferedImage enterPress;
    BufferedImage spacePress;
    BufferedImage instructions;

    public CoverBoard(String logoPath, String backgroundPath, String enterPressPath, String spacePressPath, String instructionsPath ) throws IOException {
        this.logo = ImageIO.read(new File(logoPath));
        this.background = ImageIO.read(new File(backgroundPath));
        this.enterPress = ImageIO.read(new File(enterPressPath));
        this.spacePress = ImageIO.read(new File(spacePressPath));
        this.instructions = ImageIO.read(new File(instructionsPath));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background,0,0,CoverWindow.width,CoverWindow.height,this);

        if (CoverEvent.cover){
            g.drawImage(logo, CoverWindow.width/2-logo.getWidth()/2, CoverWindow.height/2-logo.getHeight()/2, this);
            g.drawImage(enterPress, CoverWindow.width/2 - enterPress.getWidth()/2, CoverWindow.height-enterPress.getHeight()-10,this);
        }

        else if(CoverEvent.instructions){
            g.drawImage(instructions, CoverWindow.width/2-instructions.getWidth()/2, CoverWindow.height/2-instructions.getHeight()/2, this);
            g.drawImage(spacePress, CoverWindow.width/2 - spacePress.getWidth()/2, CoverWindow.height-spacePress.getHeight()-10,this);
        }


    }

}
