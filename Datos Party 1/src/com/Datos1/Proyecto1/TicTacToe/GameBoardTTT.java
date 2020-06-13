package com.Datos1.Proyecto1.TicTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Datos1.Proyecto1.GameBoard.Player;


public class CuGameBoardTTT extends JPanel {

	/**
	 * Public class that displays the canvas with all its needed components on the
	 * game window. It's constantly updating the status of its components
	 *
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	public static boolean gameEnded;
	private JLabel infoLabel = new JLabel();
	private JLabel turnLabel=new JLabel();
	static SquaresTTT S1;
	static SquaresTTT S2;
	static SquaresTTT S3;
	static SquaresTTT S4;
	static SquaresTTT S5;
	static SquaresTTT S6;
	static SquaresTTT S7;
	static SquaresTTT S8;
	static SquaresTTT S9;

	static int gameStatus[][]; // Array that controls the status of the game and is used to determine if
	// a player has won or of the game ended in a draw
	static int cont;
	static String winnerName;
	private Player player1, player2;
	private Player winnerPlayer;
	private String name1,name2;

	private static final long serialVersionUID = 1L;
	final Image wallpaper = requestImage();

	/**
	 * Constructor method
	 *
	 * @param player1 : String
	 * @param player2 : String
	 */
	public GameBoardTTT(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.name1 = player1.getName();
		this.name2 = player2.getName();
		gameEnded = false;
		S1 = new SquaresTTT();
		S2 = new SquaresTTT();
		S3 = new SquaresTTT();
		S4 = new SquaresTTT();
		S5 = new SquaresTTT();
		S6 = new SquaresTTT();
		S7 = new SquaresTTT();
		S8 = new SquaresTTT();
		S9 = new SquaresTTT();
		gameStatus = new int [3][3];
		cont=0;
		setPanel(S1, S2, S3, S4, S5, S6, S7, S8, S9);

	}

