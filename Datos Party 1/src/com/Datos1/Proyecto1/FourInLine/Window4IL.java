package com.Datos1.Proyecto1.FourInLine;

import javax.swing.JFrame;


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
	public Window4IL(String player1, String player2) {
		createWindow();
		canvas = new GameBoard4IL(player1, player2);
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