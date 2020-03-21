package com.Datos1.Proyecto1.TicTacToe;

import java.awt.*;
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

	protected BufferedImage image;
	protected String path="images/Xs.jpg";

	

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

	public Squares() {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("pedro");
			e.printStackTrace();
		}
	}
	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(image.getWidth(), image.getHeight());
		}
	}

}