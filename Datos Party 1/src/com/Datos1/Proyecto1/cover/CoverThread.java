package com.Datos1.Proyecto1.cover;

public class CoverThread extends Thread {

    CoverBoard coverBoard;
    public boolean intro = true;

    public CoverThread(CoverBoard coverBoard){
        this.coverBoard = coverBoard;
    }

    @Override
    public void run() {
        super.run();

        while(intro){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            coverBoard.repaint();
        }
    }

    public void endIntro(){
        intro = false;
    }
}
