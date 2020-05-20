package com.Datos1.Proyecto1.GameBoard;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Dice extends Component {
	/**
	 * Public class that handles the events that happen when a Dice object is
	 * clicked
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 20/5/2020 {@link MouseAdapter}
	 */

	private static final long serialVersionUID = 1L;
	private BufferedImage diceFace;
	private String path;
	private int width=180;
	private int height=180;
	public static int number;
	private int transparency=7;

	public Dice() {
		setPath(number);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (Dice.number < 6) {
					Dice.number += 1;
					setPath(number);
				} else {
					Dice.number = 1;
					setPath(number);
				}

			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		//float alpha = (float) ((transparency) * 0.1f);
		//AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		//g2d.setComposite(alcom);
		g2d.drawImage(getSprite(), 0, 0, null);
		g2d.dispose();
	}

	public void setPath(int face) {
		switch (face) {
		case 1:
			path = "Datos Party 1/images/one.jpg";
			break;
		case 2:
			path = "Datos Party 1/images/two.jpg";
			break;
		case 3:
			path = "Datos Party 1/images/three.jpg";
			break;
		case 4:
			path = "Datos Party 1/images/four.jpg";
			break;
		case 5:
			path = "Datos Party 1/images/five.jpg";
			break;
		case 6:
			path = "Datos Party 1/images/six.jpg";
			break;
		default:
			path = "Datos Party 1/images/one.jpg";
			break;
		}
	}

	/**
	 * Overrided method. Sets the dimension of the sprite
	 */
	@Override
	public Dimension getPreferredSize() {
		if (diceFace == null) {
			return new Dimension(width, height);
		} else {

			return new Dimension(width, height);

		}
	}

	/**
	 * Public method that reads a file and assigns it to a BufferdImage object
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage getSprite() {
		try {
			diceFace = ImageIO.read(new File(path));
			width = diceFace.getWidth();
			height = diceFace.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return diceFace;
	}

}
