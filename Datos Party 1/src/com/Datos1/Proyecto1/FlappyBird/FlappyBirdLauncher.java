package com.Datos1.Proyecto1.FlappyBird;

import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import javax.swing.JFrame;
import java.io.IOException;

public class FlappyBirdLauncher {
	/**
	 * Main class
	 * @author Luis Pedro Morales Rodriguez
	 * @version 3/30/2020
	 */
	public static int players;
	static boolean startPlaying = false;

	public FlappyBirdLauncher(int players) {
		this.players=players;
	}
	
	public void launch () throws IOException {

		String pathLogo = "images/fBLogo.png";
		String pathEnterPress = "images/enterPress.png";
		String pathSpacePress = "images/spacePress.png";
		String pathInstructions = "images/fBInstructions.png";
		String pathBackground = "images/WallpaperFB.jpg";

		FlappyBirdLauncher main=new FlappyBirdLauncher(players);

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

			WindowFB window=new WindowFB(players);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	public static void main(String[] args) {
		FlappyBirdLauncher fb = new FlappyBirdLauncher(2);
		try {
			fb.launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

