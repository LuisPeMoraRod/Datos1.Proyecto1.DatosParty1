package com.Datos1.Proyecto1.GameBoard;

import javax.swing.JFrame;

public class Window extends JFrame{

	/**
	 * Public class. Creates the window or the frame where the game board is set.
	 * @author Luis Pedro Morales Rodr�guez
	 * @version 3/5/2020
	 */
	private static final long serialVersionUID = 1L;
	private int width = 1650;
	private int height = 1000;
	
	private GameBoard canvas;
	private GameThread thread;
	
	/**
	 * Constructor method. Instantiates a GameBoard object
	 * {@link GameBoard}
	 */
	public Window() {
		createWindow();
		canvas = new GameBoard();
		this.add(canvas);	
		thread = new GameThread(canvas);
		thread.start();
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