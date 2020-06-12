package com.Datos1.Proyecto1.Start;

import com.Datos1.Proyecto1.GameBoard.*;

import com.Datos1.Proyecto1.FlappyBird.*;
import com.Datos1.Proyecto1.FourInLine.*;
import com.Datos1.Proyecto1.TicTacToe.*;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Main implements Observer {
	public static CircularDoublyLinkedList players;
	public static int numberPlayers;
	public static GameBoardLauncher gameBoardWindow;
	public static Main main;
	public static MinigamesObservable minigamesObservable;
	//flags to initialize the mini games
	public static boolean flappybird, ticTacToe, fourInLine;
	public static boolean duelFlappybird, duelTicTacToe, duelFourInLine;
	
	public Main() {
		minigamesObservable = new MinigamesObservable();
		minigamesObservable.addObserver(this);
		flappybird = false;
		ticTacToe = false;
		fourInLine = false;
		duelFlappybird = false;
		duelTicTacToe = false;
		duelFourInLine = false;
		}
	

	public static void main(String[] args) throws IOException {
		main = new Main();
		main.startGame();
		while(true) {
			System.out.println(".");
			if (flappybird) {
				main.executeFB(players);
				flappybird=false;
			}else if (ticTacToe) {
				main.executeTTT(players);
				ticTacToe = false;
			}else if (fourInLine) {
				main.execute4IL(players);
				fourInLine = false;
			}
			//if required, execute duel minigames
			else if (duelFlappybird) {
				
				main.executeFB(minigamesObservable.getPlayers());
				duelFlappybird = false;
			}else if (duelTicTacToe) {
				
				main.executeTTT(minigamesObservable.getPlayers());
				duelTicTacToe = false;
			}else if (duelFourInLine) {
				
				main.execute4IL(minigamesObservable.getPlayers());
				duelFourInLine = false;
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
	
	/**
	 * Runs flappy bird minigame
	 */
	public void executeFB(CircularDoublyLinkedList players) {
		FlappyBirdLauncher fb = new FlappyBirdLauncher(players);

		try {
			fb.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Runs tic tac toe minigame
	 */
	public void executeTTT(CircularDoublyLinkedList players) {
		TicTacToeLauncher ttt = new TicTacToeLauncher(players);
		try {
			ttt.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Runs four in line minigame
	 */
	public void execute4IL(CircularDoublyLinkedList players) {
		FourInLineLauncher ttt = new FourInLineLauncher(players);
		try {
			ttt.launch();
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
		}else if (minigamesObservable.getTTT()) {
			ticTacToe = true;
			minigamesObservable.setTTT(false);
		}else if (minigamesObservable.get4IL()) {
			fourInLine = true;
			minigamesObservable.set4IL(false);
		}
		
		//activate duels in while true
		else if (minigamesObservable.getDuelFB()) {
			duelFlappybird = true;
		}else if (minigamesObservable.getDuelTTT()) {
			duelTicTacToe = true;
		}else if (minigamesObservable.getDuel4IL()) {
			duelFourInLine = true;
		}
	}
}
