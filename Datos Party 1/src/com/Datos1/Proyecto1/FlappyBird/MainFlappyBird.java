package com.Datos1.Proyecto1.FlappyBird;

import javax.swing.JFrame;

public class MainFlappyBird {
	public static int players;
	
	public MainFlappyBird(int players) {
		MainFlappyBird.players=players;
	}
	
	public static void main (String[] args) {
		MainFlappyBird main=new MainFlappyBird(1);
		Window window=new Window(3);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
