package com.Datos1.Proyecto1.GameBoard;

public class Queue <T>{
	private LinkedList list = new LinkedList();
	private Node rear;
	private Node front;
	private int size;
	
	public Queue() {
		rear=list.head;
		front = list.head;
		
	}
	
}
