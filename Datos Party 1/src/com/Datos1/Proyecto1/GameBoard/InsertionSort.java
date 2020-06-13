package com.Datos1.Proyecto1.GameBoard;

public class InsertionSort {
	/**
	 * Public class. Bubble sorting for a players object linked list
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 8/6/2020
	 */

	private Node first;
	private LinkedList list;

	public InsertionSort(LinkedList list) {
		this.list = list;
		this.first = list.getHead();
	}

	/**
	 * Sorts list considering the points of every player
	 * @return list : LinkedList
	 */
	public LinkedList execute() {
		Node pointer = first;
		Node reference = first;
		for (int i = 0; i < list.getSize(); i++) {

			while (pointer!= null) {
				if (pointer.getPlayer().getPoints() > reference.getPlayer().getPoints()) {
					Player playerSwap = pointer.getPlayer();
					pointer.setPlayer(reference.getPlayer());
					reference.setPlayer(playerSwap);
				}
				pointer=pointer.getNext();
			}
			reference = reference.getNext();
			pointer = reference;
		}

		return list;
	}
	
	/**
	 * Sorts list considering the coins of every player
	 * @return list : LinkedList
	 */
	public LinkedList execute2() {
		Node pointer = first;
		Node reference = first;
		for (int i = 0; i < list.getSize(); i++) {

			while (pointer!= null) {
				if (pointer.getPlayer().getCoins() > reference.getPlayer().getCoins()) {
					Player playerSwap = pointer.getPlayer();
					pointer.setPlayer(reference.getPlayer());
					reference.setPlayer(playerSwap);
				}
				pointer=pointer.getNext();
			}
			reference = reference.getNext();
			pointer = reference;
		}

		return list;
	}


}
