package com.Datos1.Proyecto1.cover;

import javax.swing.*;
import java.io.IOException;

public class CoverWindow extends JFrame {

    public static final int width =1000,height=600;

    CoverBoard coverBoard;
    CoverThread coverThread;

    public CoverWindow() throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);

        coverBoard = new CoverBoard("images/filLogo.png","images/filBackground.png","images/enterPress.png","images/spacePress.png","images/SnakeInstructions.png");
        add(coverBoard);

        coverThread = new CoverThread(coverBoard);
        coverThread.start();

    }

}
