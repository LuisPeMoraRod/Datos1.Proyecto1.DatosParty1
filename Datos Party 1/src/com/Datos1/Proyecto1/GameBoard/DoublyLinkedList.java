package com.Datos1.Proyecto1.GameBoard;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList.Node;

public class DoublyLinkedList {
	protected Node start;
	protected Node end;
	public int size;

	public class Node {
		public Box box;
		public Node next, prev;
		public int id;

		/**
		 * Constructor method
		 * 
		 * @param box
		 */
		public Node(Box box) {
			this.box = box;
			next = null;
			prev = null;
		}

		/**
		 * Constructor method
		 * 
		 * @param box  : Box
		 * @param next : Node
		 * @param prev : Node
		 */
		public Node(Box box, Node next, Node prev, int id) {
			this.box = box;
			this.next = next;
			this.prev = prev;
			this.id = id;
		}
	}

	/**
	 * Constructor method
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}

	/**
	 * Public method. Asks if the linked list is empty
	 * 
	 * @return true if the first node doesn't point to any other node
	 */
	public boolean isEmpty() {
		return start == null;
	}

	/**
	 * Public method. Returns the number of nodes that the linked list has
	 * 
	 * @return size : int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Public method. Inserts a node at the very beginning of the doubly linked
	 * list.
	 * 
	 * @param newBox : Box
	 * @param id     : id
	 */
	public void insertHead(Box newBox, int id) {
		Node newNode = new Node(newBox, null, null, id);
		if (isEmpty()) {
			start = newNode;
			end = newNode;
		} else {
			start.prev = newNode;
			newNode.next = start;
			start = newNode;
		}
		size++;
	}

	/**
	 * Public method. Inserts a node at the very end of the doubly linked list.
	 * 
	 * @param newBox : Box
	 * @param id     : int
	 */
	public void insertEnd(Box newBox, int id) {
		Node newNode = new Node(newBox, null, null, id);
		if (isEmpty()) {
			start = newNode;
			end = newNode;
		} else {
			end.next = newNode;
			newNode.prev = end;
			end = newNode;
		}
		size++;
	}

	/**
	 * Public method. Inserts a node in a certain index
	 * @param index : int
	 * @param newBox : Box
	 * @param id : int
	 */
	public void insert(Box newBox, int index, int id) {
		Node newNode = new Node(newBox, null, null, id);
		if (index == 0) {
			insertHead(newBox, id);
			return;
		}
		Node pointer = start;
		for (int i = 1; i < size; i++) {
			if (i == index) {
				Node aux = pointer.prev;
				aux.next = newNode;
				newNode.prev = aux;

				pointer.prev = newNode;
				newNode.next = pointer;
			}
			pointer = pointer.next;
		}
		size++;
	}
	
	/**
	 * Public method. Returns the component of the list's square requested by its index.
	 * 
	 * @param i : int, index of the element of the list that is returned.
	 * @return Square type object
	 */
	public Square get (int i) {
		Node pointer=start;
		int cont=0;
		while (cont<i && pointer != end) {
			pointer=pointer.next;
			cont++;
		}
		return pointer.box.getBox();
	}
	
	public void printList() {
		Node pointer=start;
		for (int i = 0 ; i<size; i++) {
			try {
				System.out.println(pointer.prev.id+"<---Nodo: "+pointer.id+"--->"+pointer.next.id);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			pointer=pointer.next;
		}
	}

}
