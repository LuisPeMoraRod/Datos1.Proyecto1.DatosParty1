package com.Datos1.Proyecto1.FlappyBird;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird extends Component {
	/**
	 * Public class that creates the objects that are going to be used as the
	 * "flying flappy bird"
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 30/3/2020
	 */
	private static final long serialVersionUID = 1L;
	public int player;
	public String path;
	private BufferedImage image;
	public int birdWidth, birdHeight;

	/**
	 * Constructor method {@link Bird#setPath(int)}
	 * 
	 * @param player: int
	 */
	public Bird(int player) {
		this.player = player;
		setPath(player);
	}

	/**
	 * Public method that sets the path of the image depending on which player is it
	 * going to be the Bird object
	 * 
	 * @param player : int
	 */
	public void setPath(int player) {
		if (player == 1) {
			if (MainFlappyBird.players == 1) {
				path = "Datos Party 1/images/panda.png";
			} else {
				path = "Datos Party 1/images/player1.png";
			}
		}
		if (player == 2) {
			path = "Datos Party 1/images/player2.png";
		}
		if (player == 3) {
			path = "Datos Party 1/images/player3.png";
		}
		if (player == 4) {
			path = "Datos Party 1/images/player4.png";
		}
	}

	/**
	 * Overrided method. Sets the dimension of the image
	 */
	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(40, 40);
		} else {

			return new Dimension(birdWidth, birdHeight);

		}
	}

	/**
	 * Public method that reads a file and assigns it to a BufferdImage object
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage getBird() {
		try {
			image = ImageIO.read(new File(path));
			birdWidth = image.getWidth();
			birdHeight = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
