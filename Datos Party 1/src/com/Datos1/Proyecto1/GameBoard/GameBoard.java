package com.Datos1.Proyecto1.GameBoard;

import java.awt.Color;

import javax.swing.JPanel;

public class GameBoard extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String[] players;
	private Color lightYellow = new Color(250, 249, 222);
	
	public GameBoard() {
		setBackground(lightYellow);
	}

}
