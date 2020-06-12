package com.Datos1.Proyecto1.GameBoard;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class MinigamesObservable extends Observable{

	private boolean flappyBird = false;
	private boolean ticTacToe = false;
	private boolean fourInLine = false;
	
	//Flags for starting the duel
	private boolean duelFlappyBird = false;
	private boolean duelTicTacToe = false;
	private boolean duelFourInLine = false;
	
	public boolean getFB() {
		return this.flappyBird;
	}
	
	public void setFB(boolean flappybird) {
		this.flappyBird=flappybird;
		setChanged();
		notifyObservers();
	}
	
	public boolean getTTT() {
		return this.ticTacToe;
	}
	
	public void setTTT(boolean ticTacToe) {
		this.ticTacToe = ticTacToe;
		setChanged();
		notifyObservers();
	}
	
	public boolean get4IL() {
		return this.fourInLine;
	}
	
	public void set4IL(boolean fourInLine) {
		this.fourInLine = fourInLine;
		setChanged();
		notifyObservers();
	}
	
	public boolean getDuelFB() {
		return this.duelFlappyBird;
	}
	
	public void setDuelFB(boolean duelFlappyBird) {
		this.duelFlappyBird = duelFlappyBird;
	}
	
	public boolean getDuelTTT() {
		return this.duelTicTacToe;
	}
	
	public void setDuelTT(boolean duelTicTacToe) {
		this.duelTicTacToe = duelTicTacToe;
	}
	
	public boolean getDuel4IL() {
		return this.duelFourInLine;
	}
	
	public void setDuel4IL(boolean duelFourInLine) {
		this.duelFourInLine = duelFourInLine;
	}
}
