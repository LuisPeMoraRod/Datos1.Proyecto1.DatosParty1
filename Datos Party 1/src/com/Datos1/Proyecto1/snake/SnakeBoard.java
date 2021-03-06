package com.Datos1.Proyecto1.snake;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.GameBoardLauncher;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * SnakeBoard is the container that draws all the elements that controls the game and it also sets the round logic and
 * collision logic
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class SnakeBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage imgBackground = ImageIO.read(new File("images/SnakeBackground.jpg"));
	private BufferedImage snakeLogo = ImageIO.read(new File("images/snakeLogo.png"));
	private BufferedImage snakeCL = ImageIO.read(new File("images/snakeCL.png"));
	private BufferedImage snakeCR = ImageIO.read(new File("images/snakeCR.png"));
	private BufferedImage snakeInstructions = ImageIO.read(new File("images/snakeInstructions.png"));
	private BufferedImage enterPress = ImageIO.read(new File("images/enterPress.png"));
	private BufferedImage spacePress = ImageIO.read(new File("images/spacePress.png"));

	private SnakeHead snakeHead;

	Color snakeColor;

	public BufferedImage headImg;

	public int fx1, fy1;

	public Food f1;

	public int score;

	private int dx, dy;

	protected static int speed = 1;

	private int accelerator = 0;

	private int initialTimer = 0;

	private int endGameTimer;

	Random random = new Random();

	Rectangle2D food1;

	SnakeTail collisionDetector;

	ArrayList<SnakeTail> snakeTail;

	private boolean gameOver = false;

	private int numPlayers;

	private int playingPlayer;

	protected CircularDoublyLinkedList players;

	public SnakeBoard(CircularDoublyLinkedList players) throws IOException {

		snakeHead = new SnakeHead(80, 80);

		fx1 = random.nextInt(980);
		fy1 = random.nextInt(580);

		f1 = new Food();

		score = 0;

		snakeTail = new ArrayList<>();

		collisionDetector = new SnakeTail();
		collisionDetector.setPosition(snakeHead.getHeadX(), snakeHead.getHeadY());

		snakeTail.add(collisionDetector);

		this.players = players;

		this.numPlayers = players.getSize();

		playingPlayer = 0;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(imgBackground, 0, 0, 1000, 600, this);

		/*
		Draws the elements that are part of the snake cover
		 */

		if (SnakeEvent.startCover) {

			g2.drawImage(snakeLogo, SnakeWindow.width / 2 - 200, SnakeWindow.height / 2 - 100, 400, 200, this);
			g2.drawImage(enterPress, SnakeWindow.width / 2 - 132, SnakeWindow.height / 2 + 250, 264, 46, this);

		}

		/*
		Draws the elements that are part of the snake instructions screen
		 */

		else if (SnakeEvent.instructions) {

			g2.drawImage(snakeCL, 20, 20, 168, 114, this);
			g2.drawImage(snakeCR, SnakeWindow.width - 188, SnakeWindow.height - 124, 168, 104, this);
			g2.drawImage(snakeInstructions, SnakeWindow.width / 2 - 247, SnakeWindow.height / 2 - 111, 494, 222, this);
			g2.drawImage(spacePress, SnakeWindow.width / 2 - 142, SnakeWindow.height / 2 + 250, 284, 46, this);

			g2.setColor(new Color(205, 220, 57));
			g2.setFont(new Font("Eurostile", Font.BOLD, 15));
			g2.drawString("Left player controls", 25, 145);
			g2.drawString("Right player controls", SnakeWindow.width - 185, 450);

		}

		/*
		Draws the food and the snake and also contains the conditions of the beginning and end of a round
		 */

		else {

			if (playingPlayer < numPlayers) {
				stageRound(g2);

				if (gameOver) {
					if (endGameTimer <= 50) {
						endGameTimer++;
					} else {
						resetGame();
					}
				}
			}

			else {

				if (endGameTimer <= 100) {
					giveFinalResults(g2);
					endGameTimer++;
				} else {
					int finalScore;
					for (int i = 0; i < players.getSize(); i++) {
						finalScore = players.getNode(i).getPlayer().getPoints();
						players.getNode(i).getPlayer().incrementCoins(finalScore);
					}
					for (int i = 0; i < players.getSize(); i++) {
						players.getNode(i).getPlayer().setPoints(0);
					}
					GameBoardLauncher.window.setVisible(true);
					SnakeLauncher.snakeWindow.dispose();
				}

			}

		}

	}

	/**
	 * Checks is there is a change of the direction flags of the SnakeWent class and sets the parameter that are
	 * necessary for the snake to move and updates the state of the snake
	 */

	public void updateSnake() {

		snakeHead.moveSnakeHead();

		int snakeSize = 20;
		if (SnakeEvent.up && dy == 0) {
			dy = -snakeSize;
			dx = 0;
		}

		else if (SnakeEvent.down && dy == 0) {
			dy = snakeSize;
			dx = 0;
		}

		else if (SnakeEvent.left && dx == 0) {
			dx = -snakeSize;
			dy = 0;
		}

		else if (SnakeEvent.right && dx == 0) {
			dx = snakeSize;
			dy = 0;
		}

		if (dx != 0 || dy != 0) {

			for (int i = snakeTail.size() - 1; i > 0; i--) {

				snakeTail.get(i).setPosition(snakeTail.get(i - 1).getTailX(), snakeTail.get(i - 1).getTailY());
			}

			collisionDetector.moveTail(dx, dy);
		}

		if (collisionDetector.getTailX() < 0) {
			collisionDetector.setTailX(1000);
		}

		if (collisionDetector.getTailY() < 0) {
			collisionDetector.setTailY(600);
		}

		if (collisionDetector.getTailX() > 1000) {
			collisionDetector.setTailX(0);
		}

		if (collisionDetector.getTailY() > 600) {
			collisionDetector.setTailY(0);
		}

	}

	/**
	 * Detects when the head of the snake collides with a Food object
	 */

	public void detectFoodGrab() {
		if (snakeTail.get(0).getTail().intersects(food1)) {
			fx1 = f1.setCoordX();
			fy1 = f1.setCoordY();
			SnakeTail t = new SnakeTail();
			t.setPosition(collisionDetector.getTailX() + ((snakeTail.size() + 1) * 20), collisionDetector.getTailY());
			snakeTail.add(t);
			score++;
			accelerator++;

			if (accelerator == 10) {
				accelerator = 0;
				speed = speed + 5;
			}
		}

	}

	/**
	 * Detects if the snake head collides with one of tje bounds of the window and
	 * sets the flag that ends the round
	 */

	public void detectColliion() {
		for (SnakeTail t : snakeTail) {
			if (t.isCollision(collisionDetector) || collisionDetector.getTailX() == 0
					|| collisionDetector.getTailX() == 980 || collisionDetector.getTailY() == 0
					|| collisionDetector.getTailY() == 580) {
				gameOver = true;
				setScore();
			}
		}
	}


	public void stageRound(Graphics2D g) {
		g.setColor(new Color(205, 220, 57));

		food1 = f1.getFood(fx1, fy1);
		g.fill(food1);

		if (initialTimer <= 50) {
			initialTimer++;
		}

		else {

			if (!gameOver) {
				updateSnake();
			} else {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Lao Sangam LM", Font.BOLD, 40));
				g.drawString("Game over", 400, 280);
				g.setColor(new Color(173, 20, 87));
				g.setFont(new Font("Lao Sangam LM", Font.BOLD, 30));
				g.drawString("Score: " + score, 450, 320);
			}

			detectColliion();
			detectFoodGrab();

			setSnakeColor(players.getNode(playingPlayer).getPlayer().getId());
			g.setColor(snakeColor);
			for (SnakeTail t : snakeTail) {
				t.render(g);
			}

			g.drawImage(headImg, snakeHead.getHeadX(), snakeHead.getHeadY(), 20, 20, this);
		}

	}

	/**
	 * Resets the game to its initial values to start a new round
	 */

	public void resetGame() {
		snakeHead.setHeadPosition(80, 80);

		fx1 = random.nextInt(980);
		fy1 = random.nextInt(580);

		f1 = new Food();

		score = 0;

		snakeTail.clear();

		collisionDetector = new SnakeTail();
		collisionDetector.setPosition(snakeHead.getHeadX(), snakeHead.getHeadY());

		snakeTail.add(collisionDetector);

		playingPlayer++;

		initialTimer = 0;
		endGameTimer = 0;

		gameOver = false;

		speed = 1;

		accelerator = 0;

		SnakeEvent.left = false;
		SnakeEvent.up = false;
		SnakeEvent.down = false;
		SnakeEvent.right = true;
	}

	public void setSnakeColor(int id) {
		switch (id) {
		case 1:
			this.snakeColor = new Color(134, 154, 164);
			break;

		case 2:
			this.snakeColor = new Color(207, 57, 34);
			break;

		case 3:
			this.snakeColor = new Color(43, 151, 175);
			break;

		case 4:
			this.snakeColor = new Color(124, 60, 171);
			break;
		}
	}

	public void setScore() {
		this.players.getNode(playingPlayer).getPlayer().setPoints(score);
	}

	public void giveFinalResults(Graphics2D g2) {
		g2.setColor(new Color(173, 20, 87));
		g2.setFont(new Font("Lao Sangam LM", Font.BOLD, 50));
		g2.drawString("Final score", SnakeWindow.width / 2 - 150, 200);

		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Lao Sangam LM", Font.BOLD, 25));

		switch (numPlayers) {

		case 2:

			g2.drawString(players.getNode(0).getPlayer().getName() + ": " + players.getNode(0).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 300);
			g2.drawString(players.getNode(1).getPlayer().getName() + ": " + players.getNode(1).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 350);
			break;
		case 3:
			g2.drawString(players.getNode(0).getPlayer().getName() + ": " + players.getNode(0).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 300);
			g2.drawString(players.getNode(1).getPlayer().getName() + ": " + players.getNode(1).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 350);
			g2.drawString(players.getNode(2).getPlayer().getName() + ": " + players.getNode(2).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 400);

			break;
		case 4:
			g2.drawString(players.getNode(0).getPlayer().getName() + ": " + players.getNode(0).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 300);
			g2.drawString(players.getNode(1).getPlayer().getName() + ": " + players.getNode(1).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 350);
			g2.drawString(players.getNode(2).getPlayer().getName() + ": " + players.getNode(2).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 400);
			g2.drawString(players.getNode(3).getPlayer().getName() + ": " + players.getNode(3).getPlayer().getPoints(),
					SnakeWindow.width / 2 - 75, 450);
			break;

		}
		
		

	}

}
