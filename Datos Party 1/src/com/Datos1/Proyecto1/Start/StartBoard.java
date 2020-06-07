package com.Datos1.Proyecto1.Start;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.simon.SimonWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartBoard extends JPanel {

    private boolean setPlayers;
    public boolean endStartWindow;
    private int counter;
    private int nameWidth, nameHeight;
    private BufferedImage coverBackground, gameName, playersWindow, player1, player2, player3, player4, imgChoosePlayer, imgPlayerNames;
    private PlayersEvent playersEvent = new PlayersEvent();
    private String namePlayer1;
    private String namePlayer2;
    private String namePlayer3;
    private String namePlayer4;
    private int amountPlayers;



    public StartBoard() throws IOException {

        coverBackground = ImageIO.read(new File("images/coverBackground.png"));
        gameName = ImageIO.read(new File("images/gameName.png"));
        playersWindow = ImageIO.read(new File("images/PlayersCover.png"));
        player1 = ImageIO.read(new File("images/P1.png"));
        player2 = ImageIO.read(new File("images/P2.png"));
        player3 = ImageIO.read(new File("images/P3.png"));
        player4 = ImageIO.read(new File("images/P4.png"));
        imgChoosePlayer = ImageIO.read(new File("images/choosePlayer.png"));
        imgPlayerNames = ImageIO.read(new File("images/playerNames.png"));


        counter = 0;
        nameWidth = 540;
        nameHeight = 0;
        setPlayers = false;
        addMouseListener(playersEvent);

        namePlayer1 = "Player 1";
        namePlayer2 = "Player 2";
        namePlayer3 = "Player 3";
        namePlayer4 = "Player 4";


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

            if(!playersEvent.twoFlash && !playersEvent.threeFlash && !playersEvent.fourFlash){
                g2.drawImage(imgChoosePlayer,StartWindow.width/2-imgChoosePlayer.getWidth()/2,150,this);
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
                g2.drawImage(imgPlayerNames,StartWindow.width/2-imgPlayerNames.getWidth()/2,150,this);

                g2.drawImage(player1, StartWindow.width/3, StartWindow.height/3,50,50,this);
                g2.drawImage(player2, StartWindow.width/3, StartWindow.height/3+100,50,50,this);


                JTextField tfNamePlayer1 = new JTextField();
                tfNamePlayer1.setBackground(new Color(168, 176, 197  ));
                tfNamePlayer1.setForeground(Color.WHITE);
                tfNamePlayer1.setText("Player 1");
                tfNamePlayer1.setSize(400,50);
                tfNamePlayer1.setLocation(StartWindow.width/3+75, StartWindow.height/3);
                add(tfNamePlayer1);

                JTextField tfNamePlayer2 = new JTextField();
                tfNamePlayer2.setForeground(Color.WHITE);
                tfNamePlayer2.setBackground(new Color(168, 176, 197  ));
                tfNamePlayer2.setText("Player 2");
                tfNamePlayer2.setSize(400,50);
                tfNamePlayer2.setLocation(StartWindow.width/3+75, StartWindow.height/3+100);
                add(tfNamePlayer2);

                namePlayer1 = tfNamePlayer1.getText();
                namePlayer2 = tfNamePlayer2.getText();

                if(playersEvent.getNumberPlayers()==3){
                    g2.drawImage(player3, StartWindow.width/3, StartWindow.height/3+200,50,50,this);

                    JTextField tfNamePlayer3 = new JTextField();
                    tfNamePlayer3.setBackground(new Color(168, 176, 197  ));
                    tfNamePlayer3.setText("Player 3");
                    tfNamePlayer3.setForeground(Color.WHITE);
                    tfNamePlayer3.setSize(400,50);
                    tfNamePlayer3.setLocation(StartWindow.width/3+75, StartWindow.height/3+200);
                    add(tfNamePlayer3);

                    namePlayer3 = tfNamePlayer3.getText();

                }

                else if(playersEvent.getNumberPlayers()==4){
                    g2.drawImage(player3, StartWindow.width/3, StartWindow.height/3+200,50,50,this);
                    g2.drawImage(player4, StartWindow.width/3, StartWindow.height/3+300,50,50,this);

                    JTextField tfNamePlayer3 = new JTextField();
                    tfNamePlayer3.setBackground(new Color(168, 176, 197  ));
                    tfNamePlayer3.setForeground(Color.WHITE);
                    tfNamePlayer3.setText("Player 3");
                    tfNamePlayer3.setSize(400,50);
                    tfNamePlayer3.setLocation(StartWindow.width/3+75, StartWindow.height/3+200);
                    add(tfNamePlayer3);
                    namePlayer3 = tfNamePlayer3.getText();


                    JTextField tfNamePlayer4 = new JTextField();
                    tfNamePlayer4.setBackground(new Color(168, 176, 197  ));
                    tfNamePlayer4.setForeground(Color.WHITE);
                    tfNamePlayer4.setText("Player 4");
                    tfNamePlayer4.setSize(400,50);
                    tfNamePlayer4.setLocation(StartWindow.width/3+75, StartWindow.height/3+300);
                    add(tfNamePlayer4);
                    namePlayer4 = tfNamePlayer4.getText();

                }

                g2.setColor(new Color(205, 220, 57));
                g2.fillRoundRect(StartWindow.width/2-50,StartWindow.height-150,100,50,20,20);
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Lao Sangam LM", Font.BOLD,20));
                g2.drawString("Submit",StartWindow.width/2-35,StartWindow.height-120);

                this.amountPlayers = playersEvent.getNumberPlayers();

                if(playersEvent.submitPlayers){
                    this.endStartWindow = true;
                }

            }
        }
    }

    public String getNamePlayer1(){
        return this.namePlayer1;
    }
    public String getNamePlayer2(){
        return this.namePlayer2;
    }
    public String getNamePlayer3(){
        return this.namePlayer3;
    }
    public String getNamePlayer4(){
        return this.namePlayer4;
    }
    public int getNumberPlayers(){
        return this.amountPlayers;
    }

}
