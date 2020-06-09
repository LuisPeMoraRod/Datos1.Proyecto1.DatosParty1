package com.Datos1.Proyecto1.Start;

import com.Datos1.Proyecto1.GameBoard.*;

import java.io.IOException;

public class Main {

    public static CircularDoublyLinkedList players;
    public static int numberPlayers;

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

        numberPlayers = startWindow.startBoard.getNumberPlayers();

        players = new CircularDoublyLinkedList();
        System.out.println(numberPlayers);

        for (int i=1; i<=numberPlayers; i++) {

            if (i == 1) {
                players.insertHead(new Player(namePlayer1, i));
            }


            if (i == 2) {
                players.insertEnd(new Player(namePlayer2, i));
            }


           if(i==3) {
               players.insertEnd(new Player(namePlayer3, i));

           }
           if(i==4){
               players.insertEnd(new Player(namePlayer4, i));
           }

        }

        if(startGame){

            startWindow.dispose();

            GameBoardLauncher gameBoardLauncher = new GameBoardLauncher(players);
            gameBoardLauncher.launchGame();
        }
    }
}
