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
	private int width;
	private int height;
	public int number;
	public boolean thrown;
	private int transparency = 10;
	private Random random;
	private float alpha;
	private AlphaComposite alcom;

	public Dice() {
		setPath(number);
		clickOnDice();
		setTransparency();
		random = new Random();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		alpha = (float) ((transparency) * 0.1f);
		alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alcom);
		g2d.drawImage(getSprite(), 0, 0, null);
		g2d.dispose();
	}

	public void setPath(int face) {
		switch (face) {
		case 1:
			path = "images/one.jpg";
			break;
		case 2:
			path = "images/two.jpg";
			break;
		case 3:
			path = "images/three.jpg";
			break;
		case 4:
			path = "images/four.jpg";
			break;
		case 5:
			path = "images/five.jpg";
			break;
		case 6:
			path = "images/six.jpg";
			break;
		default:
			path = "images/one.jpg";
			break;
		}
	}

	/**
	 * Public method. Sets mouse adapter on the component. Changes transparency of
	 * the component when the mouse enters or exits it. {@link MouseAdapter}
	 */
	public void setTransparency() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				transparency = 5;
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent me) {
				transparency = 10;
			}
		});
	}

	/**
	 * Public method. Sets mouse adapter on the dice object. Every click simulates
	 * the dice throwing. {@link MouseAdapter}
	 */
	public void clickOnDice() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				GameBoard.throwAgain = false;
				GameBoard.staticCoins = false;
				GameBoard.drawCoins = false;
				DiceThread thread = new DiceThread(Window.canvas);
				thread.start();
			}
		});
	}

	/**
	 * Overrided method. Sets the dimension of the sprite
	 */
	@Override
	public Dimension getPreferredSize() {
		if (diceFace == null) {
			return new Dimension(96, 96);
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

	/**
	 * Public class. Extends Thread class. The thread is in charge of changing the
	 * value of the dice used in the game board to move the sprites.
	 * 
	 * @author Luis Pedro Morales
	 * @version 28/5/2020
	 */
	public class DiceThread extends Thread {
		GameBoard canvas;

		public DiceThread(GameBoard canvas) {
			this.canvas = canvas;
		}

		/**
		 * Overrided method. Changes the value of the dice and the static attribute
		 * number randomly.
		 */
		@Override
		public synchronized void run() {
			int randomInt;
			for (int i = 0; i < 10; i++) {
				transparency = 5;
				randomInt = random.nextInt(6) + 1;
				number = randomInt;

				setPath(number);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			thrown = true;
			transparency = 10;

		}
	}

}
