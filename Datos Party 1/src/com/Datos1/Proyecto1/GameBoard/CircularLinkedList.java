package com.Datos1.Proyecto1.GameBoard;

public class CircularLinkedList {
	protected Node start;
	protected Node end;
	public int size;

	public CircularLinkedList() {
		start = null;
		end = null;
		size = 0;
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
	 * Public method. Returns the amount of nodes the list possess
	 * 
	 * @return size : int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Public method. Inserts a note at the very end of the linked circular list.
	 * @param newBox : Box
	 */
	public void insertEnd(Box newBox, int i,int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i,j).withId(size).build();
		if (isEmpty()) {
			start = newNode;
			end = newNode;
			end.setNext(start);
		} else {
			end.setNext(newNode);
			newNode.setNext(start);
			end = newNode;
		}
		size++;

	}
	
	/**
	 * Public method. Inserts a note at the very end of the linked circular list.
	 * @param newPlayer : Player
	 */
	public void insertEnd(Player newPlayer) {
		Node newNode = Node.builder().withPlayer(newPlayer).withId(size).build();
		if (isEmpty()) {
			start = newNode;
			end = newNode;
			end.setNext(start);
		} else {
			end.setNext(newNode);
			newNode.setNext(start);
			end = newNode;
		}
		size++;

	}

	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * 
	 * @param newBox : Box
	 */
	public void insertHead(Box newBox, int i, int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i,j).withId(size).build();
		if (isEmpty()) {
			start = newNode;
			end = newNode;
			end.setNext(start);
		} else {
			newNode.setNext(start);
			start = newNode;
			end.setNext(start);
		}

		size++;
	}
	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * 
	 * @param newPlayer : Player
	 */
	public void insertHead(Player newPlayer) {
		Node newNode = Node.builder().withPlayer(newPlayer).withId(size).build();
		if (isEmpty()) {
			start = newNode;
			end = newNode;
			end.setNext(start);
		} else {
			newNode.setNext(start);
			start = newNode;
			end.setNext(start);
		}

		size++;
	}

	/**
	 * Public method. Inserts a node in a certain index
	 * 
	 * @param index  : int
	 * @param newBox : Box
	 */
	public void insert(int index, Box newBox, int i , int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i,j).withId(size).build();
		if (index >= 0 && index <= size) {
			Node pointer = start;
			int cont = 0;
			if (index == 0) {
				insertHead(newBox, i,j);
			} else if (index == size) {
				insertEnd(newBox, i, j);
			} else {
				while (cont < index - 1) { // Runs through the list until the component before the index is reached
					cont++;
					pointer = pointer.getNext();
				}
				Node nextNode = pointer.getNext();// Copy of the next pointer's next element
				pointer.setNext(newNode);
				newNode.setNext(nextNode);
			}
			size++;
		}

	}

	/**
	 * Public method. Returns the component of the list's square requested by its
	 * index.
	 * 
	 * @param i : int, index of the element of the list that is returned.
	 * @return Square type object
	 */
	public Square get(int i) {
		if (i >= 0 && i < size) {
			Node pointer = start;
			int cont = 0;
			while (cont < i && pointer != end) {
				pointer = pointer.getNext();
				cont++;
			}
			if (pointer.getHasPointer()) {
				return pointer.box.getEdgedBox();
			} else {
				return pointer.box.getBox();
			}
		} else {
			return null;
		}

	}

	/**
	 * Public method. Returns the component list requested by its index.
	 * 
	 * @param i : int, index of the element of the list thats returned
	 * @return pointer : Node
	 */
	public Node getNode(int i) {
		if (i >= 0 && i < size) {
			Node pointer = start;
			if (i==0) {
				return pointer;
			}
			pointer=pointer.getNext();
			int cont=1;
			while (cont < i && pointer != end) {
				pointer = pointer.getNext();
				cont++;
			}
			return pointer;
		}
		return null;

	}
	
	/**
	 * Public method. Prints the indexes i , j of all the nodes in the circular linked list.
	 */
	public void printIndexes () {
		Node pointer = start;
		System.out.println(pointer.getIndex().x+" "+pointer.getIndex().y);
		pointer = pointer.getNext();
		while (pointer != end.getNext()) {
			System.out.println(pointer.getIndex().x+" "+pointer.getIndex().y);
			pointer = pointer.getNext();
		}
		
	}

}
