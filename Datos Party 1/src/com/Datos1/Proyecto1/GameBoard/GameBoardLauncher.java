package com.Datos1.Proyecto1.GameBoard;

public class GameBoardLauncher {

	String name1, name2, name3, name4;

	public GameBoardLauncher(String name1, String name2, String name3, String name4){
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
	}
	
	public void launchGame() {
		Window window= new Window(this.name1,this.name2,this.name3,this.name4);
		window.setVisible(true);
	}
}