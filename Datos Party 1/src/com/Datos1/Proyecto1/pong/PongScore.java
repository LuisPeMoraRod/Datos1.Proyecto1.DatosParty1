package com.Datos1.Proyecto1.pong;

public class PongScore {

    public int scoreP1, scoreP2;

    public PongScore(){
        scoreP1 = 0;
        scoreP2 = 0;
    }


    public int setScoreP2(Ball ball){

        if (ball.x == 0){
            scoreP2++;
        }
        return scoreP2;
    }

    public int setScoreP1(Ball ball){

        if (ball.x == 980){
            scoreP1++;
        }
        return scoreP1;
    }

}
