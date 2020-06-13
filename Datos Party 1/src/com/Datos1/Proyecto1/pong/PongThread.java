package com.Datos1.Proyecto1.pong;

/**
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class PongThread extends Thread {

    PongBoard pongBoard;

    public PongThread(PongBoard pongBoard){
        this.pongBoard = pongBoard;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pongBoard.repaint();
        }
    }
}


