package com.Datos1.Proyecto1.GameBoard;

public class GameThread extends Thread {
	public static boolean gameEnded;
	GameBoard board;
	Node pointer;

	public GameThread(GameBoard board) {
		this.board = board;
		gameEnded = false;
	}

	@Override
	public synchronized void run() {
		while (!gameEnded) {
			board.repaint();
		}

	}
}
