package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	int player;
	public Bird sprite;
	int frameWidth,frameHeight,birdWidth,birdHeight;
	BufferedImage image;
	public GameBoard(int player) {
		this.player=player;
		sprite=new Bird(player);
		frameWidth=Window.frameWidth;
		frameHeight=Window.frameHeight;
		image=sprite.getBird();
		birdWidth=sprite.birdWidth;
		birdHeight=sprite.birdHeight;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, (frameWidth/2)-(birdWidth/2), (frameHeight/2)-(birdHeight/2), null);
	}
}
