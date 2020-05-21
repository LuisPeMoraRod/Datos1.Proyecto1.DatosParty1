package com.Datos1.Proyecto1.GameBoard;

public class GreenBox implements Box{
	/**
	 * Public class. Implements the interface Box. Form part of an factory pattern design implementation.
	 * Creates blue boxes
	 */
	
	public Square solidSquare;
	public Square edgedSquare;
	public GreenBox() {
		solidSquare= new Square(green);
		edgedSquare = new Square(green, true);
	}
	
	@Override
	public Square getBox() {
		// TODO Auto-generated method stub
		return solidSquare;
	}

	@Override
	public Square getEdgedBox() {
		// TODO Auto-generated method stub
		return edgedSquare;
	}
}
