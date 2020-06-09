package com.Datos1.Proyecto1.TicTacToe;

import com.Datos1.Proyecto1.GameBoard.*;
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
	 * @version 25/3/2020 {@link Window}
	 * @param args
	 */

	static boolean startPlaying = false;
	private LinkedList players;
	private LinkedList sortedPlayers; // linked list sorted by the amount of coins gained
	private EndObservable observable;
	private Window tictactoe;

	public TicTacToeLauncher(CircularDoublyLinkedList players) {
		this.players = circularToSimple(players);
		sortedPlayers = new BubbleSort(this.players).execute2();
		observable = new EndObservable(false);
		observable.addObserver(this);

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
			tictactoe = new Window(sortedPlayers.getHead().getPlayer(), sortedPlayers.getNode(1).getPlayer(),
					observable);
			tictactoe.setVisible(true);
			tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (observable.getEnd()) {
			tictactoe.dispose();
			observable.setEnd(false);
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

	public void tournament(LinkedList players) {

	}

}