package com.Datos1.Proyecto1.simon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Simon class
 *
 * this class contains the logic that controlls the Simon game
 *
 * @author Luis Pedro Morales Rodriguez
 *
 * @version 4/29/2020
 */

public class Simon implements ActionListener, MouseListener {


    public static Simon simon;

    public SimonRenderer simonRenderer;

    public static final int WIDTH=900, HEIGHT= 600;

    public int flashed = 0;

    public int ticks, dark, clickCounts;

    public int reference=1, indexPattern, round=1,correct;

    public boolean creatingPattern = true;

    public boolean gameOver;

    public ArrayList<Integer> pattern;

    public Random random;

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth()/2 - WIDTH / 2));
    int y = (int) ((dimension.getHeight()/2 - HEIGHT / 2));

    BufferedImage imgBackground = ImageIO.read(new File("images/SimonBackground.png"));
    BufferedImage imgP1 = ImageIO.read(new File("images/P1.png"));
    BufferedImage imgP2 = ImageIO.read(new File("images/P2.png"));
    BufferedImage imgP3 = ImageIO.read(new File("images/P3.png"));
    BufferedImage imgP4 = ImageIO.read(new File("images/P4.png"));

    public Simon() throws IOException {

        JFrame frame = new JFrame();
        Timer timer = new Timer(20,this);
        Timer gameStart = new Timer(2000,this);
        gameStart.setRepeats(false);


        simonRenderer = new SimonRenderer();
        frame.add(simonRenderer);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(x, y);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        start();
        timer.start();

    }

    public void start(){

        random = new Random();
        pattern = new ArrayList<>();
        gameOver = false;
        Timer gameStart = new Timer(2000,this);
        gameStart.setRepeats(false);

    }

    public static void main(String[] args) throws IOException {

        simon = new Simon();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        ticks++;
        if(ticks%10 ==0){

            flashed=0;

            if (!gameOver){

                if (creatingPattern && dark<=0){
                    if (reference >pattern.size()){

                        flashed = 1 + random.nextInt(6);
                        pattern.add(flashed);
                        creatingPattern = false;
                        indexPattern=0;
                        clickCounts = 0;

                    }
                    else{

                        flashed = pattern.get(indexPattern);
                        indexPattern++;

                        if (indexPattern == pattern.size()){
                            reference++;
                        }
                    }

                    dark = 2;
                }

            }

            else if(dark<=0){
                flashed = correct;
                dark = 2;
            }

            dark--;

        }

        simonRenderer.repaint();

    }

    public void paint(Graphics2D g) {

        g.drawImage(imgBackground,0,0,WIDTH,HEIGHT,simonRenderer);
        g.drawImage(imgP1,30,125,50,50,simonRenderer);
        g.drawImage(imgP2,30,225,50,50,simonRenderer);
        g.drawImage(imgP3,30,325,50,50,simonRenderer);
        g.drawImage(imgP4,30,425,50,50,simonRenderer);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Lao Sangam LM", Font.BOLD,35));
        g.drawString("Round " + round, 545,150);

        g.setColor(new Color(231, 44, 187));
        g.fillRoundRect(130,30,20,20,5,5);
        g.setColor(new Color(107, 233, 39));
        g.fillRoundRect(155,30,20,20,5,5);
        g.setColor(new Color(48, 241, 247));
        g.fillRoundRect(130,55,20,20,5,5);
        g.setColor(new Color(255, 144, 41));
        g.fillRoundRect(365,55,20,20,5,5);
        g.setColor(new Color(227, 250, 42));
        g.fillRoundRect(365,30,20,20,5,5);
        g.setColor(new Color(141, 40, 237));
        g.fillRoundRect(340,30,20,20,5,5);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Phosphate", Font.BOLD,50));
        g.drawString("S  I M  O  N", 150,75);

        if(flashed == 1){
            g.setColor(new Color(231, 44, 187));
        }
        else{
            g.setColor(new Color(139, 28, 113));
        }
        g.fillRoundRect(WIDTH/2,190, 100,100,10,10);

        if (flashed == 2){
            g.setColor(new Color(107, 233, 39));
        }
        else{
            g.setColor(new Color(106, 131, 25));
        }
        g.fillRoundRect(WIDTH/2+120,190, 100,100,10,10);

        if(flashed == 3){
            g.setColor(new Color(48, 241, 247));
        }
        else{
            g.setColor(new Color(28, 136, 139));
        }
        g.fillRoundRect(WIDTH/2+240,190, 100,100,10,10);

        if(flashed==4){
            g.setColor(new Color(255, 144, 41));
        }
        else{
            g.setColor(new Color(141, 80, 24));
        }
        g.fillRoundRect(WIDTH/2,310, 100,100,10,10);

        if(flashed == 5){
            g.setColor(new Color(227, 250, 42));
        }
        else{
            g.setColor(new Color(128, 141, 24));
        }
        g.fillRoundRect(WIDTH/2+120,310, 100,100,10,10);

        if(flashed == 6){
            g.setColor(new Color(141, 40, 237));
        }
        else{
            g.setColor(new Color(77, 22, 129));
        }
        g.fillRoundRect(WIDTH/2+240,310, 100,100,10,10);

        if(gameOver){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,40));
            g.drawString("Game over", 520,450);
        }

    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX(), mouseY = e.getY();

        if (!gameOver){

            if(!creatingPattern && clickCounts< reference){

                if (mouseX>WIDTH/2 && mouseX<WIDTH/2+100 && mouseY > 190 && mouseY<290){
                    flashed = 1;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;

                }
                else if (mouseX>WIDTH/2 + 120 && mouseX<WIDTH/2+220 && mouseY > 190 && mouseY<290){
                    flashed = 2;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
                else if(mouseX>WIDTH/2 + 240 && mouseX<WIDTH/2+340 && mouseY > 190 && mouseY<290){
                    flashed = 3;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
                else if(mouseX>WIDTH/2 && mouseX<WIDTH/2+100 && mouseY > 310 && mouseY<410){
                    flashed = 4;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
                else if(mouseX>WIDTH/2 +120 && mouseX<WIDTH/2+220 && mouseY > 310 && mouseY<410){
                    flashed = 5;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
              
                else if(mouseX>WIDTH/2 + 240 && mouseX<WIDTH/2+340 && mouseY >310 && mouseY<410){
                  
                    flashed = 6;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }


                if (clickCounts== reference){
                    creatingPattern = true;

                    if(!gameOver){
                        round++;
                    }
                    dark=2;
                    indexPattern=0;
                }

            }
        }

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
