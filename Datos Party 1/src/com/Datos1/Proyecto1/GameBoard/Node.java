package com.Datos1.Proyecto1.GameBoard;

import java.awt.Point;

public class Node{
	/**
	 * Public class that implements a Builder pattern design to handle different
	 * amount of parameters in its constructor. These parameters may vary depending
	 * on the type of linked list implemented
	 */

	protected Box box;
	protected Player player;
	private Node next;
	private Node prev;
	private int i; //indexes of the element in the "matrix" generated in the canvas with the group layout
	private int j;
	private int id;
	private boolean hasPointer;
	private boolean hasStar;

	/**
	 * Constructor method. Receives Builder object and initializes its attributes with the builder parameters.
	 * 
	 * @param box  : Box
	 * @param next : Node
	 * @param prev : Node
	 */
	public Node(Builder builder) {
		this.box = builder.box;
		this.player = builder.player;
		this.next = builder.next;
		this.prev = builder.prev;
		this.i = builder.i;
		this.j=builder.j;
		this.id = builder.id;
		this.hasPointer= true;
		this.hasStar = false;
	}
	
	/**
	 * hasStar setter
	 * @param star : boolean 
	 */
	public void setStar(boolean star) {
		this.hasStar = star;
	}
	
	/**
	 * hasStar getter
	 * @return hasSta : boolean
	 */
	public boolean getStar () {
		return this.hasStar;
	}
	
	/**
	 * Nodes' box setter
	 */
	public void setBox(Box box) {
		this.box=box;
	}
	
	/**
	 * Node's box getter
	 */
	public Box getBox() {
		return this.box;
	}
	/**
	 * Node's player getter
	 * @return player : Player
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player player) {
		this.player=player;
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
	 * ID getter
	 */
	public int getId() {
		return this.id;
	}
	
	public Point getIndex() {
		Point index = new Point(j,i);
		return index;
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
		private Player player;
		private Node next, prev;
		private int i;
		private int j;
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
		public Builder withPlayer(Player player) {
			this.player=player;
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
		public Builder withIndex(int i, int j) {
			this.i=i;
			this.j=j;
			return this;
		}
		public Builder withId(int id) {
			this.id = id;
			return this;
		}
	}	
	
}
