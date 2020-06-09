package com.Datos1.Proyecto1.simon;

import javax.swing.*;
import java.io.IOException;

public class SimonWindow extends JFrame {

    SimonBoard simonBoard;

    public static final int width =1000,height=600;

    public SimonWindow(int numberPlayers) throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);

        simonBoard = new SimonBoard(numberPlayers);
        add(simonBoard);

        SimonThread simonThread = new SimonThread(simonBoard);
        simonThread.start();


    }
}
