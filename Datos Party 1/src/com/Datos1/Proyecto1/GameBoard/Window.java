package com.Datos1.Proyecto1.GameBoard;

import javax.swing.JFrame;

public class Window extends JFrame{

	/**
	 * Public class. Creates the window or the frame where the game board is set.
	 * @author Luis Pedro Morales Rodríguez
	 * @version 3/5/2020
	 */
	private static final long serialVersionUID = 1L;
	private int width = 900;
	private int height = 600;
	
	private GameBoard canvas;
	
	/**
	 * Constructor method. Instantiates a GameBoard object
	 * {@link GameBoard}
	 */
	public Window() {
		createWindow();
		canvas = new GameBoard();
		this.add(canvas);		
		
	}
	
	
	public void createWindow() {
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Datos Party 1");
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
