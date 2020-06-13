package com.Datos1.Proyecto1.GameBoard;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class MinigamesObservable extends Observable{


	private boolean flappyBird;
	private boolean ticTacToe;
	private boolean fourInLine;
	private boolean simon;
	private boolean snake;
	private boolean pong ;
	
	//Flags for starting the duel
	private boolean duelFlappyBird = false;
	private boolean duelTicTacToe = false;
	private boolean duelFourInLine = false;
	
	private CircularDoublyLinkedList players;
	
	public MinigamesObservable() {
		flappyBird = false;
		ticTacToe = false;
		fourInLine = false;
		simon = false;
		snake = false;
		pong = false;
		}

	
	public boolean getFB() {
		return this.flappyBird;
	}
	
	public void setFB(boolean flappybird) {
		this.flappyBird=flappybird;
		setChanged();
		notifyObservers();
	}
	
	public boolean getTTT() {
		return this.ticTacToe;
	}
	
	public void setTTT(boolean ticTacToe) {
		this.ticTacToe = ticTacToe;
		setChanged();
		notifyObservers();
	}
	
	public boolean get4IL() {
		return this.fourInLine;
	}
	
	public void set4IL(boolean fourInLine) {
		this.fourInLine = fourInLine;
		setChanged();
		notifyObservers();
	}

	public boolean getSimon(){
		return this.simon;
	}

	public void setSimon(boolean simon){
		this.simon = simon;
		setChanged();
		notifyObservers();
	}

	public boolean getSnake(){
		return this.snake;
	}

	public void setSnake(boolean snake){
		this.snake = snake;
		setChanged();
		notifyObservers();
	}

	public boolean getPong(){
		return this.pong;
	}

	public void setPong(boolean pong){
		this.pong = pong;
		setChanged();
		notifyObservers();
	}
	
	//Duels
	public void setPlayers(Player player1, Player player2) {
		players = new CircularDoublyLinkedList();	
		players.insertHead(player1);
		players.insertEnd(player2);
	}
	
	public CircularDoublyLinkedList getPlayers() {
		return this.players;
	}
	
	public boolean getDuelFB() {
		return this.duelFlappyBird;
	}
	
	public void setDuelFB(boolean duelFlappyBird) {
		this.duelFlappyBird = duelFlappyBird;
		setChanged();
		notifyObservers();
	}
	
	public boolean getDuelTTT() {
		return this.duelTicTacToe;
	}
	
	public void setDuelTTT(boolean duelTicTacToe) {
		this.duelTicTacToe = duelTicTacToe;
		setChanged();
		notifyObservers();
	}
	
	public boolean getDuel4IL() {
		return this.duelFourInLine;
	}
	
	public void setDuel4IL(boolean duelFourInLine) {
		this.duelFourInLine = duelFourInLine;
		setChanged();
		notifyObservers();
	}
}
