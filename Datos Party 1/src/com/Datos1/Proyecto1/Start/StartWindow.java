package com.Datos1.Proyecto1.Start;

import javax.swing.*;
import java.io.IOException;

/**
 * StartWindow creates a start window for the DatosParty1 game
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class StartWindow extends JFrame {

    protected static final int width = 1400, height = 800;

    private StartThread startThread;
    public StartBoard startBoard;

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
