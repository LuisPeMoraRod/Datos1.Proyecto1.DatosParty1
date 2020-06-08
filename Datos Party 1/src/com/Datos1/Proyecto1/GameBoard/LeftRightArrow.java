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

import javax.imageio.ImageIO;


public class LeftRightArrow extends Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Arrow image component class
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 30/5/2020
	 */

	protected String path;
	protected int transparency = 10;
	protected BufferedImage sprite;
	protected int width, height;
	protected Point location;
	protected boolean isRight;
	protected boolean isUp;
	

	public LeftRightArrow(Builder builder) {
		super();
		path = builder.getPath();
		location = builder.getLocation();
		isRight = builder.isRight;
		isUp= builder.isUp;
		setTransparency();
		clickOnDice();
		
	}

	public Point getsLocation() {
		return this.location;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		/**
		 * Builder class. Sets the path of the image for right or left arrow.
		 */
		protected String path;
		protected Point location;// location of the sprite in the canvas
		protected boolean isRight;
		protected boolean isUp;

		public LeftRightArrow build() {
			return new LeftRightArrow(this);
		}

		public Builder right() {
			path = "images/rightArrow.png";
			location = new Point(Window.width * 10 / 12, Window.height * 3 / 7);// sets location for right arrow
			location.x += 40;
			isRight = true;
			return this;
		}

		public Builder left() {
			path = "images/leftArrow.png";
			location = new Point(Window.width * 10 / 12, Window.height * 3 / 7);// sets location for left arrow
			location.x -= 80;
			isRight = false;
			return this;
		}
		

		public String getPath() {
			return this.path;
		}

		public Point getLocation() {
			return this.location;
		}

	}

	@Override
	public void paint(Graphics g) {

	}

	public void paintsArrow(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		float alpha = (float) ((transparency) * 0.1f);
		AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alcom);
		g2d.drawImage(getSprite(path), location.x, location.y, null);
	}

	@Override
	public Dimension getPreferredSize() {
		if (sprite == null) {
			return new Dimension(108, 105);
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
				if (isRight) {
					GameBoard.twoPaths1 = false;
					GameBoard.moving = true;
					Node pointer = GameBoard.phaseA.head;
					GameBoard.movingPointer = pointer;
					GameBoard.playerInTurn.getPlayer().setPointer(pointer);
					System.out.println("right");
					
				}else if (!isRight){
					GameBoard.twoPaths1 = false;
					GameBoard.moving = true;
					GameBoard.movingPointer = GameBoard.playerInTurn.getPlayer().getPointer();
					GameBoard.movingPointer = GameBoard.movingPointer.getNext();
					GameBoard.playerInTurn.getPlayer().setPointer(GameBoard.movingPointer);
					System.out.println("left");
				}
			}
		});
	}
	
	

}
