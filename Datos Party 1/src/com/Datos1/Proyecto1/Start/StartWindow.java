package com.Datos1.Proyecto1.Start;

import javax.swing.*;
import java.io.IOException;

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

    public String getNamePlayer1(){
        return this.startBoard.getNamePlayer1();
    }
    public String getNamePlayer2(){
        return this.startBoard.getNamePlayer2();
    }
    public String getNamePlayer3(){
        return this.startBoard.getNamePlayer3();
    }
    public String getNamePlayer4(){
        return this.startBoard.getNamePlayer4();
    }
}
