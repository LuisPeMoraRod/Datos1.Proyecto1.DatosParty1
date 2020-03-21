package com.Datos1.Proyecto1.TicTacToe;

import javax.swing.JFrame;

public class Window extends JFrame{
	public String player1,player2;
	private final int width=850, length=510;
	private GameBoard board;
	
	public Window (String player1, String player2) {
		this.player1=player1;
		this.player2=player2;
		createWindow();
		
	}
	
	public void createWindow() {
		setTitle("Tic-Tac-Toe");
		setSize(width,length);
		setLocationRelativeTo(null);
		setResizable(false);
		board=new GameBoard();
		add(board);
		
		
	}
	
}
