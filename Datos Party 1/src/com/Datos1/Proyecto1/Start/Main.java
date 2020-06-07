package com.Datos1.Proyecto1.Start;

import com.Datos1.Proyecto1.GameBoard.GameBoardLauncher;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String namePlayer1, namePlayer2, namePlayer3, namePlayer4;

        StartWindow startWindow = new StartWindow();
        startWindow.createWindow();

        boolean startGame = false;

        while(!startGame){
            System.out.println("Main");
            if(startWindow.startBoard.endStartWindow){
                startGame = true;
            }
        }

        namePlayer1 = startWindow.startBoard.getNamePlayer1();
        namePlayer2 = startWindow.startBoard.getNamePlayer2();
        namePlayer3 = startWindow.startBoard.getNamePlayer3();
        namePlayer4 = startWindow.startBoard.getNamePlayer4();

        if(startGame){
            startWindow.dispose();

            GameBoardLauncher gameBoardLauncher = new GameBoardLauncher(namePlayer1, namePlayer2, namePlayer3, namePlayer4);
            gameBoardLauncher.launchGame();
        }
    }
}
