package com.Datos1.Proyecto1.GameBoard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Component {
	/**
	 * Public class.
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 28/5/2020
	 */

	private static final long serialVersionUID = 1L;
	private String name;
	private int coins;// coins earned along the whole game
	private int stars;
	private int minigamePoints; // points earned in an individual minigame match
	private String path;
	private int id;
	private BufferedImage sprite;
	private int spriteWidth;
	private int spriteHeight;
	private Node pointer;
	private boolean inTurn;
	private boolean clockWise;
	private Color playerColor;

	public Player(String name, int id) {
		this.name = name;
		this.id = id;
		setPath(id);
		spriteWidth = 20;
		spriteHeight = 20;
		pointer = GameBoard.mainLinkedList.start;
		clockWise = true;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get coins earned along the whole game
	 * @return coins : int 
	 */
	public int getCoins() {
		return this.coins;
	}

	/**
	 * Set coins earned along the whole game
	 * @param coins
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}

	/**
	 * Increments the amount of coins of a player
	 * 
	 * @param newCoins
	 */
	public void incrementCoins(int newCoins) {
		this.coins += newCoins;
	}

	/**
	 * sets points earned in an individual minigame match
	 * @param points
	 */
	public void setPoints(int points) {
		this.minigamePoints = points;
	}

	/**
	 * Gets points earned in an individual minigame match
	 * 
	 * @return minigamePoints
	 */
	public int getPoints() {
		return this.minigamePoints;
	}

	/**
	 * Increments points earned in an individual minigame match
	 * @param newPoints
	 */
	public void incrementPoints(int newPoints) {
		this.minigamePoints += newPoints;
	}

	/**
	 * Getter of the flag that indicates the direction of the player's movement
	 * 
	 * @return left : boolen
	 */
	public boolean getClockWise() {
		return this.clockWise;
	}

	/**
	 * Setter of the flag that indicates the direction of the player's movement
	 */
	public void setClockWise(boolean clockWise) {
		this.clockWise = clockWise;
	}

	/**
	 * Getter of the player's pointer to the node where it's located in the list
	 * 
	 * @return pointer : Node
	 */
	public Node getPointer() {
		return this.pointer;
	}

	/**
	 * Setter of the player's pointer to the node where it's located in the list
	 */
	public void setPointer(Node pointer) {
		this.pointer = pointer;
	}

	/**
	 * Getter of the player's boolean value that indicates whether is its turn or
	 * not
	 * 
	 * @return inTurn : boolean
	 */
	public boolean getInTurn() {
		return this.inTurn;
	}

	/**
	 * Setter of the player's boolean value that indicates whether is its turn or
	 * not
	 */
	public void setInTurn(boolean inTurn) {
		this.inTurn = inTurn;
	}

	/**
	 * Public method that sets the path of the sprite depending on which player is
	 * it going to be the Bird object
	 * 
	 * @param playerId : int
	 */
	public void setPath(int playerId) {
		if (playerId == 1) {
			path = "images/player1.png";
		}
		if (playerId == 2) {
			path = "images/player2.png";
		}
		if (playerId == 3) {
			path = "images/player3.png";
		}
		if (playerId == 4) {
			path = "images/player4.png";
		}
	}

	/**
	 * Overrided method. Sets the dimension of the sprite
	 */
	@Override
	public Dimension getPreferredSize() {
		if (sprite == null) {
			return new Dimension(40, 40);
		} else {

			return new Dimension(spriteWidth, spriteHeight);

		}
	}

	/**
	 * Public method that reads a file and assigns it to a BufferdImage object
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage getSprite() {
		try {
			sprite = ImageIO.read(new File(path));
			spriteWidth = sprite.getWidth();
			spriteHeight = sprite.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sprite;
	}

	public String getName() {
		return this.name;
	}
	
	public Color getColor() {
		
		switch(id) {
		
		case 1: 
			playerColor = new Color(184, 188, 198,100);
			break;
		
		case 2:
			playerColor = new Color(229, 102, 139,100);
			break;
			
		case 3:
			playerColor = new Color(105, 188, 221,100);
			break;
		case 4:
			playerColor = new Color(176, 128, 228,100);
		}
		
		return playerColor;
		
	}

}
