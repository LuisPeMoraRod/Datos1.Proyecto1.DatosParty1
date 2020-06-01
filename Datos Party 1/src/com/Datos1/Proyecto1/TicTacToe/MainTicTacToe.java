package com.Datos1.Proyecto1.TicTacToe;

import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;

public class MainTicTacToe {

	static boolean startPlaying = false;

	/**
	 * Main method that creates the window object
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 * {@link Window}
	 * @param args
	 */
	public static void main(String [] args) throws IOException {

		String pathLogo = "images/tttLogo.png";
		String pathEnterPress = "images/enterPress.png";
		String pathSpacePress = "images/spacePress.png";
		String pathInstructions = "images/tttInstructions.png";
		String pathBackground = "images/Wallpaper.jpg";

		Cover tttCover = new Cover(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
		tttCover.createWindow();

		while(!startPlaying){

			System.out.println("while");

			if(CoverEvent.closeCover){
				startPlaying = true;
			}
		}

		if (startPlaying){
			tttCover.getWindow().setVisible(false);
			tttCover.getWindow().dispose();
			Window tictactoe= new Window( "Jugador(a) 1", "Jugador(a) 2");
			tictactoe.setVisible(true);
			tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


	}
}