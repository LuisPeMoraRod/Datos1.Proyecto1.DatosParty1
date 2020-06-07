package com.Datos1.Proyecto1.Start;

import com.Datos1.Proyecto1.simon.SimonWindow;

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
    private BufferedImage coverBackground, gameName, playersWindow, player1, player2, player3, player4;
    private PlayersEvent playersEvent = new PlayersEvent();

    public StartBoard() throws IOException {

        coverBackground = ImageIO.read(new File("images/coverBackground.png"));
        gameName = ImageIO.read(new File("images/gameName.png"));
        playersWindow = ImageIO.read(new File("images/PlayersCover.png"));
        player1 = ImageIO.read(new File("images/P1.png"));
        player2 = ImageIO.read(new File("images/P2.png"));
        player3 = ImageIO.read(new File("images/P3.png"));
        player4 = ImageIO.read(new File("images/P4.png"));

        counter = 0;
        nameWidth = 540;
        nameHeight = 0;
        setPlayers = false;
        addMouseListener(playersEvent);



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

            if(!PlayersEvent.twoFlash && !PlayersEvent.threeFlash && !PlayersEvent.fourFlash){
                g2.setColor(new Color(171, 225, 223));
                g2.fillRoundRect(StartWindow.width/4 - 50, StartWindow.height/3,100,100,20,20);
                g2.setColor(new Color(205, 220, 57));
                g2.fillRoundRect(StartWindow.width/2 - 50, StartWindow.height/3,100,100,20,20);
                g2.setColor(new Color(173, 20, 87));
                g2.fillRoundRect(3*StartWindow.width/4 - 50, StartWindow.height/3,100,100,20,20);

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Lao Sangam LM", Font.BOLD,50));
                g2.drawString("2", StartWindow.width/4-15,StartWindow.height/3+70);
                g2.drawString("3", StartWindow.width/2-15,StartWindow.height/3+70);
                g2.drawString("4", 3*StartWindow.width/4-15,StartWindow.height/3+70);
            }

            else{
                if(PlayersEvent.twoFlash){
                    g2.drawImage(player1, SimonWindow.width/3, SimonWindow.height/3,50,50,this);
                    g2.drawImage(player2, SimonWindow.width/3, SimonWindow.height/3+100,50,50,this);
                }
                else if(PlayersEvent.threeFlash){
                    g2.drawImage(player1, SimonWindow.width/3, SimonWindow.height/3,50,50,this);
                    g2.drawImage(player2, SimonWindow.width/3, SimonWindow.height/3+100,50,50,this);
                    g2.drawImage(player3, SimonWindow.width/3, SimonWindow.height/3+200,50,50,this);
                }
                else if(PlayersEvent.fourFlash){
                    g2.drawImage(player1, SimonWindow.width/3, SimonWindow.height/3,50,50,this);
                    g2.drawImage(player2, SimonWindow.width/3, SimonWindow.height/3+100,50,50,this);
                    g2.drawImage(player3, SimonWindow.width/3, SimonWindow.height/3+200,50,50,this);
                    g2.drawImage(player4, SimonWindow.width/3, SimonWindow.height/3+300,50,50,this);
                }
            }


        }

    }

}
