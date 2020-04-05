package com.Datos1.Proyecto1.FourInLine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JPanel;

public class GameBoard4IL extends JPanel{
	public String player1,player2;
	public GameBoard4IL(String player1, String player2) {
		this.player1=player1;
		this.player2=player2;
		setOpaque(true);
        setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponents(Graphics g) {
	}
	
}
