package com.Datos1.Proyecto1.GameBoard;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class MinigamesObservable extends Observable{

	private boolean flappyBird = false;
	private boolean ticTacToe = false;
	private boolean fourInLine = false;
	private boolean simon = false;
	private boolean snake = false;
	private boolean pong = false;
	
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
}
