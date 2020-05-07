package com.Datos1.Proyecto1.GameBoard;

public class GreenBox implements Box{
	/**
	 * Public class. Implements the interface Box. Form part of an factory pattern design implementation.
	 * Creates blue boxes
	 */
	private static final long serialVersionUID = 1L;
	public Square square;
	public GreenBox() {
		square= new Square(green);
	}
	
	@Override
	public Square getBox() {
		// TODO Auto-generated method stub
		return square;
	}
}
