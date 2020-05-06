package com.Datos1.Proyecto1.GameBoard;

public class LinkedCircularList {
	Node first = null;
	Node last = null;
	int size = 0;

	public class Node {

		public Box box;
		public Node next;
		public int id;

		public Node(Box box, int id) {
			this.box = box;
			this.next = null;
			this.id = id;
		}

	}

	/**
	 * Public method. Asks if the linked list is empty
	 * 
	 * @return true if the first node doesn't point to any other node
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Public method. Returns the amount of nodes the list possess
	 * 
	 * @return size : int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Public method. Inserts a note at the very end of the linked circular list.
	 * 
	 * @param newBox : Box
	 */
	public void insertEnd(Box newBox, int id) {
		Node newNode = new Node(newBox, id);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
			last.next = first;
		} else {
			last.next = newNode;
			newNode.next = first;
			last = newNode;
		}
		size++;

	}

	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * 
	 * @param newBox : Box
	 */
	public void insertHead(Box newBox, int id) {
		Node newNode = new Node(newBox, id);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
			last.next = first;
		} else {
			newNode.next = first;
			first = newNode;
			last.next = first;
		}

		size++;
	}

	/**
	 * Public method. Inserts a node in a certain index
	 * 
	 * @param index  : int
	 * @param newBox : Box
	 */
	public void insert(int index, Box newBox, int id) {
		Node newNode = new Node(newBox, id);
		if (index >= 0 && index <= size) {
			Node pointer = first;
			int cont = 0;
			if (index == 0) {
				insertHead(newBox, id);
			} else if (index == size) {
				insertEnd(newBox, id);
			} else {
				while (cont < index - 1) { // Runs through the list until the component before the index is reached
					cont++;
					pointer = pointer.next;
				}
				Node nextNode = pointer.next;// Copy of the next pointer's next element
				pointer.next = newNode;
				newNode.next = nextNode;
			}
			size++;
		}

	}

	/**
	 * Public method. Returns the component of the list's square requested by its index.
	 * 
	 * @param i : int, index of the element of the list that is returned.
	 * @return Square type object
	 */
	public Square get(int i){
		if (i >= 0 && i < size) {
			Node pointer = first;
			int cont = 0;
			while (cont < i && pointer != last) {
				pointer = pointer.next;
				cont++;
			}
			return pointer.box.getBox();
		}else {
			return null;
		}
		
	}
	
	/**
	 * Public method. Returns the component list requested by its index.
	 * 
	 * @param i : int, index of the element of the list thats returned
	 * @return pointer : Node
	 */
	public Node getNode(int i){
		if (i >= 0 && i < size) {
			Node pointer = first;
			int cont = 0;
			while (cont < i && pointer != last) {
				pointer = pointer.next;
				cont++;
			}
			return pointer;
		}
		return null;
		
	}

}
