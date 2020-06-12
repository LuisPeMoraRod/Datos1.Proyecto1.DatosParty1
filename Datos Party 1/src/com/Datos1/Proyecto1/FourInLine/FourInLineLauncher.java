package com.Datos1.Proyecto1.FourInLine;

import com.Datos1.Proyecto1.GameBoard.BubbleSort;
import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.GameBoard;
import com.Datos1.Proyecto1.GameBoard.LinkedList;
import com.Datos1.Proyecto1.GameBoard.Node;
import com.Datos1.Proyecto1.GameBoard.Player;
import com.Datos1.Proyecto1.Results.Results4IL;
import com.Datos1.Proyecto1.Start.Main;
import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class FourInLineLauncher implements Observer {
	/**
	 * Main method that creates the window object
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 4/5/2020
	 * @param args
	 *
	 */

	static boolean startPlaying = false;
	private LinkedList players;
	private EndObservable4IL observable;
	private Window4IL fourInLine;
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

	public FourInLineLauncher(CircularDoublyLinkedList players) {
		this.players = circularToSimple(players);// BubbleSort logic requires a simple linked list
		this.players = new BubbleSort(this.players).execute2(); // bubble sorts the list considering the amount of
																// coins
		observable = new EndObservable4IL(false);
		observable.addObserver(this);
		setGamesAmount(this.players);

	}

	public void launch() throws IOException {

		String pathLogo = "images/filLogo.png";
		String pathEnterPress = "images/enterContinue.png";
		String pathSpacePress = "images/spaceContinue.png";
		String pathInstructions = "images/filInstructions.png";
		String pathBackground = "images/filBackground.png";

		Cover filCover = new Cover(pathLogo, pathBackground, pathEnterPress, pathSpacePress, pathInstructions);
		filCover.createWindow();

		while (!startPlaying) {

			System.out.println("while");

			if (CoverEvent.closeCover) {
				startPlaying = true;
			}
		}

		if (startPlaying) {

			filCover.getWindow().setVisible(false);
			filCover.getWindow().dispose();

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
				fourInLine.dispose();
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
				fourInLine.dispose();
				observable.setEnd(false);
				//sorts by mini game points
				players= new BubbleSort(players).execute();
				
				
				try {
					Results4IL resultBoard = new Results4IL(players); //displays results window
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
		fourInLine = new Window4IL(game[0], game[1], observable);
		fourInLine.setVisible(true);
		fourInLine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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