package com.Datos1.Proyecto1.FourInLine;

import javax.swing.JFrame;

public class MainFourInLine {
	/**
	 * Main method that creates the window object
	 * @author Luis Pedro Morales Rodriguez
	 * @version 4/5/2020
	 * @param args
	 */
	public static void main(String [] args) {
		Window4IL fourInLine= new Window4IL( "Jugador(a) 1", "Jugador(a) 2");
		fourInLine.setVisible(true);
		fourInLine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
