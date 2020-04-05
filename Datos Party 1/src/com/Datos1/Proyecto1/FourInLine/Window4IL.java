package com.Datos1.Proyecto1.FourInLine;

import javax.swing.JFrame;

public class Window4IL extends JFrame{
	private int width=800;
	private int height=800;
	GameBoard4IL canvas;
	public Window4IL(String player1,String player2) {
		createWindow();
		canvas=new GameBoard4IL(player1,player2);
		add(canvas);
	}

public void createWindow() {
	setSize(width,height);
	setTitle("Four In Line");
	setLocationRelativeTo(null);
	setResizable(false);
	}
}
