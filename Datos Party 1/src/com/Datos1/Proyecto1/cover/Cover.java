package com.Datos1.Proyecto1.cover;

import java.io.IOException;

public class Cover {

    CoverWindow coverWindow;
    String pathLogo, pathBackground, pathEnterPress, pathSpacePress, pathInstructions;

    public Cover( String pathLogo, String pathBackground,String pathEnterPress, String pathSpacePress, String pathInstructions) throws IOException {

       this.coverWindow  = new CoverWindow(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
        this.pathBackground = pathBackground;
        this.pathEnterPress = pathEnterPress;
        this.pathLogo = pathLogo;
        this.pathSpacePress = pathSpacePress;
        this.pathInstructions = pathInstructions;


    }

    public void createWindow(){

            coverWindow.setVisible(true);
    }

    public CoverWindow getWindow(){
        return coverWindow;
    }

}
