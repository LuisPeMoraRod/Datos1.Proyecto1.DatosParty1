package com.Datos1.Proyecto1.TicTacToe;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SquaresTTT extends Component {
	/**
	 * Public class that creates the components that form the squares of the tic tac
	 * toe game
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private String path;
	public boolean hasChanged, isChanging;
	public int whichPlayer;

	static int row=0;
	static int column=0;
	int row1;
	int column1;
	int transparency=7;

	/**
	 * Constructor method. Sets the image of the square. Adds mouse listener to the
	 * object. It increases the index of the matrix where the new square will be
	 * located {@link MouseClickedEventTTT} {@link SquaresTTT#changeImage()}
	 */
	public SquaresTTT() {
		hasChanged = false; isChanging = false;
		row1 = row;
		column1 = column;
		this.addMouseListener(new MouseClickedEventTTT());
		changeTranparency();
		path = "images/Bs.jpg";
		changeImage();
		increaseIndex();
	}

	/**
	 * Public method that sets a boolean variable in true indicating that the object
	 * has been clicked
	 */
	public void changeImage() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				isChanging = true;

			}
		});
	}

	public void changeTranparency() {
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				if (!GameBoardTTT.gameEnded) {transparency=9;}
			}
		});
		
		 this.addMouseListener(new MouseAdapter() { 
	          public void mouseExited(MouseEvent me) { 
	        	  if (!GameBoardTTT.gameEnded) {transparency=7;}
	          } 
	        }); 
		

	}

	/**
	 * Overrided method. Creates the squares of the game. Add transparency to the
	 * images. {@link Graphics} {@link AlphaComposite#getInstance(int)}
	 */
	@Override
	public void paint(Graphics g) {
		// g2d.drawImage(getSquare(), 0, 0, null);
		Graphics2D g2d = (Graphics2D) g.create();
		float alpha = (float) ((transparency) * 0.1f);
		AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alcom);
		g2d.drawImage(getSquare(), 0, 0, null);
		g2d.dispose();
	}

	/**
	 * Overrided public method that sets the dimension of the image
	 * 
	 * @return Dimension
	 */
	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(150, 150);
		} else {
			return new Dimension(image.getWidth(), image.getHeight());
		}
	}

	/**
	 * Public method that reads a file and assigns it to a BufferdImage object
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage getSquare() {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public void setTypeSquare() {
		if (!GameBoardTTT.gameEnded) {
			boolean isPlayerTwo = MouseClickedEventTTT.isFirstPlayer;
			if (!isPlayerTwo && !hasChanged && isChanging) {
				hasChanged = true;
				whichPlayer = 1;
				path = "images/Xs.jpg";
			}
			if (isPlayerTwo && !hasChanged && isChanging) {
				hasChanged = true;
				whichPlayer = 2;
				path = "images/Os.jpg";

			}
		}

	}

	/**
	 * Public method that determines if the squares has being already clicked
	 * 
	 * @return boolean
	 */
	public boolean isSquareSetted() {
		if (hasChanged) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Public method that determines if the squares was played by the first or
	 * second player If it returns a true value, it's player 1 square. If it return
	 * false, it's a second player square
	 * 
	 * @return boolean
	 */
	public boolean whichType() {
		if (whichPlayer == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Public method that increases the indexes of the matrix where every square is
	 * located.
	 */
	public void increaseIndex() {
		if (column <= 2) {
			column++;
		}
		if (column > 2 && row <= 2) {
			column = 0;
			row++;
		}

	}

}