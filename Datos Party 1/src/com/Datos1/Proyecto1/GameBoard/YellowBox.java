package com.Datos1.Proyecto1.GameBoard;

public class YellowBox implements Box{
	/**
	 * Public class. Implements the interface Box. Form part of an factory pattern design implementation.
	 * Creates blue boxes
	 */
	
	public Square solidSquare;
	public Square edgedSqaure;
	public YellowBox() {
		solidSquare= new Square(yellow);
		edgedSqaure = new Square(yellow, true);
	}
	
	@Override
	public Square getBox() {
		// TODO Auto-generated method stub
		return solidSquare;
	}

	@Override
	public Square getEdgedBox() {
		// TODO Auto-generated method stub
		return edgedSqaure;
	}
	
	
}
