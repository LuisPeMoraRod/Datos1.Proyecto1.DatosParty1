package com.Datos1.Proyecto1.Start;

import javax.swing.*;
import java.io.IOException;

public class StartWindow extends JFrame {

    protected static final int width = 1400, height = 800;

    private StartThread startThread;
    private StartBoard startBoard;

    public StartWindow() throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startBoard = new StartBoard();
        add(startBoard);

        startThread = new StartThread(startBoard);
        startThread.start();

    }

    public void createWindow(){
        setVisible(true);
    }
}