package com.Datos1.Proyecto1.Start;

import com.Datos1.Proyecto1.FlappyBird.*;
import com.Datos1.Proyecto1.GameBoard.*;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Main implements Observer {
	public static CircularDoublyLinkedList players;
	public static int numberPlayers;
	public static GameBoardLauncher gameBoardWindow;
	public static Main main;
	public static MinigamesObserver minigamesObservable;
	public static boolean flappybird;
	
	public Main() {
		minigamesObservable = new MinigamesObserver();
		minigamesObservable.addObserver(this);
		flappybird = false;
		}
	

	public static void main(String[] args) throws IOException {
		main = new Main();
		main.startGame();
		while(true) {
			System.out.println("validating minigame flag");
			if (flappybird) {
				main.executeFB();
				flappybird=false;
			}
		}
		
	}

	public void startGame() throws IOException {
		String namePlayer1, namePlayer2, namePlayer3, namePlayer4;

		StartWindow startWindow = new StartWindow();
		startWindow.createWindow();

		boolean startGame = false;

		while (!startGame) {
			System.out.println("Main");
			if (startWindow.startBoard.endStartWindow) {
				startGame = true;
			}
		}

		namePlayer1 = startWindow.startBoard.getNamePlayer1();
		namePlayer2 = startWindow.startBoard.getNamePlayer2();
		namePlayer3 = startWindow.startBoard.getNamePlayer3();
		namePlayer4 = startWindow.startBoard.getNamePlayer4();

		numberPlayers = startWindow.startBoard.getNumberPlayers();

		players = new CircularDoublyLinkedList();
		System.out.println(numberPlayers);

		for (int i = 1; i <= numberPlayers; i++) {

			if (i == 1) {
				players.insertHead(new Player(namePlayer1, i));
			}

			if (i == 2) {
				players.insertEnd(new Player(namePlayer2, i));
			}

			if (i == 3) {
				players.insertEnd(new Player(namePlayer3, i));

			}
			if (i == 4) {
				players.insertEnd(new Player(namePlayer4, i));
			}

		}

		if (startGame) {

			startWindow.dispose();

			gameBoardWindow = new GameBoardLauncher(players);
			gameBoardWindow.launchGame();

		}
	}
	
	public void executeFB() {
		FlappyBirdLauncher fb = new FlappyBirdLauncher(players);

		try {
			fb.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (minigamesObservable.getFB()) {
			flappybird = true;
			minigamesObservable.setFB(false); //changes value of observable FB
		}
	}
}
