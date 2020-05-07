package com.Datos1.Proyecto1.GameBoard;

public class LinkedList {
	Node head;
	private class Node {
		public Box box;
		public Node next;
		public int id;
		
		public Node(Box box, int id) {
			this.box=box;
			this.id=id;
			next=null;
		}
	}
	
	public LinkedList() {
		head=null;
	}
	
	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * @param newBox : Box
	 */
	public void insertHead(Box newBox, int id) {
		Node newNode = new Node (newBox, id);
		newNode.next=head;
		head = newNode;
	}
	
	/**
	 * Public method. Inserts a note at the very end of the linked list.
	 * @param newBox : Box
	 */
	public void insertEnd(Box newBox, int id) {
		Node newNode = new Node (newBox, id);
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
	public void insert (int index, Box newBox, int id) {
		Node newNode = new Node (newBox, id);
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
	
	/**
	 * Public method. Returns the component of the list's square requested by its index.
	 * 
	 * @param i : int, index of the element of the list that is returned.
	 * @return Square type object
	 */
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
