package com.Datos1.Proyecto1.simon;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.GameBoardLauncher;
import com.Datos1.Proyecto1.GameBoard.LinkedList;

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
 * @author Monica Waterhouse Montoya
 *
 * @version 6/10/2020
 */

public class SimonBoard extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	public int flashed = 0;

    public int ticks, dark, clickCounts;

    public int reference=1, indexPattern, round=1, correct;

    public boolean creatingPattern = true;

    public boolean gameOver;

    public ArrayList<Integer> pattern;
    
    public ArrayList<Integer> results;

    public Random random;

    protected int numPlayers, playingPlayer=1;

    protected int coolDown = 0;
    
    protected boolean prepare = true;

    protected int changePlayerTimer = 0;
    
    protected CircularDoublyLinkedList players;

    private Timer timer;

    BufferedImage imgBackground = ImageIO.read(new File("images/SimonBackground.png"));
    BufferedImage imgP1 = ImageIO.read(new File("images/P1.png"));
    BufferedImage imgP2 = ImageIO.read(new File("images/P2.png"));
    BufferedImage imgP3 = ImageIO.read(new File("images/P3.png"));
    BufferedImage imgP4 = ImageIO.read(new File("images/P4.png"));

    public SimonBoard(CircularDoublyLinkedList players ) throws IOException {


        addMouseListener(this);

        timer = new Timer(20,this);

        start();
        
        this.players = players;

        this.numPlayers = players.getSize();

        playingPlayer = 1;


    }

    public void start(){

        random = new Random();
        pattern = new ArrayList<>();
        gameOver = false;
        timer.start();


    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(gameOver){
        	players.getNode(playingPlayer-1).getPlayer().setPoints(round-1);
            if(changePlayerTimer <=200){
                changePlayerTimer++;
            }
            else{
            	
                playingPlayer++;
                
                if(playingPlayer<=numPlayers){
                    resetGame();
                }
                else{ 
       
               		endgame();
                    
                }

            }
        }

        if(coolDown <=100){
            ticks = 0;
            coolDown++;
            changePlayerTimer = 0;
        }

        else{
        	prepare = false;
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


        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imgBackground,0,0,SimonWindow.width,SimonWindow.height,this);
        
        highlightPlayer(g);
        
        if(playingPlayer==numPlayers && gameOver) {
        	g.setColor(new Color(205, 220, 57));
            g.setFont(new Font("Lao Sangam LM", Font.BOLD,25));
            g.drawString("Final score ", 125, 70);
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Lao Sangam LM", Font.PLAIN,20));
        g.drawString(players.getNode(0).getPlayer().getName() + "'s score: " + players.getNode(0).getPlayer().getPoints(), 100,145);
        g.drawString(players.getNode(1).getPlayer().getName() + "'s score: " + players.getNode(1).getPlayer().getPoints(), 100,245);
        
        g.drawImage(players.getNode(0).getPlayer().getSprite(), 30,125,30,30,this);
        g.drawImage(players.getNode(1).getPlayer().getSprite(),30,225,30,30,this);

        if (numPlayers == 3) {
            g.drawImage(players.getNode(2).getPlayer().getSprite(),30,325,30,30,this);
            g.drawString(players.getNode(2).getPlayer().getName() + "'s score: " + players.getNode(2).getPlayer().getPoints(), 100,345);
            
        }

        else if(numPlayers == 4){
            g.drawImage(players.getNode(2).getPlayer().getSprite(),30,325,30,30,this);
            g.drawImage(players.getNode(3).getPlayer().getSprite(),30,425,30,30, this);
            g.drawString(players.getNode(2).getPlayer().getName() + "'s score: " + players.getNode(2).getPlayer().getPoints(), 100,345);
            g.drawString(players.getNode(3).getPlayer().getName() + "'s score: " + players.getNode(3).getPlayer().getPoints(), 100,445);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Lao Sangam LM", Font.BOLD,35));
        g.drawString("Round " + round, 600,150);
        

        if(flashed == 1){
            g.setColor(new Color(231, 44, 187));
        }
        else{
            g.setColor(new Color(139, 28, 113));
        }
        g.fillRoundRect(SimonWindow.width/2,190, 100,100,10,10);

        if (flashed == 2){
            g.setColor(new Color(107, 233, 39));
        }
        else{
            g.setColor(new Color(106, 131, 25));
        }
        g.fillRoundRect(SimonWindow.width/2+120,190, 100,100,10,10);

        if(flashed == 3){
            g.setColor(new Color(48, 241, 247));
        }
        else{
            g.setColor(new Color(28, 136, 139));
        }
        g.fillRoundRect(SimonWindow.width/2+240,190, 100,100,10,10);

        if(flashed==4){
            g.setColor(new Color(255, 144, 41));
        }
        else{
            g.setColor(new Color(141, 80, 24));
        }
        g.fillRoundRect(SimonWindow.width/2,310, 100,100,10,10);

        if(flashed == 5){
            g.setColor(new Color(227, 250, 42));
        }
        else{
            g.setColor(new Color(128, 141, 24));
        }
        g.fillRoundRect(SimonWindow.width/2+120,310, 100,100,10,10);

        if(flashed == 6){
            g.setColor(new Color(141, 40, 237));
        }
        else{
            g.setColor(new Color(77, 22, 129));
        }
        g.fillRoundRect(SimonWindow.width/2+240,310, 100,100,10,10);

        if(gameOver){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,40));
            g.drawString("Game over", 570,475);
        }
        else {
        	g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString(players.getNode(playingPlayer-1).getPlayer().getName()+" is playing", 570,475);
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

                if (mouseX>SimonWindow.width/2 && mouseX<SimonWindow.width/2+100 && mouseY > 190 && mouseY<290){
                    flashed = 1;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;

                }
                else if (mouseX>SimonWindow.width/2 + 120 && mouseX<SimonWindow.width/2+220 && mouseY > 190 && mouseY<290){
                    flashed = 2;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
                else if(mouseX>SimonWindow.width/2 + 240 && mouseX<SimonWindow.width/2+340 && mouseY > 190 && mouseY<290){
                    flashed = 3;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
                else if(mouseX>SimonWindow.width/2 && mouseX<SimonWindow.width/2+100 && mouseY > 310 && mouseY<410){
                    flashed = 4;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
                else if(mouseX>SimonWindow.width/2 +120 && mouseX<SimonWindow.width/2+220 && mouseY > 310 && mouseY<410){
                    flashed = 5;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                    }

                    indexPattern++;
                }
              
                else if(mouseX>SimonWindow.width/2 + 240 && mouseX<SimonWindow.width/2+340 && mouseY >310 && mouseY<410){
                  
                    flashed = 6;
                    ticks=1;
                    clickCounts++;

                    if(flashed!=pattern.get(indexPattern)){
                        gameOver=true;
                        correct = pattern.get(indexPattern);
                        coolDown = 0;
                        
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

    public void endgame(){
        timer.stop();
        SimonLauncher.simonWindow.dispose();
        GameBoardLauncher.window.setVisible(true);

    }
    
    public void resetGame() {
    	coolDown=0;
        ticks = 0;
        flashed = 0;
        pattern.clear();
        gameOver = false;
        reference = 1;
        indexPattern = 0;
        round = 1;
        correct = 0;
        creatingPattern = true;
        prepare = true;
    }
    
    public void highlightPlayer(Graphics g) {
    	switch(playingPlayer) {
    	case 1:
    		g.setColor(players.getNode(0).getPlayer().getColor());
    		g.fillRect(25,120, 400, 40);
    		break;
    	case 2:
    		g.setColor(players.getNode(1).getPlayer().getColor());
    		g.fillRect(25,220, 400, 40);
    		break;
    	case 3:
    		g.setColor(players.getNode(2).getPlayer().getColor());
    		g.fillRect(25,320, 400, 40);
    		break;
    	case 4:
    		g.setColor(players.getNode(3).getPlayer().getColor());
    		g.fillRect(25,420, 400, 40);
    		break;
    	}
    }
    
}
