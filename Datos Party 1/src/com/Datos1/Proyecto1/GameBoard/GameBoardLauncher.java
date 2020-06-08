package com.Datos1.Proyecto1.GameBoard;

public class GameBoardLauncher {

	CircularDoublyLinkedList players;

	public GameBoardLauncher(CircularDoublyLinkedList players){
		this.players = players;
	}
	
	public void launchGame() {


		Window window= new Window(players);
		window.setVisible(true);
	}
}