package com.Datos1.Proyecto1.TicTacToe;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Squares extends Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int length;
	private int posx;
	private int posy;

	private BufferedImage image;
	private String path;
	private boolean Xsquare;
	private boolean Osquare;

	public Squares(boolean Xsquare, boolean Osquare) {
		this.Xsquare=Xsquare;
		this.Osquare=Osquare;
		setTypeSquare();
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(98, 98);
		} else {
			return new Dimension(image.getWidth(), image.getHeight());
		}
	}

	public void eventHandler(boolean player1) {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (player1==false) {
					System.out.println("Mouse clicked on square");
				}
				
			}
		});
	}
	
	public void setTypeSquare() {
		if (Xsquare==false && Osquare== false) {
			path="images/Bs.jpg";
		}
		if (Xsquare==true && Osquare== false) {
			path="images/Xs.jpg";
		}
		if (Xsquare==false && Osquare==true) {
			path="images/Os.jpg";
		}
	}
	
	public boolean setPlayer(boolean player) {
		player=!player;
		return player;
	}

}