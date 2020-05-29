package com.Datos1.Proyecto1.GameBoard;

public class GameThread extends Thread {
	public static boolean gameEnded;
	GameBoard board;

	public GameThread(GameBoard board) {
		this.board = board;
	}

	@Override
	public void run() {
		while (!gameEnded) {

		}

	}
}
