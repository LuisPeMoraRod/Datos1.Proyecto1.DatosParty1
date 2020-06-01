package com.Datos1.Proyecto1.GameBoard;

public class CircularDoublyLinkedList {
	protected Node start;
	protected Node end;
	public int size;

	/**
	 * Constructor method
	 */
	public CircularDoublyLinkedList() {
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
	 * @param i      : int
	 */
	public void insertHead(Box newBox, int i, int j) {
		// Node newNode = new Node(newBox, null, null, id);
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();
		if (start == null) {
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			start = newNode;
			end = start;
		} else {
			newNode.setNext(start);
			newNode.setPrev(end);
			start.setPrev(newNode);
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
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			start = newNode;
			end = start;
		} else {
			newNode.setNext(start);
			newNode.setPrev(end);
			start.setPrev(newNode);
			start = newNode;
			end.setNext(start);
		}

		size++;
	}


	/**
	 * Public method. Inserts a node at the very end of the doubly linked list.
	 * 
	 * @param newBox : Box
	 * @param id     : int
	 */
	public void insertEnd(Box newBox, int i, int j) {
		// Node newNode = new Node(newBox, null, null, id);
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();

		if (isEmpty()) {
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			start = newNode;
			end = start;
		} else {
			end.setNext(newNode);
			newNode.setPrev(end);
			newNode.setNext(start);
			end = newNode;
			start.setPrev(end);
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
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			start = newNode;
			end = start;
		} else {
			end.setNext(newNode);
			newNode.setPrev(end);
			newNode.setNext(start);
			end = newNode;
			start.setPrev(end);
		}
		size++;

	}

	/**
	 * Public method. Inserts a node in a certain index
	 * 
	 * @param index  : int
	 * @param newBox : Box
	 * @param id     : int
	 */
	public void insert(Box box, int index, int i, int j) {
		// Node newNode = new Node(box,null,null,id);
		Node newNode = Node.builder().withBox(box).withIndex(i, j).build();

		if (index == 0) {
			insertHead(box, i, j);
			return;
		}

		Node pointer = start;
		for (int i1 = 1; i1 < size; i1++) {
			if (i1 == index) {
				Node temp = pointer.getPrev();
				pointer.setPrev(newNode);
				newNode.setNext(pointer);
				newNode.setPrev(temp);
				temp.setNext(newNode);

			}
			pointer = pointer.getNext();
		}
		size++;
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
			while (cont < i && pointer != end.getNext()) {
				pointer = pointer.getNext();
				cont++;
			}
			return pointer;
		}
		return null;

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
			}
			else{
				return pointer.box.getBox();
			}
		}else {return null;}
	}
}
