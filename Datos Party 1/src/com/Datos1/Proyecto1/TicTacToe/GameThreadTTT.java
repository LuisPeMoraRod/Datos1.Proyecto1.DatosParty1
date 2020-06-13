package com.Datos1.Proyecto1.TicTacToe;


public class GameThreadTTT extends Thread {
	/**
	 * Public class that runs the thread in charge of constantly repaint the
	 * components in the canvas
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	GameBoardTTT board;
	private EndObservableTTT observable;

	public GameThreadTTT(GameBoardTTT board, EndObservableTTT observable) {
		this.board = board;
		this.observable = observable;
	}

	/**
	 * Overrided public method that runs when the thread starts. While the game is
	 * being played, it repaints all the canvas' components. When the game ends, the
	 * hide and show method is called in a loop {@link GameThreadTTT#hideShow()}
	 */
	@Override
	public void run() {
		while (!GameBoardTTT.gameEnded) {
			board.repaint();
		}
		SquaresTTT.column=SquaresTTT.row=0; //Necessary to rebuild the matrix for next game
		System.out.println("Winner: " + GameBoardTTT.winnerName);
		int cont = 0;
		while (cont <= 3) {
			try {
				hideShow();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("falla");
				e.printStackTrace();
			}
			cont++;
		}
		observable.setEnd(true);//sets observable flag
		

	}

	/**
	 * Public method that hides the objects
	 * 
	 * @param S1 : Squares
	 * @param S2 : Squares
	 * @param S3 : Squares
	 */
	@SuppressWarnings("deprecation")
	public void hide(SquaresTTT S1, SquaresTTT S2, SquaresTTT S3) {
		S1.hide();
		S2.hide();
		S3.hide();

	}

	/**
	 * Public method that shows the objects
	 * 
	 * @param S1 : Squares
	 * @param S2 : Squares
	 * @param S3 : Squares
	 */
	@SuppressWarnings("deprecation")
	public void show(SquaresTTT S1, SquaresTTT S2, SquaresTTT S3) {
		S1.show();
		S2.show();
		S3.show();

	}

	/**
	 * Public method that hides and shows the three squares that gave the win to the
	 * player
	 * 
	 * @throws InterruptedException
	 */
	public void hideShow() throws InterruptedException {
		int pos00 = GameBoardTTT.gameStatus[0][0];
		int pos01 = GameBoardTTT.gameStatus[0][1];
		int pos02 = GameBoardTTT.gameStatus[0][2];
		int pos10 = GameBoardTTT.gameStatus[1][0];
		int pos11 = GameBoardTTT.gameStatus[1][1];
		int pos12 = GameBoardTTT.gameStatus[1][2];
		int pos20 = GameBoardTTT.gameStatus[2][0];
		int pos21 = GameBoardTTT.gameStatus[2][1];
		int pos22 = GameBoardTTT.gameStatus[2][2];

		if (pos00 == pos01 && pos00 == pos02 && pos00 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S1, GameBoardTTT.S2, GameBoardTTT.S3);
			Thread.sleep(350);
			show(GameBoardTTT.S1, GameBoardTTT.S2, GameBoardTTT.S3);
		}

		if (pos10 == pos11 && pos10 == pos12 && pos10 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S4, GameBoardTTT.S5, GameBoardTTT.S6);
			Thread.sleep(350);
			show(GameBoardTTT.S4, GameBoardTTT.S5, GameBoardTTT.S6);
		}

		if (pos20 == pos21 && pos20 == pos22 && pos20 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S7, GameBoardTTT.S8, GameBoardTTT.S9);
			Thread.sleep(350);
			show(GameBoardTTT.S7, GameBoardTTT.S8, GameBoardTTT.S9);
		}

		if (pos00 == pos10 && pos00 == pos20 && pos00 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S1, GameBoardTTT.S4, GameBoardTTT.S7);
			Thread.sleep(350);
			show(GameBoardTTT.S1, GameBoardTTT.S4, GameBoardTTT.S7);
		}

		if (pos01 == pos11 && pos01 == pos21 && pos01 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S2, GameBoardTTT.S5, GameBoardTTT.S8);
			Thread.sleep(350);
			show(GameBoardTTT.S2, GameBoardTTT.S5, GameBoardTTT.S8);
		}

		if (pos02 == pos12 && pos02 == pos22 && pos02 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S3, GameBoardTTT.S6, GameBoardTTT.S9);
			Thread.sleep(350);
			show(GameBoardTTT.S3, GameBoardTTT.S6, GameBoardTTT.S9);
		}

		if (pos00 == pos11 && pos00 == pos22 && pos00 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S1, GameBoardTTT.S5, GameBoardTTT.S9);
			Thread.sleep(350);
			show(GameBoardTTT.S1, GameBoardTTT.S5, GameBoardTTT.S9);
		}

		if (pos20 == pos11 && pos02 == pos20 && pos20 != 0) {
			Thread.sleep(600);
			hide(GameBoardTTT.S7, GameBoardTTT.S5, GameBoardTTT.S3);
			Thread.sleep(350);
			show(GameBoardTTT.S7, GameBoardTTT.S5, GameBoardTTT.S3);
		}

	}

}
