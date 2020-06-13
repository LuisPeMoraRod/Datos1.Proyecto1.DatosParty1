package com.Datos1.Proyecto1.GameBoard;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.Datos1.Proyecto1.Start.Main;


public class MiniGameButton extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Point location;
	protected int transparency;
	protected BufferedImage sprite;
	protected String path;
	protected JPanel canvas;
	protected int width, height;
	protected int miniGameId; //0=Flappy Bird, 1=Tic Tac Toe, 2= Four in Line
	protected Random random;
	
	public MiniGameButton(JPanel canvas) {
		transparency = 10;
		path = "images/letsGo.png";
		this.canvas = canvas;
		setTransparency();
		clickOnDice();
		random = new Random();
		
	}
	
	
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getsLocation() {
		return this.location;
	}

	@Override
	public void paint(Graphics g) {

	}

	public void paintsButton(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		float alpha = (float) ((transparency) * 0.1f);
		AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alcom);
		g2d.drawImage(getSprite(path), location.x, location.y, null);
	}

	@Override
	public Dimension getPreferredSize() {
		if (sprite == null) {
			return new Dimension(171, 143);
		} else {
			return new Dimension(width, height);

		}

	}

	/**
	 * Public method. Used to draw the sprite in the canvas. Returns a BufferedImage
	 * object
	 * 
	 * @param path
	 * @return sprite : BufferedImage
	 */
	public BufferedImage getSprite(String path) {
		try {
			sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sprite;
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

	public void clickOnDice() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				transparency = 10;
				
				startMiniGame();
			}
		});
	}
	
	/**
	 * Sets observable's flags 
	 */
	public void startMiniGame() {
		GameBoard.newMiniGame = false;
		GameBoardLauncher.window.setVisible(false);
		System.out.println(GameBoard.newMiniGame);
		canvas.remove(this);
		miniGameId = random.nextInt(6);
		switch (miniGameId) {

			case 0:
				Main.minigamesObservable.set4IL(true);//sets observable flag to start four in line
				break;

			case 1:
				Main.minigamesObservable.setTTT(true);//sets observable flag to start tic tac toe
				break;

			case 2:
				Main.minigamesObservable.setFB(true);//sets observable flag to star flappy bird
				break;

			case 3:
				Main.minigamesObservable.setSimon(true);//sets observable flag to start simon
				break;
			case 4:
				Main.minigamesObservable.setPong(true);//sets observable flag to start pong
				break;
			case 5:
				Main.minigamesObservable.setSnake(true);//sets observable flag to start snake
				break;
			default:
				break;

		}

	}

}
