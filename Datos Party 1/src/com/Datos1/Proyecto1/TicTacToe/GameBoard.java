package com.Datos1.Proyecto1.TicTacToe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class GameBoard extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameBoard() {
		setPanel();
		
	}
	
	public void setPanel() {
		setLayout(new FlowLayout());
		setBackground(Color.CYAN);	
		add(new Squares());
		
		}
	public void drawSquare() {
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.black);
		g2.fill(new Rectangle2D.Double(20,0,20,20));
		
	}
}
