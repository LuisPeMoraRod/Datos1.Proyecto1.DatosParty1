package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.LinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularDoublyLinkedList players = new CircularDoublyLinkedList();

		players.insertHead(new Player("Sofi", 1));
		//players.insertEnd(new Player("Luis", 2));
		//players.insertEnd(new Player("Moni", 3));
		//players.insertEnd(new Player("Rob", 4));
		FlappyBirdLauncher fb = new FlappyBirdLauncher(players);

		try {
			fb.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 * Font[] fonts = ge.getAllFonts();
		 * 
		 * for (Font font : fonts) { System.out.print(font.getFontName() + " : ");
		 * System.out.println(font.getFamily()); }
		 */
	}

}
