package com.Datos1.Proyecto1.FourInLine;

import javax.swing.JFrame;

import com.Datos1.Proyecto1.GameBoard.Player;


public class Window4IL extends JFrame {
	/**
	 * Public class that creates the window where the canvas of the game is setted
	 * 
	 * @author Luis Pedro Morales Rodríguez
	 * @version 25/3/2020
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 800;
	static int height = 750;
	GameBoard4IL canvas;

	/**
	 * Constructor method. Instantiates the object in charge of creating the canvas
	 * {@link GameBoard4IL}
	 * @param player1 : String
	 * @param player2 : String
	 */
	public Window4IL(Player player1, Player player2, EndObservable4IL observable) {
		createWindow();
		canvas = new GameBoard4IL(player1, player2,observable);
		add(canvas);
	}

	/**
	 * Public method. Sets different parameters of the window created.
	 */
	public void createWindow() {
		setSize(width, height);
		setTitle("Four In Line");
		setLocationRelativeTo(null);
		setResizable(false);

	}
}