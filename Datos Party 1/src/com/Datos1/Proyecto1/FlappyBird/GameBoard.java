package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int player;
	public Bird sprite;
	int frameWidth, frameHeight, birdWidth, birdHeight;
	BufferedImage image;

	public ArrayList<Rectangle> columns;
	public int ticks, yMotion, score;
	public Random rand;

	public boolean gameOn;
	public boolean gameOver;
	
	public  int x;
	public  int y;

	public int dy = 1;

	public GameBoard(int player) {
		this.player = player;

		sprite = new Bird(player);
		image = sprite.getBird();

		frameWidth = Window.frameWidth;
		frameHeight = Window.frameHeight;

		birdWidth = sprite.birdWidth;
		birdHeight = sprite.birdHeight;
		
		x=(frameWidth / 2) - (birdWidth / 2);
		y=(frameHeight / 2) - (birdHeight / 2);

		gameOn = false;
		gameOver = false;

		Timer timer = new Timer(20, this);

		timer.start();
	}

	public void jump() {
		if (!gameOver) {
			if (dy > 0)
			{
				dy = 0;
			}
			dy -=15;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (gameOn) {
			dy += 2;
			y+=dy;
		}
		repaint();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,x , y, null);

	}

}
