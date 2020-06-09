package com.Datos1.Proyecto1.pong;

import java.io.IOException;

public class PongLauncher {

    protected static PongWindow pongWindow;

    public static void main(String[] args) throws IOException, InterruptedException {

        pongWindow = new PongWindow();
        pongWindow.setVisible(true);

    }

}
