package com.Datos1.Proyecto1.TicTacToe;

import javax.swing.JFrame;

public class MainTicTacToe {
	/**
	 * Main method that creates the window object
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 * {@link Window}
	 * @param args
	 */
	public static void main(String [] args) {
		Window tictactoe= new Window( "Jugador(a) 1", "Jugador(a) 2");
		tictactoe.setVisible(true);
		tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}