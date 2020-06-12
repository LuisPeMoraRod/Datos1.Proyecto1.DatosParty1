package com.Datos1.Proyecto1.GameBoard;

import javax.swing.JPanel;

import com.Datos1.Proyecto1.Start.Main;

public class DuelButton extends MiniGameButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuelButton(JPanel canvas, Node player1, Node player2) {
		super(canvas, player1, player2);
		path = "image/duel.png";
	}
	
	@Override 
	public void startMiniGame() {
		GameBoardLauncher.window.setVisible(false);
		GameBoard.newMiniGame = false;
		canvas.remove(this);
		miniGameId = random.nextInt(3);
		switch (miniGameId) {
		case 0:
			Main.minigamesObservable.set4IL(true);//sets observable flag to start four in line
			break;
		case 1:
			Main.minigamesObservable.setTTT(true);//sets observable flag to start tic tac toe
			break;
		case 2:
			Main.minigamesObservable.setFB(true);//sets observable flag to star flappy bird
			break;
		default:
			break;
		}
	}

}
