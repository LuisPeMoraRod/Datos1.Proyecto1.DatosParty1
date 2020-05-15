package com.Datos1.Proyecto1.GameBoard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Datos1.Proyecto1.FlappyBird.MainFlappyBird;

public class Player extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int coins;
	private int stars;
	private Node node;
	private String path;
	private int id;
	private BufferedImage sprite;
	private int spriteWidth;
	private int spriteHeight;
	private Node pointer;

	public Player(String name, int id) {
		this.name = name;
		this.id = id;
		setPath(id);
		spriteWidth = 20;
		spriteHeight = 20;
		pointer=GameBoard.mainLinkedList.start;
		pointer.setHasPointer(true);
		
	}

	/**
	 * Public method that sets the path of the sprite depending on which player is
	 * it going to be the Bird object
	 * 
	 * @param playerId : int
	 */
	public void setPath(int playerId) {
		if (playerId == 1) {
			path = "Datos Party 1/images/player1.png";
		}
		if (playerId == 2) {
			path = "Datos Party 1/images/player2.png";
		}
		if (playerId == 3) {
			path = "Datos Party 1/images/player3.png";
		}
		if (playerId == 4) {
			path = "Datos Party 1/images/player4.png";
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
}
