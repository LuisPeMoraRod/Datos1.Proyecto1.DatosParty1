package com.Datos1.Proyecto1.FlappyBird;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener {
	/**
	 * Public class that creates the canvas where the game develops
	 * @author Luis Pedro Morales Rodriguez
	 * @version 4/1/2020
	 */
	private static final long serialVersionUID = 1L;
	public int player;
	public Bird sprite;
	int frameWidth, frameHeight, birdWidth, birdHeight;
	BufferedImage image;
	BufferedImage wallpaper;

	public ArrayList<Rectangle> columnsArray;
	public int ticks, yMotion, score;
	public Random random;

	public boolean gameOn;
	public boolean gameOver;
	public boolean crash;

	public boolean createColumn = false;

	public int x;
	public int y;

	public int dy = 1;
	public int[] columnHeights;
	public int columnIndex = 0;

	public int contTimer;
	Timer timer;

	public GameBoard(int player) {
		this.player = player;

		sprite = new Bird(player);
		image = sprite.getBird();
		wallpaper = getWallpaper();

		frameWidth = Window.frameWidth;
		frameHeight = Window.frameHeight;

		birdWidth = sprite.birdWidth;
		birdHeight = sprite.birdHeight;

		x = ((frameWidth / 3) - (birdWidth / 2))/10;
		x*=10;
		System.out.println(x);
		y = (frameHeight / 2) - (birdHeight / 2);

		columnsArray = new ArrayList<Rectangle>();
		columnHeights = ColumnHeights.getInstance().heights; // Singleton instance

		gameOn = false;
		gameOver = false;

		timer = new Timer(20, this);
		timer.start();

	}

	/**
	 * Public method that creates two columns with the shape of pipelines and adds them to the columnsArray
	 */
	public void createColumn() {
		int space = (int) (Window.frameHeight/2.8);
		int width = (int)(Window.frameWidth*0.15)/10;
		width*=10;
		int height = columnHeights[columnIndex];
		Rectangle tube1 = new Rectangle(frameWidth, 0, width, height);
		Rectangle border1 = new Rectangle(tube1.x - 8, tube1.y + height - 10, width + 16, 10);
		Rectangle tube2 = new Rectangle(frameWidth, height + space, width, frameHeight - (height + space));
		Rectangle border2 = new Rectangle(tube2.x - 8, tube2.y, width + 16, 10);

		columnsArray.add(tube1);
		columnsArray.add(border1);
		columnsArray.add(tube2);
		columnsArray.add(border2);
		columnIndex++;
		if (columnIndex > 99) {
			columnIndex = 0;
		}
	}

	/**
	 * Public method that makes the "bird" jump. Decreases the dy variable so that
	 * the image moves up.
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
	 * 
	 * @param g      : Graphics
	 * @param column : Rectangle
	 */
	public void paintColumn(Graphics g, Rectangle column) {
		Color green = new Color(56, 148, 78);
		Graphics2D g2 = (Graphics2D) g;
		Stroke stroke1 = new BasicStroke(2f);
		g2.setColor(Color.black);
		g2.setStroke(stroke1);
		g2.drawRect(column.x, column.y, column.width, column.height); //Draws black border
		g2.setColor(green);
		g2.fillRect(column.x + 1, column.y + 1, column.width - 2, column.height - 2);

	}

	/**
	 * Overrided method that handles the events of the game. It is called in every iteration of the timer object.
	 * {@link ActionEvent}
	 */
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

			for (int i = 0; i < columnsArray.size(); i++) { //Moves the rectangles to the left
				Rectangle column = columnsArray.get(i);
				column.x -= speed;
				if (column.x + column.width + 8 <= 0) {//Removes the rectangle from the array if it gets to the left side of the canvas
					columnsArray.remove(i);
				}
			}

			if ((y + birdHeight) <= 0 || y >= (frameHeight)) {//Stops the game when the bird falls down or reaches the top
				gameOver = true;
				System.out.println("Game Over");
				repaint();
				timer.stop();
			}

			for (Rectangle column : columnsArray) {
				if (column.intersects(x, y, birdWidth, birdHeight)) { //Checks if the bird object intersects any of the rectangles
					gameOver = true;
					crash = true;
					if (column.x>x) {
						speed+=4;
					}
				}
			}
			if (crash == true) {
				x -= speed; //Bird falls moving to the left when it crashes
				if (player == 1 && MainFlappyBird.players == 1) {
					sprite.path = "images/crashedPanda.png"; //Changes sprite
					image = sprite.getBird();
				}
			}
			for (int i = 0; i < columnsArray.size(); i += 4) { //Increases score if the bird surpasses the columns
				Rectangle column = columnsArray.get(i);
				if (column.x + column.width == x && !gameOver) {
					score++;
				}

			}
		}
		repaint();
	}

	/**
	 * Overrided method that paints all the objects in the canvas
	 * {@link Graphics}
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(wallpaper, 0, 0, null);
		g.drawImage(image, x, y, null);
		for (Rectangle column : columnsArray) {
			paintColumn(g, column);
		}
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 25));
		if (!gameOn) {
			if (player == 1) {
				g.drawString("Tap w to start", 160, 50);
			}
			if (player == 2) {
				g.drawString("Tap space bar to start", 100, 50);
			}
			if (player == 3) {
				g.drawString("Tap p to start", 160, 50);
			}
			if (player == 4) {
				g.drawString("Tap up key to start", 120, 50);
			}

		} else {
			g.drawString("Score: " + String.valueOf(score), (int) (frameWidth*0.4), 50);
		}

	}

	/**
	 * Returns image 
	 * @return BufferedImage
	 */
	public BufferedImage getWallpaper() {
		try {
			String path = "images/WallpaperFB.jpg";
			wallpaper = ImageIO.read(new File(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return wallpaper;
	}

}
