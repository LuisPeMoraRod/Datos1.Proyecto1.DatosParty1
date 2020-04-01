package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Color;
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

	public ArrayList<Rectangle> columnsArray;
	public int ticks, yMotion, score;
	public Random random;

	public static boolean gameOn;
	public boolean gameOver;
	public boolean crash;

	public boolean createColumn = false;

	public int x;
	public int y;

	public int dy = 1;
	public int[] columnHeights;
	public int columnIndex=0;

	public int contTimer;
	Timer timer;

	public GameBoard(int player) {
		this.player = player;

		sprite = new Bird(player);
		image = sprite.getBird();

		frameWidth = Window.frameWidth;
		frameHeight = Window.frameHeight;

		birdWidth = sprite.birdWidth;
		birdHeight = sprite.birdHeight;

		x = (frameWidth / 3) - (birdWidth / 2);
		y = (frameHeight / 2) - (birdHeight / 2);
		
		columnsArray = new ArrayList<Rectangle>();
		columnHeights=ColumnHeights.getInstance().heights; //Singleton instance

		gameOn = false;
		gameOver = false;

		timer = new Timer(20, this);

		timer.start();

	}

	public void createColumn() {
		int space = 160;
		int width = 90;
		int height=columnHeights[columnIndex];
		Rectangle rect1 = new Rectangle(frameWidth, 0, width, height);
		Rectangle rect2=new Rectangle(frameWidth,height+space,width,frameHeight-(height+space));
		columnsArray.add(rect1);
		columnsArray.add(rect2);
		columnIndex++;
		if (columnIndex>99) {
			columnIndex=0;
		}
	}

	/**
	 * Public method that makes the "bird" jump. Decreases the dy variable so that the image moves up.
	 */
	public void jump() {
		if (!gameOver) {
			if (dy > 0) {
				dy = 0;
			}
			dy -= 15;
		}
	}


/**
 * Public method that paints a rectangle column in the canvas
 * @param g : Graphics
 * @param column : Rectangle
 */
	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.black);
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 10;
		if (gameOn) {
			contTimer++;
			if (contTimer == 100) {
				createColumn();
				contTimer = 0;
			}
			dy += 2;
			y += dy;

			for (int i = 0; i < columnsArray.size(); i++) {
				Rectangle column = columnsArray.get(i);

				column.x -= speed;
				if (column.x <= 20) {
					columnsArray.remove(i);
				}

			}
			if ((y + birdHeight) <= 0 || y >= (frameHeight)) {
				gameOver = true;
				System.out.println("Game Over");
				repaint();
				timer.stop();
			}
			
			for (Rectangle column: columnsArray) {
				if (column.intersects(x, y, birdWidth, birdHeight)) {
					gameOver=true;
					crash=true;
				}
			}
			if (crash==true) {
				x-=speed;
			}
		}

		repaint();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, null);
		for (Rectangle column : columnsArray) {
			paintColumn(g, column);
		}
	}

}
