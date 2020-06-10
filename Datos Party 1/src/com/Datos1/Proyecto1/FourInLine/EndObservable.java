package com.Datos1.Proyecto1.FourInLine;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class EndObservable extends Observable{
	
	private boolean end;
	public EndObservable (boolean end) {
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
