package com.Datos1.Proyecto1.GameBoard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Color color;
	public int width,height;

	public Square(Color color) {
		this.color = color;
		width=80;height=80;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		g2d.fillRect(0, 0, width, height);
	}

}
