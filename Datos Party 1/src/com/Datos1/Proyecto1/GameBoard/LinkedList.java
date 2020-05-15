package com.Datos1.Proyecto1.GameBoard;

public class LinkedList {
	Node head;
	
	
	public LinkedList() {
		head=null;
	}
	
	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * @param newBox : Box
	 * @param id : id
	 */
	public void insertHead(Box newBox, int id) {
		Node newNode = Node.builder()
				.withBox(newBox)
				.withId(id)
				.build();
		newNode.setNext(head);
		head = newNode;
	}
	
	/**
	 * Public method. Inserts a node at the very end of the linked list.
	 * @param newBox : Box
	 * @param id : int
	 */
	public void insertEnd(Box newBox, int id) {
		Node newNode = Node.builder()
				.withBox(newBox)
				.withId(id)
				.build();
		Node pointer = head;
		while(pointer.getNext()!=null) {
			pointer=pointer.getNext();
		}
	
		pointer.setNext(newNode);
	}
	
	/**
	 * Public method. Inserts a node in a certain index
	 * @param index : int
	 * @param newBox : Box
	 * @param id : int
	 */
	public void insert (int index, Box newBox, int id) {
		Node newNode = Node.builder()
				.withBox(newBox)
				.withId(id)
				.build();
		if (head == null) {
			head = newNode;
		}else {
			int cont = 0;
			Node pointer = head;
			while (cont< index && pointer.getNext() != null) {
				cont++;
				pointer= pointer.getNext();
			}
			newNode.setNext(pointer.getNext());
			pointer.setNext(newNode);
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
			pointer=pointer.getNext();
			cont++;
		}
		return pointer.box.getBox();
	}

}
