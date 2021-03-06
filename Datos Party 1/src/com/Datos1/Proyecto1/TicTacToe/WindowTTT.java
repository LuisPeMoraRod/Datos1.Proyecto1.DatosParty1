package com.Datos1.Proyecto1.TicTacToe;

import javax.swing.JFrame;

import com.Datos1.Proyecto1.GameBoard.Player;

import java.io.IOException;

public class WindowTTT extends JFrame{
	/**
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	private static final long serialVersionUID = 1L;

	
	public Player player1,player2;
	private final int width=850, length=570;
	GameBoardTTT board;
	GameThreadTTT thread;
	
	
	public WindowTTT (Player player1, Player player2, EndObservableTTT observable) throws IOException {
		this.player1=player1;
		this.player2=player2;
		createWindow(player1,player2);
		thread = new GameThreadTTT(board,observable);
		thread.start();
		
	}
	
	public void createWindow(Player player1, Player player2) throws IOException {
		setTitle("Tic-Tac-Toe");
		setSize(width,length);
		setLocationRelativeTo(null);
		setResizable(false);
		board=new GameBoardTTT(player1, player2);
		add(board);
		
	}
	
}