	/**
	 * Public method that sets the position of components in the canvas
	 *
	 * @param S1 : Squares
	 * @param S2 : Squares
	 * @param S3 : Squares
	 * @param S4 : Squares
	 * @param S5 : Squares
	 * @param S6 : Squares
	 * @param S7 : Squares
	 * @param S8 : Squares
	 * @param S9 : Squares
	 */
	public void setPanel(SquaresTTT S1, SquaresTTT S2, SquaresTTT S3, SquaresTTT S4, SquaresTTT S5, SquaresTTT S6, SquaresTTT S7, SquaresTTT S8,
						 SquaresTTT S9) {

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		//String infoText = "<html><body><font size=6> <span style=\"color: #000080;\"><span style=\"color: #00ffff;\">Tic</span> <span style=\"color: #ff0000;\">Tac</span> <span style=\"color: #00ffff;\">Toe</span></span<br><br>Player 1: "+player1+"<br>Player 2: "+player2+" </font></body></html>";
		String infoText = "<html><body><font size=6>TIC-TAC-TOE<br><br>Player 1: "+name1+"<br>Player 2: "+name2+" </font></body></html>";
		infoLabel.setText(infoText);
		infoLabel.setForeground(Color.white);

		String turnText="<html><body ><font size=6><br>It's "+name1+"'s turn"+"  </font> </body></html>";
		turnLabel.setText(turnText);
		turnLabel.setForeground(Color.white);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(infoLabel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(turnLabel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(30)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(S1).addComponent(S4)
						.addComponent(S7))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(S2).addComponent(S5)
						.addComponent(S8))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(S3).addComponent(S6)
						.addComponent(S9)));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(infoLabel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(S1).addComponent(S2).addComponent(S3))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(turnLabel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(S4).addComponent(S5).addComponent(S6))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(S7).addComponent(S8)
						.addComponent(S9))

		);

	}

	/**
	 * Overrided method that's in charge of painting components on the canvas
	 *
	 * @see GameBoardTTT#update()
	 * @see GameBoardTTT#setPanel(SquaresTTT, SquaresTTT, SquaresTTT, SquaresTTT, SquaresTTT, SquaresTTT,
	 *      SquaresTTT, SquaresTTT, SquaresTTT)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(wallpaper, 0, 0, null);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.WHITE);
		update();

		// removeAll();
		/*
		 * Graphics2D g2=(Graphics2D)g; g2.setColor(Color.black); g2.fill(new
		 * Rectangle2D.Double(20,0,20,20));
		 */
	}

	/**
	 * Private method that reads a file (jpg) 
	 * {@link ImageIO#read(File)}
	 * @return Image object
	 */
	private Image requestImage() {
		Image image = null;

		try {
			image = ImageIO.read(new File("images/Wallpaper.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Public method that constantly updates the canvas of the game board
	 *
	 * @return void {@link SquaresTTT#setTypeSquare()}
	 *         {@link GameBoardTTT#setMatrix(SquaresTTT)}
	 */
	public void update() {
		S1.setTypeSquare();
		setMatrix(S1);
		S2.setTypeSquare();
		setMatrix(S2);
		S3.setTypeSquare();
		setMatrix(S3);
		S4.setTypeSquare();
		setMatrix(S4);
		S5.setTypeSquare();
		setMatrix(S5);
		S6.setTypeSquare();
		setMatrix(S6);
		S7.setTypeSquare();
		setMatrix(S7);
		S8.setTypeSquare();
		setMatrix(S8);
		S9.setTypeSquare();
		setMatrix(S9);
		if (!gameEnded) {
			setTurnText(turnLabel);
		}

	}

	/**
	 * Public method that sets a value of the gameSatus matrix. If the value is
	 * true, it represents an X. If it is false, it represents an O.
	 *
	 * @param square: Square type object
	 */
	public void setMatrix(SquaresTTT square) {
		int row, column;
		row = square.row1;
		column = square.column1;
		boolean isSquareSetted = square.isSquareSetted();
		boolean isPlayerOne = square.whichType();
		if (isSquareSetted) {
			if (isPlayerOne) {
				gameStatus[row][column] = 1;
			} else {
				gameStatus[row][column] = 2;
			}
		}
	}

	/**
	 * Public method in charge of checking after every play if there's a winner or
	 * not
	 *
	 * @param player1: String
	 * @param player2: String
	 * @return String object that represents the name of the winner player. If no
	 *         body won, the method returns null
	 */
	public Player checkVictory() {
		
		int pos00 = gameStatus[0][0];
		int pos01 = gameStatus[0][1];
		int pos02 = gameStatus[0][2];
		int pos10 = gameStatus[1][0];
		int pos11 = gameStatus[1][1];
		int pos12 = gameStatus[1][2];
		int pos20 = gameStatus[2][0];
		int pos21 = gameStatus[2][1];
		int pos22 = gameStatus[2][2];

		if (pos00 == pos01 && pos00 == pos02 && pos00 != 0) {

			if (pos00 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos10 == pos11 && pos10 == pos12 && pos10 != 0) {
			if (pos10 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos20 == pos21 && pos20 == pos22 && pos20 != 0) {
			if (pos20 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos00 == pos10 && pos00 == pos20 && pos00 != 0) {
			if (pos00 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos01 == pos11 && pos01 == pos21 && pos01 != 0) {
			if (pos01 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos02 == pos12 && pos02 == pos22 && pos02 != 0) {
			if (pos02 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos00 == pos11 && pos00 == pos22 && pos00 != 0) {
			if (pos00 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		if (pos20 == pos11 && pos02 == pos20 && pos20 != 0) {
			if (pos02 == 1) {
				return player1;
			} else {
				return player2;
			}
		}

		return null;
	}

	public void setTurnText(JLabel label) {
		try {
			winnerName = checkVictory().getName();
		} catch (Exception e) {
			winnerName = null;
		}
		
		
		
		String text;
		if (winnerName != null) {
			setsWinnerCoins();// increments coins for the winner
			GameBoardTTT.gameEnded = true;// Game ended with a winner
			text="<html><body><font size=6><br>Winner: "+winnerName+"</font> </body></html>";
			turnLabel.setText(text);
		}
		if (winnerName == null && cont > 8) {
			//2 points for every player in case of draw
			player1.incrementCoins(2); player1.incrementPoints(2);
			player2.incrementCoins(2); player2.incrementPoints(2);
			GameBoardTTT.gameEnded = true;
			winnerName = "draw";
			text="<html><body><font size=6><br>Game ended: "+winnerName+"</font> </body></html>";
			turnLabel.setText(text);
		}

		if (!GameBoardTTT.gameEnded) {
			if (MouseClickedEventTTT.isFirstPlayer) {
				text="<html><body><font size=6><br>It's "+name1+"'s turn</font> </body></html>";
				turnLabel.setText(text);
			}else {
				text="<html><body><font size=6><br>It's "+name2+"'s turn</font> </body></html>";
				turnLabel.setText(text);
			}

		}
	}
	
	public void setsWinnerCoins() {
		if (winnerName.equals(player1.getName())) {
			player1.incrementCoins(6); player1.incrementPoints(6);
		}else if (winnerName.equals(player2.getName())) {
			player2.incrementCoins(6); player2.incrementPoints(6);
		}
		else {
			winnerName = null;
		}
	}
	
	

}
