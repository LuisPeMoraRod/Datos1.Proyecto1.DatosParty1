package com.Datos1.Proyecto1.TicTacToe;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class EndObservableTTT extends Observable{
	private boolean end;
	public EndObservableTTT (boolean end) {
		this.end = end;
	}
	
	public boolean getEnd() {
		return this.end;
	}
	
	public void setEnd(boolean end) {
		this.end = end;
		setChanged();
		notifyObservers();
	}
}
