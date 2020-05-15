package com.Datos1.Proyecto1.GameBoard;

public class DoublyLinkedList {
	protected Node start;
	protected Node end;
	public int size;


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
		//Node newNode = new Node(newBox, null, null, id);
		Node newNode = Node.builder()
				.withBox(newBox)
				.withId(id)
				.build();
		
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
	public void insertEnd(Box newBox, int id) {
		Node newNode = Node.builder()
				.withBox(newBox)
				.withId(id)
				.build();
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
	 * @param index : int
	 * @param newBox : Box
	 * @param id : int
	 */
	public void insert(Box newBox, int index, int id) {
		Node newNode = Node.builder()
				.withBox(newBox)
				.withId(id)
				.build();
		if (index == 0) {
			insertHead(newBox, id);
			return;
		}
		Node pointer = start;
		for (int i = 1; i < size; i++) {
			if (i == index) {
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
	 * Public method. Returns the component of the list's square requested by its index.
	 * 
	 * @param i : int, index of the element of the list that is returned.
	 * @return Square type object
	 */
	public Square get (int i) {
		Node pointer=start;
		int cont=0;
		while (cont<i && pointer != end) {
			pointer=pointer.getNext();
			cont++;
		}
		return pointer.box.getBox();
	}
	
	public void printList() {
		Node pointer=start;
		for (int i = 0 ; i<size; i++) {
			try {
				System.out.println(pointer.getPrev().getId()+"<---Nodo: "+pointer.getId()+"--->"+pointer.getNext().getId());
			} catch (Exception e) {
				System.out.println(e);
			}
			
			pointer=pointer.getNext();
		}
	}

}
