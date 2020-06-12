package com.Datos1.Proyecto1.GameBoard;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class MinigamesObserver extends Observable{

	private boolean flappyBird = false;
	
	public boolean getFB() {
		return this.flappyBird;
	}
	
	public void setFB(boolean flappybird) {
		this.flappyBird=flappybird;
		setChanged();
		notifyObservers();
	}
}
