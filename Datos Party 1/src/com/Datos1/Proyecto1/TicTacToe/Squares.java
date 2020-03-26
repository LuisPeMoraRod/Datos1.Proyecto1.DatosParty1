package com.Datos1.Proyecto1.TicTacToe;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Squares extends Component{
	/**
	 * Public class that creates the components that form the squares of the tic tac toe game
	 * @author Luis Pedro Morales
	 * @version First version
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private String path;
	public boolean hasChanged=false,isChanging=false;
	public int whichPlayer;
	
	static int row=0;
	static int column = 0;
	int row1;
	int column1;
	
	public Squares() {
		row1=row;
		column1=column;
		this.addMouseListener(new MouseClickedEvent());
		path="images/Bs.jpg";
		changeImage();
		increaseIndex();
	}
	
	public void changeImage() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				isChanging=true;
				
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(getSquare(), 0, 0, null);
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(150, 150);
		} else {
			return new Dimension(image.getWidth(), image.getHeight());
		}
	}
	
	public BufferedImage getSquare() {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	

	public void setTypeSquare() {
		if (!GameBoard.gameEnded) {
			boolean isPlayerOne=MouseClickedEvent.isFirstPlayer;
			if (isPlayerOne && !hasChanged && isChanging) {
				hasChanged=true;
				whichPlayer=1;
				path = "images/Xs.jpg";
			}
			if (!isPlayerOne && !hasChanged && isChanging) {
				hasChanged=true;
				whichPlayer=2;
				path = "images/Os.jpg";
		
			}
		}
		
	}
	
	public boolean isSquareSetted() {
		if (hasChanged) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean whichType() {
		if (whichPlayer==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void increaseIndex() {
		if (column<=2) {
			column++;
		}
		if (column>2 && row<=2) {
			column=0;
			row++;
		}
		
	}


}