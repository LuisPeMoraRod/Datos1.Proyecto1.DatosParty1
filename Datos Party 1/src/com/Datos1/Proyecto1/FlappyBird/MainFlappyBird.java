package com.Datos1.Proyecto1.FlappyBird;

import javax.swing.JFrame;

public class MainFlappyBird {
	/**
	 * Main class
	 * @author Luis Pedro Morales Rodriguez
	 * @version 3/30/2020
	 */
	public static int players=3;
	
	public MainFlappyBird(int players) {
		MainFlappyBird.players=players;
	}
	
	/**
	 * Main method that creates the amount of windows required depending on the amount of players
	 * @param args
	 */
	public static void main (String[] args) {
		MainFlappyBird main=new MainFlappyBird(players);
		WindowFP window=new WindowFP(players);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

