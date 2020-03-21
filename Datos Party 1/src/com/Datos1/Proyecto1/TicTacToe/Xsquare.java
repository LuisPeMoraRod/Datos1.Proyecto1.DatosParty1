package com.Datos1.Proyecto1.TicTacToe;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Xsquare extends Squares{
	
	private BufferedImage image;
	private String path;

	public Xsquare() {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
