package com.Datos1.Proyecto1.FlappyBird;

import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;

public class MainFlappyBird {
	/**
	 * Main class
	 * @author Luis Pedro Morales Rodriguez
	 * @version 3/30/2020
	 */
	public static int players=4;
	static boolean startPlaying = false;

	
	public MainFlappyBird(int players) {
		this.players=players;
	}


	
	public static void main (String[] args) throws IOException {

		String pathLogo = "images/fBLogo.png";
		String pathEnterPress = "images/enterPress.png";
		String pathSpacePress = "images/spacePress.png";
		String pathInstructions = "images/fBInstructions.png";
		String pathBackground = "images/WallpaperFB.jpg";

		MainFlappyBird main=new MainFlappyBird(players);

		Cover fbCover = new Cover(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
		fbCover.createWindow();

		while(!startPlaying){

			System.out.println("while");

			if(CoverEvent.closeCover){
				startPlaying = true;
			}
		}

		if (startPlaying){

			fbCover.getWindow().setVisible(false);
			fbCover.getWindow().dispose();

			Window window=new Window(players);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


	}

}

