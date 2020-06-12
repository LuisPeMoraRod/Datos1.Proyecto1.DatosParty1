package com.Datos1.Proyecto1.GameBoard;

public class GameBoardLauncher {

	CircularDoublyLinkedList players;
	public static Window window;

	public GameBoardLauncher(CircularDoublyLinkedList players){
		this.players = players;
	}
	
	public void launchGame() {


		window= new Window(players);
		window.setVisible(true);
	}
}