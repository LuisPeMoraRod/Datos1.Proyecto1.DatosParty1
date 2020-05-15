package com.Datos1.Proyecto1.GameBoard;

public class Node {
	/**
	 * Public class that implements a Builder pattern design to handle different
	 * amount of parameters in its constructor. These parameters may vary depending
	 * on the type of linked list implemented
	 */

	protected Box box;
	private Node next;
	private Node prev;
	private int id;
	private boolean hasPointer;

	/**
	 * Constructor method. Receives Builder object and initializes its attributes with the builder parameters.
	 * 
	 * @param box  : Box
	 * @param next : Node
	 * @param prev : Node
	 */
	public Node(Builder builder) {
		this.box = builder.box;
		this.next = builder.next;
		this.prev = builder.prev;
		this.id = builder.id;
		this.hasPointer= builder.hasPointer;
	}
	
	/*
	 * Nodes' box setter
	 */
	public void setBox(Box box) {
		this.box=box;
	}
	/**
	 * Previous node getter
	 * @return prev : Node
	 */
	public Node getPrev() {
		return this.prev;
	}
	
	/**
	 * Previous node setter
	 * @param prev
	 */
	public void setPrev (Node prev) {
		this.prev=prev;
	}
	
	/**
	 * Next node getter
	 * @return next : Node
	 */
	public Node getNext() {
		return this.next;
	}
	
	/**
	 * Next node setter
	 * @param next
	 */
	public void setNext (Node next) {
		this.next=next;
	}
	
	/**
	 * ID setter
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Boolean hasPointer setter
	 * @param hasPointer
	 */
	public void setHasPointer(boolean hasPointer) {
		this.hasPointer=hasPointer;
	}
	
	/**
	 * Boolean hasPointer getter
	 * @return hasPointer : boolean
	 */
	public boolean getHasPointer() {
		return this.hasPointer;
	}
	
	
	public static Builder builder() {
		return new Builder();
	}
	
	
	public static class Builder {
		/**
		 * Builder class for node's parameters Box, next, prev and id
		 */
		
		private Box box;
		private Node next, prev;
		private int id;
		private boolean hasPointer;
		
		public Node build() {
			return new Node(this);
		}
		
		public Builder withPointer(boolean hasPointer) {
			this.hasPointer=hasPointer;
			return this;
		}
		public Builder withBox(Box box) {
			this.box=box;
			return this;
		}
		public Builder withNext(Node next) {
			this.next=next;
			return this;
		}
		public Builder withPrev(Node prev) {
			this.prev=prev;
			return this;
		}
		public Builder withId(int id) {
			this.id=id;
			return this;
		}
	}	
	
}
