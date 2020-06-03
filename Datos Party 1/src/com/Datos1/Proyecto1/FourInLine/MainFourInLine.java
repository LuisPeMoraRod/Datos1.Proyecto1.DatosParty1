package com.Datos1.Proyecto1.FourInLine;

import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;

public class MainFourInLine {
	/**
	 * Main method that creates the window object
	 * @author Luis Pedro Morales Rodriguez
	 * @version 4/5/2020
	 * @param args
	 *
	 */

	static boolean startPlaying = false;


	public static void main(String [] args) throws IOException {

		String pathLogo = "images/filLogo.png";
		String pathEnterPress = "images/enterContinue.png";
		String pathSpacePress = "images/spaceContinue.png";
		String pathInstructions = "images/filInstructions.png";
		String pathBackground = "images/filBackground.png";

		Cover filCover = new Cover(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
		filCover.createWindow();


		while(!startPlaying){

			System.out.println("while");

			if(CoverEvent.closeCover){
				startPlaying = true;
			}
		}

		if(startPlaying){

			filCover.getWindow().setVisible(false);
			filCover.getWindow().dispose();

			Window4IL fourInLine= new Window4IL( "Jugador(a) 1", "Jugador(a) 2");
			fourInLine.setVisible(true);
			fourInLine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


	}
	

}