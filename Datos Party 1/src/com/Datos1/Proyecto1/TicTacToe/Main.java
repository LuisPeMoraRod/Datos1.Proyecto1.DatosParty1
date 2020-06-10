package com.Datos1.Proyecto1.TicTacToe;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularDoublyLinkedList list = new CircularDoublyLinkedList();
		list.insertHead(new Player("Sofi", 1));
		list.insertEnd(new Player("Luis", 2));
		list.insertEnd(new Player("Moni", 3));
		//list.insertEnd(new Player("Camila", 3));
		
		TicTacToeLauncher ttt = new TicTacToeLauncher(list);
		try {
			ttt.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
