package com.Datos1.Proyecto1.TicTacToe;

import javax.swing.JFrame;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String player1,player2;
	private final int width=850, length=570;
	GameBoard board;
	GameThread thread;
	
	
	public Window (String player1, String player2) {
		this.player1=player1;
		this.player2=player2;
		createWindow();
		thread = new GameThread(board);
		thread.start();
		
	}
	
	public void createWindow() {
		setTitle("Tic-Tac-Toe");
		setSize(width,length);
		setLocationRelativeTo(null);
		setResizable(false);
		board=new GameBoard("Jugador: 1", "Jugador: 2");
		add(board);
		
	}
	
}
