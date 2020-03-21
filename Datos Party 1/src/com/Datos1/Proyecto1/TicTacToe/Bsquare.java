package com.Datos1.Proyecto1.TicTacToe;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bsquare extends Squares {
	private static final long serialVersionUID = 1L;

	public Bsquare() {
		path = "images/Bs.jpg";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
