package com.Datos1.Proyecto1.simon;

import javax.swing.*;
import java.io.IOException;

public class SimonWindow extends JFrame {

    private static final int width =1000,height=600;

    private SimonBoard simonBoard;

    private SimonThread simonThread;

    public SimonWindow() throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);

        simonBoard = new SimonBoard();
        add(simonBoard);
        setVisible(true);

       simonThread = new SimonThread(simonBoard);
       simonThread.start();
    }
}
