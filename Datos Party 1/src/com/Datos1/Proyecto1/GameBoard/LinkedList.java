package com.Datos1.Proyecto1.GameBoard;

public class LinkedList {
	Node head = null;
	private class Node {
		public Box box;
		public Node next = null;
		
		public Node(Box box) {
			this.box=box;
		}
	}
	
	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * @param newBox : Box
	 */
	public void insertHead(Box newBox) {
		Node newNode = new Node (newBox);
		newNode.next=head;
		head = newNode;
	}
	
	/**
	 * Public method. Inserts a note at the very end of the linked list.
	 * @param newBox : Box
	 */
	public void insertEnd(Box newBox) {
		Node newNode = new Node (newBox);
		Node pointer = head;
		while(pointer.next!=null) {
			pointer=pointer.next;
		}
	
		pointer.next = newNode;
	}
	
	/**
	 * Public method. Inserts a node in a certain index
	 * @param index : int
	 * @param newBox : Box
	 */
	public void insert (int index, Box newBox) {
		Node newNode = new Node (newBox);
		if (head == null) {
			head = newNode;
		}else {
			int cont = 0;
			Node pointer = head;
			while (cont< index && pointer.next != null) {
				cont++;
				pointer= pointer.next;
			}
			newNode.next=pointer.next;
			pointer.next=newNode;
		}
	}
	
	public Square get (int i) {
		Node pointer=head;
		int cont=0;
		while (cont<i && pointer != null) {
			pointer=pointer.next;
			cont++;
		}
		return pointer.box.getBox();
	}

}
