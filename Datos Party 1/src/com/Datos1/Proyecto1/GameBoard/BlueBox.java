package com.Datos1.Proyecto1.GameBoard;


public class BlueBox implements Box {
	/**
	 * Public class. Implements the interface Box. Form part of an factory pattern design implementation.
	 * Creates blue boxes
	 */
	
	public Square solidSquare;
	public Square edgedSquare;
	
	/**
	 * Constructor method. Sets solidSquare as a filled square and edgedSqaure as an empty square.
	 */
	public BlueBox() {
		solidSquare= new Square(blue);
		edgedSquare = new Square(blue, true);
	}
	
	@Override
	public Square getBox() {
		// TODO Auto-generated method stub
		return solidSquare;
	}
	
	@Override
	public Square getEdgedBox() {
		return edgedSquare;
	}
}
