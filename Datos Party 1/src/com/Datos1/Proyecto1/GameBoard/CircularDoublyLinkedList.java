package com.Datos1.Proyecto1.GameBoard;



public class CircularDoublyLinkedList {
	protected Node start;
	protected Node end;
	public int size;

	public class Node {
		public Box box;
		public Node next, prev;
		public int id;

		/**
		 * Constructor method
		 * @param box
		 */
		public Node(Box box) {
			this.box = box;
			next = null;
			prev = null;
		}
		
		/**
		 * Constructor method
		 * @param box : Box
		 * @param next : Node
		 * @param prev : Node
		 */
		public Node (Box box, Node next, Node prev, int id) {
			this.box=box;
			this.next=next;
			this.prev=prev;
			this.id=id;
		}
	}

	public CircularDoublyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}
	
	/**
	 * Public method. Asks if the linked list is empty
	 * @return true if the first node doesn't point to any other node
	 */
	public boolean isEmpty() {
		return start==null;
	}
	
	/**
	 * Public method. Returns the number of nodes that the linked list has
	 * @return size : int
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Public method. Inserts a new node at the beginning of the list.
	 * @param newBox : Box
	 */
	public void insertHead(Box newBox, int id) {
		Node newNode = new Node (newBox,null,null, id);
		if (start == null) {
			newNode.next=newNode;
			newNode.prev=newNode;
			start=newNode;
			end=start;
		}else {
			newNode.next=start;
			newNode.prev=end;
			start.prev=newNode;
			start=newNode;
			end.next=start;
			
		}
		size++;
	}
	
	public void insertEnd(Box newBox, int id) {
		Node newNode = new Node (newBox,null, null, id);
		if (isEmpty()) {
			newNode.next=newNode;
			newNode.prev=newNode;
			start=newNode;
			end=start;
		}else {
			end.next=newNode;
			newNode.prev=end;
			newNode.next=start;
			end=newNode;
			start.prev=end;
		}size++;
	}
	
	public void insert (Box box, int index, int id) {
		Node newNode = new Node(box,null,null,id);
		if (index == 0) {
			insertHead(box, id);
			return;
		}
		
		Node pointer = start;
		for (int i =1; i<size;i++) {
			if (i==index) {
				Node temp = pointer.prev;
				pointer.prev=newNode;
				newNode.next=pointer;
				newNode.prev=temp;
				temp.next=newNode;
				
			}
			pointer=pointer.next;
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
}
