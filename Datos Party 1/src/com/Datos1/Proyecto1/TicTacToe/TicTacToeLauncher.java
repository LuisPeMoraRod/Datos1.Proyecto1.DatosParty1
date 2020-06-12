package com.Datos1.Proyecto1.TicTacToe;

import com.Datos1.Proyecto1.GameBoard.*;
import com.Datos1.Proyecto1.Results.ResultsFB;
import com.Datos1.Proyecto1.Results.ResultsTTT;
import com.Datos1.Proyecto1.Start.Main;
import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class TicTacToeLauncher implements Observer {

	/**
	 * Main method that creates the window object
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020 {@link WindowTTT}
	 * @param args
	 */

	static boolean startPlaying = false;
	private LinkedList players;
	private EndObservableTTT observable;
	private WindowTTT tictactoe;
	private int gamesCont = 0;
	private int games;
	private Player[] newGame;
	private Player[] game0 = new Player[2];
	private Player[] game1 = new Player[2];
	private Player[] game2 = new Player[2];
	private Player[] game3 = new Player[2];
	private Player[] game4 = new Player[2];
	private Player[] game5 = new Player[2];
	private Player[][] gamesArray = new Player[6][2];

	public TicTacToeLauncher(CircularDoublyLinkedList players) {
		this.players = circularToSimple(players);// BubbleSort logic requires a simple linked list
		this.players = new BubbleSort(this.players).execute2(); // bubble sorts the list considering the amount of
																// coins
		observable = new EndObservableTTT(false);
		observable.addObserver(this);
		setGamesAmount(this.players);

	}

	public void launch() throws IOException {

		String pathLogo = "images/tttLogo.png";
		String pathEnterPress = "images/enterPress.png";
		String pathSpacePress = "images/spacePress.png";
		String pathInstructions = "images/tttInstructions.png";
		String pathBackground = "images/Wallpaper.jpg";

		Cover tttCover = new Cover(pathLogo, pathBackground, pathEnterPress, pathSpacePress, pathInstructions);
		tttCover.createWindow();

		while (!startPlaying) {

			System.out.println("while");

			if (CoverEvent.closeCover) {
				startPlaying = true;
			}
		}

		
		if (startPlaying) {
			tttCover.getWindow().setVisible(false);
			tttCover.getWindow().dispose();
			tournament(players);
			newGame = game0;
			game(newGame);
			gamesCont++; // first game

		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (observable.getEnd()) {

			if (gamesCont < games) {
				tictactoe.dispose();
				observable.setEnd(false);
				newGame = gamesArray[gamesCont];
				try {
					game(newGame);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gamesCont++;

			} else { //end of the game
				tictactoe.dispose();
				observable.setEnd(false);
				//sorts by mini game points
				players= new BubbleSort(players).execute();
				
				
				try {
					ResultsTTT resultBoard = new ResultsTTT(players); //displays results window
				} catch (IOException e) {
					e.printStackTrace();
				}
				for (int i = 0; i< players.getSize();i++) {
					players.getNode(i).getPlayer().setPoints(0);
				}

			}
		}

	}

	public LinkedList circularToSimple(CircularDoublyLinkedList list) {
		LinkedList simple = new LinkedList();
		Node pointer = list.getNode(0);
		for (int i = 0; i < list.getSize(); i++) {
			simple.insertHead(pointer.getPlayer());
			pointer = pointer.getNext();
		}

		return simple;
	}

	/**
	 * Defines the players that will play in every match
	 * @param players
	 */
	public void tournament(LinkedList players) {
		switch (players.getSize()) {
		case 2:
			game0[0] = players.getNode(0).getPlayer();
			game0[1] = players.getNode(1).getPlayer();
			gamesArray[0] = game0;
			break;
		case 3:
			game2[0] = players.getNode(0).getPlayer();
			game2[1] = players.getNode(1).getPlayer();
			gamesArray[2] = game2;

			game1[0] = players.getNode(0).getPlayer();
			game1[1] = players.getNode(2).getPlayer();
			gamesArray[1] = game1;

			game0[0] = players.getNode(1).getPlayer();
			game0[1] = players.getNode(2).getPlayer();
			gamesArray[0] = game0;

			break;
		case 4:

			game0[0] = players.getNode(0).getPlayer();
			game0[1] = players.getNode(3).getPlayer();
			gamesArray[0] = game0;

			game1[0] = players.getNode(1).getPlayer();
			game1[1] = players.getNode(2).getPlayer();
			gamesArray[1] = game1;

			game2[0] = players.getNode(0).getPlayer();
			game2[1] = players.getNode(1).getPlayer();
			gamesArray[2] = game2;

			game3[0] = players.getNode(2).getPlayer();
			game3[1] = players.getNode(3).getPlayer();
			gamesArray[3] = game3;

			game4[0] = players.getNode(0).getPlayer();
			game4[1] = players.getNode(2).getPlayer();
			gamesArray[4] = game4;

			game5[0] = players.getNode(1).getPlayer();
			game5[1] = players.getNode(3).getPlayer();
			gamesArray[5] = game5;

		default:
			break;
		}
	}

	/**
	 * Lunches one tic tac toe match
	 * 
	 * @param game
	 * @throws IOException
	 */
	public void game(Player[] game) throws IOException {
		tictactoe = new WindowTTT(game[0], game[1], observable);
		tictactoe.setVisible(true);
		tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setGamesAmount(LinkedList players) {
		switch (players.getSize()) {
		case 2:
			games = 1;
			break;
		case 3:
			games = 3;
			break;
		case 4:
			games = 6;
			break;

		default:
			break;
		}
	}

}