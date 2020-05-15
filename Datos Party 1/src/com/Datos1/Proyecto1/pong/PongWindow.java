package com.Datos1.Proyecto1.pong;

import javax.swing.*;
import java.io.IOException;

public class PongWindow extends JFrame {

    public static final int width =1000,height=600;

    private PongBoard pongBoard;

    private PongThread pongThread;

    public PongWindow() throws IOException {

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);

        pongBoard = new PongBoard();
        add(pongBoard);
        setVisible(true);

        pongThread = new PongThread(pongBoard);
        pongThread.start();
    }
}
