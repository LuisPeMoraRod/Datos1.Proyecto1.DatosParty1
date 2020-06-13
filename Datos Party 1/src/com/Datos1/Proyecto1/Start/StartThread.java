package com.Datos1.Proyecto1.Start;

/**
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */
public class StartThread extends Thread {

    private StartBoard startBoard;
    public boolean active;

    public StartThread(StartBoard startBoard){

        this.startBoard = startBoard;
        active = true;

    }

    @Override
    public void run() {
        super.run();

        while (active){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startBoard.repaint();
        }
    }
}
