package com.Datos1.Proyecto1.TicTacToe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickedEvent extends MouseAdapter{
	static boolean isFirstPlayer=true;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		isFirstPlayer=!isFirstPlayer;
		if (isFirstPlayer) {
			System.out.println("Player one's turn");
		}else {
			System.out.println("Player two's turn");
		}
		
	}

}
