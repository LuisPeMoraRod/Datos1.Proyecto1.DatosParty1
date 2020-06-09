package com.Datos1.Proyecto1.FlappyBird;

import com.Datos1.Proyecto1.GameBoard.BubbleSort;
import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.LinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;
import com.Datos1.Proyecto1.Results.*;
import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;

public class FlappyBirdLauncher {
	/**
	 * Main class
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 3/30/2020
	 */
	public static CircularDoublyLinkedList players;
	public static LinkedList results;
	static boolean startPlaying = false;

	public FlappyBirdLauncher(CircularDoublyLinkedList players) {
		this.players = players;
		results = new LinkedList();
	}

	public void launch () throws IOException {

		String pathLogo = "images/fBLogo.png";
		String pathEnterPress = "images/enterPress.png";
		String pathSpacePress = "images/spacePress.png";
		String pathInstructions = "images/fBInstructions.png";
		String pathBackground = "images/WallpaperFB.jpg";
		
		Cover fbCover = new Cover(pathLogo, pathBackground, pathEnterPress, pathSpacePress, pathInstructions);
		fbCover.createWindow();
		Window window = new Window(players);

		do {

			System.out.println("while");

			if (CoverEvent.closeCover) {
				startPlaying = true;
			}
		}while (!startPlaying);

		if (startPlaying) {

			fbCover.getWindow().setVisible(false);
			fbCover.getWindow().dispose();

			
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		boolean gameOver = false;
		while (!gameOver) {
			
			
				switch (players.getSize()) {
				case 1:
					System.out.println(Window.canvas1.gameOver);
					if (Window.canvas1.gameOver) {
						gameOver = true;
					}
					break;
				case 2:
					System.out.println(Window.canvas1.gameOver+" "+Window.canvas2.gameOver);
					if (Window.canvas1.gameOver && Window.canvas2.gameOver) {
						gameOver = true;
					}
					break;
				case 3:
					System.out.println(Window.canvas1.gameOver+" "+Window.canvas2.gameOver+" "+Window.canvas3.gameOver);
					if (Window.canvas1.gameOver && Window.canvas2.gameOver && Window.canvas3.gameOver) {
						gameOver = true;
					}
					break;
				case 4:
					System.out.println(Window.canvas1.gameOver+" "+Window.canvas2.gameOver+" "+Window.canvas3.gameOver+" "+Window.canvas4.gameOver);
					if (Window.canvas1.gameOver && Window.canvas2.gameOver && Window.canvas3.gameOver && Window.canvas4.gameOver) {
						gameOver = true;
					}
					break;

				default:
					break;
				}
		}
		window.dispose();
		
	
		results= new BubbleSort(results).execute();
		
		ResultsFB resultBoard = new ResultsFB(results);
		for (int i = 0; i< results.getSize();i++) {
			results.getNode(i).getPlayer().setPoints(0);
		}

	
		System.out.println("FB ended");
	}
	

}
