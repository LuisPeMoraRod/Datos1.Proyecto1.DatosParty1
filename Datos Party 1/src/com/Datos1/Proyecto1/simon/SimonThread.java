package com.Datos1.Proyecto1.simon;

public class SimonThread extends Thread {

    SimonRenderer simonRenderer;

    public SimonThread (SimonRenderer simonRenderer){

        this.simonRenderer = simonRenderer;

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

            simonRenderer.repaint();
        }
    }
}
