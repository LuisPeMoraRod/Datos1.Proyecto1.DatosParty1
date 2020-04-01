package com.Datos1.Proyecto1.FlappyBird;

import javax.swing.JFrame;

public class MainFlappyBird {
	public static int players=3;
	
	public MainFlappyBird(int players) {
		MainFlappyBird.players=players;
	}
	
	public static void main (String[] args) {
		MainFlappyBird main=new MainFlappyBird(players);
		Window window=new Window(players);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
