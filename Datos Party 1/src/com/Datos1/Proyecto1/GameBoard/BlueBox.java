package com.Datos1.Proyecto1.GameBoard;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BlueBox implements Box {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
