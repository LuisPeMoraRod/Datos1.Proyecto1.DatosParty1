package com.Datos1.Proyecto1.Results;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Datos1.Proyecto1.GameBoard.*;
import com.Datos1.Proyecto1.Start.Main;

abstract class Results extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int width = 600, height = 375;
	protected LinkedList results;

	public Results(LinkedList results) throws IOException {
		this.results = results;
		setSize(width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int id = e.getKeyCode();
				if (id == KeyEvent.VK_SPACE) {
					ciao();
				}

			}
		});

	}

	public class ResultsCanvas extends JPanel {
		private static final long serialVersionUID = 1L;
		protected BufferedImage wallpaper, enter;
		private String path;
		protected String resultsString = "Results:";

		public ResultsCanvas(LinkedList results, String path) throws IOException {
			// TODO Auto-generated constructor stub
			resultsString = setResults();
			this.path = path;
			wallpaper = getWallpaper();
			enter = ImageIO.read(new File("images/spacePress.png"));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(wallpaper, 0, 0, this);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 1, 25));
			drawString(g, resultsString, 30, 30);
			g.drawImage(enter, this.getWidth() * 2 / 4 + 10, 10, this);

		}

		public BufferedImage getWallpaper() {
			try {
				wallpaper = ImageIO.read(new File(path));

			} catch (IOException e) {
				e.printStackTrace();
			}
			return wallpaper;
		}

		/**
		 * Draws string with newlines
		 * 
		 * @param g
		 * @param text
		 * @param x
		 * @param y
		 */
		public void drawString(Graphics g, String text, int x, int y) {
			for (String line : text.split("\n"))
				g.drawString(line, x, y += g.getFontMetrics().getHeight());
		}

		/**
		 * Sets the text with the results
		 * 
		 * @return resultsString : String
		 */
		public String setResults() {
			resultsString += "\n";
			Node pointer = results.getHead();
			for (int i = 1; i <= results.getSize(); i++) {

				resultsString += "\n" + i + ". " + pointer.getPlayer().getName() + " +"
						+ pointer.getPlayer().getPoints() + " coins";
				pointer = pointer.getNext();
			}
			return resultsString;
		}
	}

	public void ciao() {
		this.dispose();
		GameBoardLauncher.window.setVisible(true);
		Node pointer = results.getNode(0);
		Player winner = pointer.getPlayer(); //winner moves to the next position
		Node position = winner.getPointer();
		if (position.equals(GameBoard.phaseA.getNode(6))) {
			position = GameBoard.mainLinkedList.getNode(23);
		}else if (position.equals(GameBoard.phaseB.getNode(6))) {
			position = GameBoard.mainLinkedList.getNode(38);
		}else if (position.equals(GameBoard.phaseC.getNode(0))) {
			position = GameBoard.mainLinkedList.getNode(18);
		}
		else{
			position = position.getNext();
		}
		winner.setPointer(position);

		if (Main.minigamesObservable.getDuelFB()) { // if it is a duel of flappy bird
			Main.minigamesObservable.setDuelFB(false);// stop the minigame
			
		} else if (Main.minigamesObservable.getDuelTTT()) { // if it is a duel of tic tac toe
			Main.minigamesObservable.setDuelTTT(false);// stop the minigame
			
		} else if (Main.minigamesObservable.getDuel4IL()) { // if it is a duel of four in line
			Main.minigamesObservable.setDuel4IL(false);// stop the minigame
		}
	}

}