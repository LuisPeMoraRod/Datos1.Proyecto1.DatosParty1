package com.Datos1.Proyecto1.FlappyBird;

import javax.swing.JFrame;

public class MainFlappyBird {
	/**
	 * Main class
	 * @author Luis Pedro Morales Rodriguez
	 * @version 3/30/2020
	 */
	public static int players=4;
	
	public MainFlappyBird(int players) {
		this.players=players;
	}
	
	public static void main (String[] args) {
		MainFlappyBird main=new MainFlappyBird(players);
		Window window=new Window(players);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

