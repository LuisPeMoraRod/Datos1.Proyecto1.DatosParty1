package com.Datos1.Proyecto1.simon;

import com.Datos1.Proyecto1.cover.Cover;
import com.Datos1.Proyecto1.cover.CoverEvent;

import java.io.IOException;

public class SimonLauncher {

    public static SimonWindow simonWindow;
    static boolean startPlaying = false;

    public static void main(String[] args) throws IOException {

        String pathLogo = "images/simonLogo.png";
        String pathEnterPress = "images/enterPress.png";
        String pathSpacePress = "images/spacePress.png";
        String pathInstructions = "images/simonInstructions.png";
        String pathBackground = "images/SimonBackground.png";

        Cover simonCover = new Cover(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
        simonCover.createWindow();

        while(!startPlaying){

            System.out.println("cover");

            if(CoverEvent.closeCover){
                startPlaying = true;
            }
        }

        if (startPlaying) {

            simonCover.getWindow().setVisible(false);
            simonCover.getWindow().dispose();
            simonWindow = new SimonWindow(3);
            simonWindow.setVisible(true);

        }
    }
}
