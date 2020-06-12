package com.Datos1.Proyecto1.pong;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.GameBoardLauncher;
import com.Datos1.Proyecto1.snake.SnakeWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PongBoard extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Ball ball = new Ball(490,290);
    PongPallets pallet1 = new PongPallets(20,275);
    PongPallets pallet2 = new PongPallets(960,275);

    BufferedImage imgBackground = ImageIO.read(new File("images/bgPong.png"));
    BufferedImage pongLogo = ImageIO.read(new File("images/pongLogo.png"));
    BufferedImage leftControls = ImageIO.read(new File("images/leftControls.png"));
    BufferedImage rightControls = ImageIO.read(new File("images/rightControls.png"));
    BufferedImage pongRules = ImageIO.read(new File("images/pongRules.png"));
    private BufferedImage enterPress = ImageIO.read(new File("images/enterPress.png"));
    private BufferedImage spacePress = ImageIO.read(new File("images/spacePress.png"));

    public PongScore pongScore;
    public int scoreP1, scoreP2;
    public int numPlayers;

    public int initialTimer;

    public int endTimer;

    protected int round;

    protected boolean endRound;
    
    protected int winner1, winner2;
    
    CircularDoublyLinkedList players;

    public PongBoard(CircularDoublyLinkedList players) throws IOException {

        pongScore = new PongScore();
        scoreP1 = 0;
        scoreP2 = 0;
        
        initialTimer = 0;

        endTimer = 0;

        endRound = false;

        round = 1;
        
        this.players = players;
        
        this.numPlayers = players.getSize();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBackground,0,0,1000,600,this);

        if(PalletEvent.cover){

            g2.drawImage(pongLogo, PongWindow.width/2-200,PongWindow.height/2 -75,400,150,this);
            g2.drawImage(leftControls, 50,PongWindow.height/2-65,50,130,this);
            g2.drawImage(rightControls, 905,PongWindow.height/2-55,45,110,this);
            g2.drawImage(enterPress, SnakeWindow.width/2-132,SnakeWindow.height/2+250,264,46,this);
        }

        else if(PalletEvent.instructions){
            g2.drawImage(leftControls, 50,PongWindow.height/2-65,50,130,this);
            g2.drawImage(rightControls, 905,PongWindow.height/2-55,45,110,this);
            g2.drawImage(pongRules, PongWindow.width/2-300,PongWindow.height/2-90,600,180,this);
            g2.drawImage(spacePress,SnakeWindow.width/2-142,SnakeWindow.height/2+250,284,46,this);
        }

        else{

            if(numPlayers==2){
                twoPlayersLogic(g2);
                
            }

            else if(numPlayers==3){
                threePlayersLogic(g2);

            }
            else {
            	fourPlayersLogic(g2);
            }


        }



    }

    public void drawElement(Graphics2D g){

        g.fill(ball.getBall());
    }

    public void updateElement(){
        ball.moveBall(getBounds(), collision(pallet1.getPallet()), collision(pallet2.getPallet()),scoreP1,scoreP2);
        pallet1.movePallet1(getBounds());
        pallet2.movePallet2(getBounds());
        setScore();
    }

    private boolean collision(Rectangle2D r){
        return ball.getBall().intersects(r);
    }

    private void setScore(){
        scoreP1 = pongScore.setScoreP1(ball);
        scoreP2 = pongScore.setScoreP2(ball);
    }

    public void reset(){
        ball = new Ball(490,290);
        pallet1 = new PongPallets(20,275);
        pallet2 = new PongPallets(960,275);
        pongScore.resetScore();
        scoreP1 = pongScore.setScoreP1(ball);
        scoreP2 = pongScore.setScoreP2(ball);
        initialTimer = 0;
        endTimer = 0;
        endRound = false;
        round++;
    }

    public void setRound(Graphics2D g2){
        g2.setColor(new Color(205, 220, 57));
        drawElement(g2);

        if(initialTimer<=500){
            initialTimer++;
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Lao Sangam LM", Font.BOLD,40));
            g2.drawString("Ready?", 430,280);
        }

        else{
            updateElement();
        }

        g2.setColor(Color.WHITE);
        g2.fill(pallet1.getPallet());
        g2.fill(pallet2.getPallet());
        g2.drawString(String.valueOf(scoreP1),250,50);
        g2.drawString(String.valueOf(scoreP2),750,50);

        if(scoreP2 == 5 || scoreP1 == 5){
            g2.setFont(new Font("Lao Sangam LM", Font.BOLD,40));
            g2.drawString("Game over", 400,280);
            endRound = true;

        }
    }

    public void closeGame(){

        GameBoardLauncher.window.setVisible(true);
        PongLauncher.pongWindow.dispose();
    }
    
    public void twoPlayersLogic(Graphics2D g2) {
    	if(!endRound)
    		{
    		setRound(g2);
    		g2.setFont(new Font("Lao Sangam LM", Font.BOLD,20));
        	g2.drawString(players.getNode(0).getPlayer().getName(), 10,50);
        	g2.drawString(players.getNode(1).getPlayer().getName(), 510,50);
        	
    		}
    	else{
        	players.getNode(0).getPlayer().setPoints(scoreP1);
        	players.getNode(1).getPlayer().setPoints(scoreP2);
        	ball = new Ball(490,290);
            pallet1 = new PongPallets(20,275);
            pallet2 = new PongPallets(960,275);
            pongScore.resetScore();
        	
        	if(endTimer<=1000){
                endTimer++;
                giveFinalResults(g2);
            }
        	else {
        		
        		closeGame();
        	}

        }
    }
    

    public void threePlayersLogic(Graphics2D g2){
        if(round<=3){
            setRound(g2);
            
            g2.setFont(new Font("Lao Sangam LM", Font.BOLD,20));
            
            switch(round) {
            case 1:
            	g2.drawString(players.getNode(0).getPlayer().getName(), 10,50);
            	g2.drawString(players.getNode(1).getPlayer().getName(), 510,50);
            	break;
            case 2:
            	g2.drawString(players.getNode(0).getPlayer().getName(), 10,50);
            	g2.drawString(players.getNode(2).getPlayer().getName(), 510,50);
            	break;
            case 3:
            	g2.drawString(players.getNode(1).getPlayer().getName(), 10,50);
            	g2.drawString(players.getNode(2).getPlayer().getName(), 510,50);
            	break;
            }
            if(endRound){
                if(endTimer<=1000){
                    endTimer++;
                }
                else {
                	roundScores3P();
                    reset();
                }
            }
        }
        else{
        	if(endTimer<=1000){
                endTimer++;
                giveFinalResults(g2);
            }
        	else {
        		closeGame();
        	}
            
        }
    }
    
    public void fourPlayersLogic(Graphics2D g2){
        if(round<=3){
            setRound(g2);
            
            g2.setFont(new Font("Lao Sangam LM", Font.BOLD,20));
            
            switch(round) {
            case 1:
            	g2.drawString(players.getNode(0).getPlayer().getName(), 10,50);
            	g2.drawString(players.getNode(1).getPlayer().getName(), 510,50);
            	break;
            case 2:
            	g2.drawString(players.getNode(2).getPlayer().getName(), 10,50);
            	g2.drawString(players.getNode(3).getPlayer().getName(), 510,50);
            	break;
            case 3:
            	if(winner1==1) {
            		g2.drawString(players.getNode(0).getPlayer().getName(), 10,50);
            	}
            	else {
            		g2.drawString(players.getNode(1).getPlayer().getName(), 10,50);
            	}
            	
            	if(winner2==3) {
            		g2.drawString(players.getNode(2).getPlayer().getName(), 510,50);
            	}
            	else {
            		g2.drawString(players.getNode(3).getPlayer().getName(), 510,50);
            	}
            	
            	break;
            }
            if(endRound){
                if(endTimer<=1000){
                    endTimer++;
                }
                else {
                	roundScores4P();
                	setWinners();
                    reset();
                }
            }
        }
        else{
        	if(endTimer<=1000){
                endTimer++;
                giveFinalResults(g2);
            }
        	else {
        		closeGame();

        	}
            
        }
    }
    
    public void setScoreP1(int score) {
    	int actualPoints = players.getNode(0).getPlayer().getPoints();
    	players.getNode(0).getPlayer().setPoints(actualPoints+score);
    }
    
    public void setScoreP2(int score) {
    	int actualPoints = players.getNode(1).getPlayer().getPoints();
    	players.getNode(1).getPlayer().setPoints(actualPoints+score);
    }
    
    public void setScoreP3(int score) {
    	int actualPoints = players.getNode(2).getPlayer().getPoints();
    	players.getNode(2).getPlayer().setPoints(actualPoints+score);
    }
    
    public void setScoreP4(int score) {
    	int actualPoints = players.getNode(3).getPlayer().getPoints();
    	players.getNode(3).getPlayer().setPoints(actualPoints+score);
    }
    
    public void giveFinalResults(Graphics2D g2) {
    	g2.setColor(new Color(173, 20, 87));
    	g2.setFont(new Font("Lao Sangam LM", Font.BOLD,50));
        g2.drawString("Final score", SnakeWindow.width/2-150, 200);
        
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Lao Sangam LM", Font.BOLD,25));
        
        switch(numPlayers) {
        
        case 2:
        	 g2.drawString(players.getNode(0).getPlayer().getName() +": " + players.getNode(0).getPlayer().getPoints(), SnakeWindow.width/2-75, 300);
        	 g2.drawString(players.getNode(1).getPlayer().getName() +": " + players.getNode(1).getPlayer().getPoints(), SnakeWindow.width/2-75, 350);
        	break;
        case 3:
        	g2.drawString(players.getNode(0).getPlayer().getName() +": " + players.getNode(0).getPlayer().getPoints(), SnakeWindow.width/2-75, 300);
        	g2.drawString(players.getNode(1).getPlayer().getName() +": " + players.getNode(1).getPlayer().getPoints(), SnakeWindow.width/2-75, 350);
        	g2.drawString(players.getNode(2).getPlayer().getName() +": " + players.getNode(2).getPlayer().getPoints(), SnakeWindow.width/2-75, 400);
    
        	break;
        case 4:
        	g2.drawString(players.getNode(0).getPlayer().getName() +": " + players.getNode(0).getPlayer().getPoints(), SnakeWindow.width/2-75, 300);
       	    g2.drawString(players.getNode(1).getPlayer().getName() +": " + players.getNode(1).getPlayer().getPoints(), SnakeWindow.width/2-75, 350);
       	    g2.drawString(players.getNode(2).getPlayer().getName() +": " + players.getNode(2).getPlayer().getPoints(), SnakeWindow.width/2-75, 400);
   	        g2.drawString(players.getNode(3).getPlayer().getName() +": " + players.getNode(3).getPlayer().getPoints(), SnakeWindow.width/2-75, 450);
        	break;
        	
        }  
    }
    
    public void roundScores3P() {
    	
    	switch(round) {
    	
    	case 1:
    		setScoreP1(scoreP1);
    		setScoreP2(scoreP2);
    		break;
    	
    	case 2:
    		setScoreP1(scoreP1);
    		setScoreP3(scoreP2);
    		break;
    		
    	case 3:
    		setScoreP2(scoreP1);
    		setScoreP3(scoreP2);
    		break;
    	}
    
    }
    
    public void roundScores4P() {
    	
    	switch(round) {
    	
    	case 1:
    		setScoreP1(scoreP1);
    		setScoreP2(scoreP2);
    		break;
    	
    	case 2:
    		setScoreP3(scoreP1);
    		setScoreP4(scoreP2);
    		break;
    		
    	case 3:
    		
    		if(winner1==1) {
    			setScoreP1(scoreP1);
    		}
    		else {
    			setScoreP2(scoreP1);
    		}
    		if(winner2==3) {
    			setScoreP3(scoreP2);
    		}
    		else {
    			setScoreP4(scoreP2);
    		}
    		
    		break;
    	}
    
    }
    
    public void setWinners() {
    	switch(round) {
    	case 1:
    		if(scoreP1>scoreP2) {
    			winner1 = 1;
    		}
    		else {
    			winner1 = 2;
    		}
    		break;
    	case 2:
    		if(scoreP1>scoreP2) {
    			winner2 = 3;
    		}
    		else {
    			winner2 = 3;
    		}
    		break;
    	}
    }

}
