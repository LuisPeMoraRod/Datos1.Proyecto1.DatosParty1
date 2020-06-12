package com.Datos1.Proyecto1.GameBoard;

public class LinkedList {
	Node head;
	int size;

	public LinkedList() {
		head = null;
	}

	public Node getHead() {
		return this.head;
	}
	
	
	public int getSize() {
		return this.size;
	}
	/**
	 * Public method. Inserts a node at the very beginning of the linked list.
	 * 
	 * @param newBox : Box
	 * @param id     : id
	 */
	public void insertHead(Box newBox, int i, int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();
		newNode.setNext(head);
		head = newNode;
		size++;
	}
	
	/**
	 * 	Inserts node at the beginning of linked list formed by players nodes
	 * @param player : Player
	 */
	public void insertHead(Player player) {
		Node newNode = Node.builder().withPlayer(player).build();
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	public void insertHead(Events events){
		Node newNode = Node.builder().withEvent(events).build();
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	/**
	 * Public method. Inserts a node at the very end of the linked list.
	 * 
	 * @param newBox : Box
	 * @param id     : int
	 */
	public void insertEnd(Box newBox, int i, int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();
		Node pointer = head;
		while (pointer.getNext() != null) {
			pointer = pointer.getNext();
		}

		pointer.setNext(newNode);
		size++;
	}

	
	
/**
 * 	Inserts node at the end of linked list formed by players nodes
 * @param player : Player
 */
	public void insertEnd(Player player) {
		Node newNode = Node.builder().withPlayer(player).build();
		Node pointer = head;
		while (pointer.getNext() != null) {
			pointer = pointer.getNext();
		}

		pointer.setNext(newNode);
		size++;
	}

	public void insertEnd(Events events) {
		Node newNode = Node.builder().withEvent(events).build();
		Node pointer = head;
		while (pointer.getNext() != null) {
			pointer = pointer.getNext();
		}

		pointer.setNext(newNode);
		size++;
	}

	/**
	 * Public method. Inserts a node in a certain index
	 * 
	 * @param index  : int
	 * @param newBox : Box
	 * @param id     : int
	 */
	public void insert(int index, Box newBox, int i, int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();
		if (head == null) {
			head = newNode;
		} else {
			int cont = 0;
			Node pointer = head;
			while (cont < index && pointer.getNext() != null) {
				cont++;
				pointer = pointer.getNext();
			}
			newNode.setNext(pointer.getNext());
			pointer.setNext(newNode);
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
			Node pointer = head;
			if (i == 0) {
				return pointer;
			}
			pointer = pointer.getNext();
			int cont = 1;
			while (cont < i && pointer != null) {
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
			Node pointer = head;
			int cont = 0;
			while (cont < i && pointer != null) {
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

	public void deleteElement(int i){
		if (i >= 0 && i < size) {
			Node current = head;
			Node currentNext = head.getNext();

			if (i == 0) {
				this.head = currentNext;
				size--;
			}
			else{
				int cont = 1;
				while (cont < i) {
					if(cont+1==i){
						current.setNext(currentNext.getNext());
						size--;
						break;
					}
					else{
						cont++;
					}
				}
			}


		}

	}

	public  void deleteFirst(){
		Node second = head.getNext();
		this.head = second;
	}

}
