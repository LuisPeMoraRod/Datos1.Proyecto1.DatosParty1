package com.Datos1.Proyecto1.GameBoard;

import java.io.IOException;

import com.Datos1.Proyecto1.FlappyBird.FlappyBirdLauncher;

public class Main {
	public static Window window;
	public static void main (String[] args) {
		window= new Window();
		window.setVisible(true);
		boolean out= false;
		while (!out) {
			System.out.println(GameBoard.FB);
			if (GameBoard.FB) {
				window.setVisible(false);
				FlappyBirdLauncher fb = new FlappyBirdLauncher(2);
				try {
					fb.launch();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out=true;
			}
		}
	}
}