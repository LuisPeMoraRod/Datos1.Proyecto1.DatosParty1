package com.Datos1.Proyecto1.snake;

import com.Datos1.Proyecto1.pong.PongThread;

public class SnakeThread extends Thread {

    SnakeBoard snakeBoard;

    public SnakeThread(SnakeBoard snakeBoard){
        this.snakeBoard = snakeBoard;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snakeBoard.repaint();
        }
    }
}
