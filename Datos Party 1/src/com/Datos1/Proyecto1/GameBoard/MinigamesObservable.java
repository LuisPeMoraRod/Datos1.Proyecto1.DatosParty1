package com.Datos1.Proyecto1.GameBoard;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class MinigamesObservable extends Observable{

	private boolean flappyBird = false;
	private boolean ticTacToe = false;
	private boolean fourInLine = false;
	
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
}
