package com.Datos1.Proyecto1.Start;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartBoard extends JPanel {

    private boolean instructions, mainWindow, setPlayers;
    private int counter;
    private int nameWidth, nameHeight;
    private BufferedImage coverBackground, gameName, playersWindow;

    public StartBoard() throws IOException {

        coverBackground = ImageIO.read(new File("images/coverBackground.png"));
        gameName = ImageIO.read(new File("images/gameName.png"));
        playersWindow = ImageIO.read(new File("images/PlayersCover.png"));

        counter = 0;
        nameWidth = 540;
        nameHeight = 0;
        setPlayers = false;



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // Paints the elements for the game cover
        if (counter<=1000){
            g2.drawImage(coverBackground,0,0,1400,800,this);
            int finalNameHeight = gameName.getHeight();

            if(nameHeight<=finalNameHeight){
                g2.drawImage(gameName,StartWindow.width/2-nameWidth/2,StartWindow.height/4-nameHeight/2,nameWidth,nameHeight,this);
                nameWidth++;
                nameHeight++;
            }
            else{
                g2.drawImage(gameName,StartWindow.width/2-nameWidth/2,StartWindow.height/4-nameHeight/2,nameWidth,nameHeight,this);
            }
            counter++;

            if (counter == 1000){
                setPlayers = true;
            }
        }

        if (setPlayers){
            g2.drawImage(playersWindow,0,0,StartWindow.width, StartWindow.height,this);

            g2.setColor(new Color(171, 225, 223));
            g2.fillRoundRect(StartWindow.width/5 - 50, StartWindow.height/3,100,100,20,20);
            g2.setColor(new Color(205, 220, 57));
            g2.fillRoundRect(2*StartWindow.width/5 - 50, StartWindow.height/3,100,100,20,20);
            g2.setColor(new Color(173, 20, 87));
            g2.fillRoundRect(3*StartWindow.width/5 - 50, StartWindow.height/3,100,100,20,20);
            g2.setColor(new Color(255, 160, 0));
            g2.fillRoundRect(4*StartWindow.width/5 - 50, StartWindow.height/3,100,100,20,20);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Lao Sangam LM", Font.BOLD,50));
            g2.drawString("1", StartWindow.width/5-15,StartWindow.height/3+70);
            g2.drawString("2", 2*StartWindow.width/5-15,StartWindow.height/3+70);
            g2.drawString("3", 3*StartWindow.width/5-15,StartWindow.height/3+70);
            g2.drawString("4", 4*StartWindow.width/5-15,StartWindow.height/3+70);
        }
        
    }

}
