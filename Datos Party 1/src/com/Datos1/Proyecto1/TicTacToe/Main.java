package com.Datos1.Proyecto1.TicTacToe;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String [] args) {
		Window tictactoe= new Window( "Me", "notMe");
		tictactoe.setVisible(true);
		tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
