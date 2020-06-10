package com.Datos1.Proyecto1.FourInLine;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;
import com.Datos1.Proyecto1.GameBoard.Player;

public class Main {
	static CircularDoublyLinkedList list;
	public static void main(String[] args) {
		list = new CircularDoublyLinkedList();
		list.insertHead(new Player("Sofi", 1));
		list.insertEnd(new Player("Luis", 2));
		list.insertEnd(new Player("Moni", 3));
		list.insertEnd(new Player("Camila", 3));
		
		FourInLineLauncher ttt = new FourInLineLauncher(list);
		try {
			ttt.launch();
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
