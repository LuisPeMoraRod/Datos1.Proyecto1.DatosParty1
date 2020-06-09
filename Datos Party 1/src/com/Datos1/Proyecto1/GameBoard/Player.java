package com.Datos1.Proyecto1.GameBoard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends Component {
	/**
	 * Public class. 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 28/5/2020
	 */
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int coins;
	private int stars;
	private int minigamePoints;
	private Node node;
	private String path;
	private int id;
	private BufferedImage sprite;
	private int spriteWidth;
	private int spriteHeight;
	private Node pointer;
	private boolean inTurn;
	private boolean clockWise;

	public Player(String name, int id) {
		this.name = name;
		this.id = id;
		setPath(id);
		spriteWidth = 20;
		spriteHeight = 20;
		pointer=GameBoard.mainLinkedList.start;
		clockWise=true;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getCoins() {
		return this.coins;
	}
	
	public void setCoins(int coins) {
		this.coins=coins;
	}
	
	/**
	 * Increments the amount of coins of a player
	 * @param newCoins
	 */
	public void incremetCoins(int newCoins) {
		this.coins+=newCoins;
	}
	
	public void setPoints(int points) {
		this.minigamePoints=points;
	}
	public int getPoints() {
		return this.minigamePoints;
	}
	/**
	 * Getter of the flag that indicates the direction of the player's movement
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
	 * @return pointer : Node
	 */
	public Node getPointer() {
		return this.pointer;
	}
	
	/**
	 * Setter of the player's pointer to the node where it's located in the list
	 */
	public void setPointer (Node pointer) {
		this.pointer= pointer;
	}
	
	/**
	 * Getter of the player's boolean value that indicates whether is its turn or not
	 * @return inTurn : boolean
	 */
	public boolean getInTurn() {
		return this.inTurn;
	}
	
	/**
	 * Setter of the player's boolean value that indicates whether is its turn or not
	 */
	public void setInTurn(boolean inTurn){
		this.inTurn=inTurn;
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

	public String getName(){return this.name;}

}
