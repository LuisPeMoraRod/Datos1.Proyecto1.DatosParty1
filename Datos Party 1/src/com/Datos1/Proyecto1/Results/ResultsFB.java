package com.Datos1.Proyecto1.Results;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.LinkedList;

public class ResultsFB extends Results{

	public ResultsFB(LinkedList results) throws IOException {
		super(results);
		ResultsCanvas canvas = new ResultsCanvas(results,"images/WallpaperFB.jpg");
		add(canvas);
		setVisible(true);
	}

}
