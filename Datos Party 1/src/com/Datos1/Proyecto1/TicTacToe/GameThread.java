package com.Datos1.Proyecto1.TicTacToe;

public class GameThread extends Thread {

	GameBoard board;

	public GameThread(GameBoard board) {
		this.board = board;
	}

	@Override
	public void run() {
		while (true) {
			board.repaint();
		}
	}
}
