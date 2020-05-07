package com.Datos1.Proyecto1.GameBoard;


public class BlueBox implements Box {
	/**
	 * Public class. Implements the interface Box. Form part of an factory pattern design implementation.
	 * Creates blue boxes
	 */
	
	public Square square;
	public BlueBox() {
		square= new Square(blue);
	}
	
	@Override
	public Square getBox() {
		// TODO Auto-generated method stub
		return square;
	}
}
