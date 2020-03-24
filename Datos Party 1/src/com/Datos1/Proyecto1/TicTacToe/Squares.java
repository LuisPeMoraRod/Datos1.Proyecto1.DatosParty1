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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private String path;
	public boolean hasChanged=false,isChanging=false;
	
	public int id = 1;

	public Squares() {
		this.addMouseListener(new MouseClickedEvent());
		path="images/Bs.jpg";
		changeImage();
		
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
			return new Dimension(98, 98);
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
	
	

	public void setTypeSquare(boolean isPlayerOne) {
		
		if (isPlayerOne && !hasChanged && isChanging) {
			hasChanged=true;
			path = "images/Xs.jpg";
		}
		if (!isPlayerOne && !hasChanged && isChanging) {
			hasChanged=true;
			path = "images/Os.jpg";
	
		}
	}


}