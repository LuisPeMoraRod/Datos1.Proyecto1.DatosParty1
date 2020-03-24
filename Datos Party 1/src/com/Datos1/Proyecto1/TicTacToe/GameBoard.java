package com.Datos1.Proyecto1.TicTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;


public class GameBoard extends JPanel {

	/**
	 * 
	 */
	private Label infoLabel = new Label();;
	Squares S1 = new Squares();
	Squares S2 = new Squares();
	Squares S3 = new Squares();
	Squares S4 = new Squares();
	Squares S5 = new Squares();
	Squares S6 = new Squares();
	Squares S7 = new Squares();
	Squares S8 = new Squares();
	Squares S9 = new Squares();
	
	BufferedImage I1;
	BufferedImage I2;
	BufferedImage I3;
	BufferedImage I4;
	BufferedImage I5;
	BufferedImage I6;
	BufferedImage I7;
	BufferedImage I8;
	BufferedImage I9;
	
	

	private static final long serialVersionUID = 1L;
	final Image wallpaper = requestImage();

	public GameBoard() {
		
		
	}

	public void setPanel(Squares S1,Squares S2,Squares S3,Squares S4,Squares S5,Squares S6,Squares S7,Squares S8,Squares S9) {

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		infoLabel.setText("Information related to the status of the game");
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(infoLabel).addGap(30)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(S1).addComponent(S2)
						.addComponent(S3))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(S4).addComponent(S5)
						.addComponent(S6))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(S7).addComponent(S8)
						.addComponent(S9)));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(infoLabel).addComponent(S1).addComponent(S4)
						.addComponent(S7))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(S2).addComponent(S5)
						.addComponent(S8))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(S3).addComponent(S6)
						.addComponent(S9))

		);


	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(wallpaper, 0, 0, null);	
		update();		
		setPanel(S1,S2,S3,S4,S5,S6,S7,S8,S9);
		
		//removeAll();

		/*
		 * Graphics2D g2=(Graphics2D)g; g2.setColor(Color.black); g2.fill(new
		 * Rectangle2D.Double(20,0,20,20));
		 */

	}

	private Image requestImage() {
		Image image = null;

		try {
			image = ImageIO.read(new File("images/Wallpaper.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	
	public void update() {
		S1.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S2.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S3.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S4.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S5.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S6.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S7.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S8.setTypeSquare(MouseClickedEvent.isFirstPlayer);
		S9.setTypeSquare(MouseClickedEvent.isFirstPlayer);
	}
	
	
}
