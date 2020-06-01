package com.Datos1.Proyecto1.GameBoard;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Square extends Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Color color;
	public int width, height;
	private int transparency;
	private boolean empty;

	public Square(Color color) {
		this.color = color;
		width = 65;
		height = 65;
		transparency = 10;
		empty=false;
	}

	public Square(Color color, boolean empty) {
		this.color = color;
		width = 65;
		height = 65;
		transparency = 10;
		this.empty = empty;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		float alpha = (float) ((transparency) * 0.1f);
		AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alcom);
		g2d.setColor(color);
		if (empty) {
			Stroke stroke1 = new BasicStroke((float) 3.0);
			g2d.setStroke(stroke1);
			g2d.drawRect(0, 0, width, height);
		}else {
			g2d.fillRect(0, 0, width, height);
		}
	}

}
