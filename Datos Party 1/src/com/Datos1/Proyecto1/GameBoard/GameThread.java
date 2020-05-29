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
			if (GameBoard.dice1.thrown && GameBoard.dice2.thrown) {
				GameBoard.dice1.thrown = false;
				GameBoard.dice2.thrown = false;
				pointer = GameBoard.playerInTurn.getPlayer().getPointer();
				int move =4;
				for (int i = 0; i < move; i++) {
					pointer = pointer.getNext();
					System.out.println(pointer.getIndex());
				}
				GameBoard.playerInTurn.getPlayer().setPointer(pointer);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			board.repaint();
		}

	}
}
