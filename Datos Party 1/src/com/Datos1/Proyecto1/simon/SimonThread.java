package com.Datos1.Proyecto1.simon;

/**
 * @author Monica Waterhouse
 * @version 1.0
 * @since 01/05/2020
 *
 */
public class SimonThread extends Thread {

    SimonBoard simonBoard;

    public SimonThread (SimonBoard simonBoard){

        this.simonBoard = simonBoard;

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

            simonBoard.repaint();
        }
    }
}
