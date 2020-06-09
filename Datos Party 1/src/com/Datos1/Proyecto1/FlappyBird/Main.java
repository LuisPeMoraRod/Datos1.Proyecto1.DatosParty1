package com.Datos1.Proyecto1.FlappyBird;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.LinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularDoublyLinkedList players = new CircularDoublyLinkedList();
		
		players.insertHead(new Player("Sofi",1));
		FlappyBirdLauncher fb = new FlappyBirdLauncher(players);
		try {
			fb.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
