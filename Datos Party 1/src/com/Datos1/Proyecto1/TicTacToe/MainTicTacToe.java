package com.Datos1.Proyecto1.TicTacToe;

import javax.swing.JFrame;
import java.io.IOException;

public class MainTicTacToe {
	/**
	 * Main method that creates the window object
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 * {@link Window}
	 * @param args
	 */
	public static void main(String [] args) throws IOException {
		Window tictactoe= new Window( "Jugador(a) 1", "Jugador(a) 2");
		tictactoe.setVisible(true);
		tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}