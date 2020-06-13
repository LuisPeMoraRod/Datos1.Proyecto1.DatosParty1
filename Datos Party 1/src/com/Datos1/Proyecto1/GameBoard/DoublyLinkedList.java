package com.Datos1.Proyecto1.GameBoard;

public class DoublyLinkedList {
	protected Node start;
	protected Node end;
	private int size;

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
	public void insertHead(Box newBox, int i, int j) {
		// Node newNode = new Node(newBox, null, null, id);
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();

		if (isEmpty()) {
			start = newNode;
			end = newNode;
		} else {
			start.setPrev(newNode);
			newNode.setNext(start);
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
	public void insertEnd(Box newBox, int i, int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();
		if (isEmpty()) {
			start = newNode;
			end = newNode;
		} else {
			end.setNext(newNode);
			newNode.setPrev(end);
			end = newNode;
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
	public void insert(Box newBox, int index, int i, int j) {
		Node newNode = Node.builder().withBox(newBox).withIndex(i, j).build();
		if (index == 0) {
			insertHead(newBox, i, j);
			return;
		}
		Node pointer = start;
		for (int i1 = 1; i1 < size; i1++) {
			if (i1 == index) {
				Node aux = pointer.getPrev();
				aux.setNext(newNode);
				newNode.setPrev(aux);

				pointer.setPrev(newNode);
				newNode.setNext(pointer);
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
	public Square getBox(int i) {
		if (i >= 0 && i < size) {
			Node pointer = start;
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

	public void printList() {
		Node pointer = start;
		for (int i = 0; i < size; i++) {
			try {
				System.out.println(pointer.getPrev().getId() + "<---Nodo: " + pointer.getId() + "--->"
						+ pointer.getNext().getId());
			} catch (Exception e) {
				System.out.println(e);
			}

			pointer = pointer.getNext();
		}
	}

}
