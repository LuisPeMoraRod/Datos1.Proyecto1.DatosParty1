package com.Datos1.Proyecto1.cover;

import javax.swing.*;
import java.io.IOException;

public class CoverWindow extends JFrame {

    public static final int width =1000,height=600;

    CoverBoard coverBoard;
    CoverThread coverThread;

    String pathLogo, pathBackground, pathEnterPress, pathSpacePress, pathInstructions;

    public CoverWindow( String pathLogo, String pathBackground,String pathEnterPress, String pathSpacePress, String pathInstructions) throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pathBackground = pathBackground;
        this.pathEnterPress = pathEnterPress;
        this.pathLogo = pathLogo;
        this.pathSpacePress = pathSpacePress;
        this.pathInstructions = pathInstructions;

        coverBoard = new CoverBoard(pathLogo,pathBackground,pathEnterPress,pathSpacePress,pathInstructions);
        add(coverBoard);
        addKeyListener(new CoverEvent());

        coverThread = new CoverThread(coverBoard);
        coverThread.start();

    }

    public void closeWindow(){
        setVisible(false);
        dispose();
    }

}
