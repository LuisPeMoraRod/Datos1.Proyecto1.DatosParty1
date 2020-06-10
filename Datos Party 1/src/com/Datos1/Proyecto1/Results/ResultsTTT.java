package com.Datos1.Proyecto1.Results;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.LinkedList;

public class ResultsTTT extends Results{

	public ResultsTTT(LinkedList results) throws IOException {
		super(results);
		ResultsCanvas canvas = new ResultsCanvas(results,"images/Wallpaper.jpg");
		add(canvas);
		setVisible(true);
	}

}
