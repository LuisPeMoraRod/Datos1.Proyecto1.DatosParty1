package com.Datos1.Proyecto1.snake;


/**
 * @author Monica Waterhouse
 * @version 1.0
 *
 */

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
                Thread.sleep(50-SnakeBoard.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snakeBoard.repaint();
        }
    }
}
