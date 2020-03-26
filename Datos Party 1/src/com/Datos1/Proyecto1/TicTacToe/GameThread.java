package com.Datos1.Proyecto1.TicTacToe;

public class GameThread extends Thread {
	GameBoard board;
	public GameThread(GameBoard board) {
		this.board = board;
	}

	@Override
	public void run() {
		while (!GameBoard.gameEnded) {
			board.repaint();
		}
		System.out.println("Winner: "+GameBoard.winner);
	}
}
