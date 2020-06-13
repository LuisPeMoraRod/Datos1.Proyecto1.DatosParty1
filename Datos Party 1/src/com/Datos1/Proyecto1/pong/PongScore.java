package com.Datos1.Proyecto1.pong;

/**
 * PongScore implements the logic to increase the score of each one of the players
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class PongScore {

    public int scoreP1, scoreP2;

    public PongScore(){
        scoreP1 = 0;
        scoreP2 = 0;
    }


    public int setScoreP2(Ball ball){

        if (ball.x <= 0){
            scoreP2++;
        }
        return scoreP2;
    }

    public int setScoreP1(Ball ball){

        if (ball.x >= 980){
            scoreP1++;
        }
        return scoreP1;
    }

    /**
     * Resets the score each time that a round has finished
     */

    public void resetScore(){
        this.scoreP1=0;
        this.scoreP2=0;
    }

}
