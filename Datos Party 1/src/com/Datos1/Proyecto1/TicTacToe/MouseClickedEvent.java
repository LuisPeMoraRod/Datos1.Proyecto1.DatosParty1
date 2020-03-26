package com.Datos1.Proyecto1.TicTacToe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickedEvent extends MouseAdapter{
	static boolean isFirstPlayer=false;

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!GameBoard.gameEnded) {
			GameBoard.cont++;
			isFirstPlayer=!isFirstPlayer;
			if (isFirstPlayer) {
				System.out.println("Player one's turn");
				
			}else {
				System.out.println("Player two's turn");
			}
		}
		
	}
	
	public void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.println(i+" "+j+":"+array[i][j]);
			}
		}
	}
}
