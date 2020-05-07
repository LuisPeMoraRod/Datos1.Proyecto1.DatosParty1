package com.Datos1.Proyecto1.GameBoard;

public class YellowBox implements Box{
	/**
	 * Public class. Implements the interface Box. Form part of an factory pattern design implementation.
	 * Creates blue boxes
	 */
	
	public Square square;
	public YellowBox() {
		square= new Square(yellow);
	}
	
	@Override
	public Square getBox() {
		// TODO Auto-generated method stub
		return square;
	}
}
