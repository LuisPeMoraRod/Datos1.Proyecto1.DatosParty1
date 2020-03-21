package com.Datos1.Proyecto1.TicTacToe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.geom.Rectangle2D;
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
	private Label infoLabel;
	private Bsquare S1, S2, S3, S4, S5, S6, S7, S8, S9;

	private static final long serialVersionUID = 1L;
	final Image wallpaper = requestImage();

	public GameBoard() {
		setPanel();

	}

	public void setPanel() {

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);

		infoLabel = new Label();
		infoLabel.setText("Information related to the status of the game");

		S1 = new Bsquare();
		S2 = new Bsquare();
		S3 = new Bsquare();
		S4 = new Bsquare();
		S5 = new Bsquare();
		S6 = new Bsquare();
		S7 = new Bsquare();
		S8 = new Bsquare();
		S9 = new Bsquare();

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

		//add(new Xsquare());
		//add(new Osquare());

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(wallpaper, 0, 0, null);

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
}
