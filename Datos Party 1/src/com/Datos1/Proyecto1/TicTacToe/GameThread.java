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
		System.out.println("Winner: " + GameBoard.winner);
		while (GameBoard.gameEnded) {
			try {
				hideShow();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("falla");
				e.printStackTrace();
			}
		}

	}


	@SuppressWarnings("deprecation")
	public void hide(Squares S1, Squares S2, Squares S3) {
		S1.hide();
		S2.hide();
		S3.hide();

	}

	@SuppressWarnings("deprecation")
	public void show(Squares S1, Squares S2, Squares S3) {
		S1.show();
		S2.show();
		S3.show();

	}

	public void hideShow() throws InterruptedException {
		int pos00 = GameBoard.gameStatus[0][0];
		int pos01 = GameBoard.gameStatus[0][1];
		int pos02 = GameBoard.gameStatus[0][2];
		int pos10 = GameBoard.gameStatus[1][0];
		int pos11 = GameBoard.gameStatus[1][1];
		int pos12 = GameBoard.gameStatus[1][2];
		int pos20 = GameBoard.gameStatus[2][0];
		int pos21 = GameBoard.gameStatus[2][1];
		int pos22 = GameBoard.gameStatus[2][2];

		if (pos00 == pos01 && pos00 == pos02 && pos00 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S1, GameBoard.S2, GameBoard.S3);
			Thread.sleep(350);
			show(GameBoard.S1, GameBoard.S2, GameBoard.S3);
		}

		if (pos10 == pos11 && pos10 == pos12 && pos10 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S4, GameBoard.S5, GameBoard.S6);
			Thread.sleep(350);
			show(GameBoard.S4, GameBoard.S5, GameBoard.S6);
		}

		if (pos20 == pos21 && pos20 == pos22 && pos20 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S7, GameBoard.S8, GameBoard.S9);
			Thread.sleep(350);
			show(GameBoard.S7, GameBoard.S8, GameBoard.S9);
		}

		if (pos00 == pos10 && pos00 == pos20 && pos00 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S1, GameBoard.S4, GameBoard.S7);
			Thread.sleep(350);
			show(GameBoard.S1, GameBoard.S4, GameBoard.S7);
		}

		if (pos01 == pos11 && pos01 == pos21 && pos01 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S2, GameBoard.S5, GameBoard.S8);
			Thread.sleep(350);
			show(GameBoard.S2, GameBoard.S5, GameBoard.S8);
		}

		if (pos02 == pos12 && pos02 == pos22 && pos02 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S3, GameBoard.S6, GameBoard.S9);
			Thread.sleep(350);
			show(GameBoard.S3, GameBoard.S6, GameBoard.S9);
		}

		if (pos00 == pos11 && pos00 == pos22 && pos00 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S1, GameBoard.S5, GameBoard.S9);
			Thread.sleep(350);
			show(GameBoard.S1, GameBoard.S5, GameBoard.S9);
		}

		if (pos20 == pos11 && pos02 == pos20 && pos20 != 0) {
			Thread.sleep(600);
			hide(GameBoard.S7, GameBoard.S5, GameBoard.S3);
			Thread.sleep(350);
			show(GameBoard.S7, GameBoard.S5, GameBoard.S3);
		}

	}

}
