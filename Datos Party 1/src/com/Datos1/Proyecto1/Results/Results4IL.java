package com.Datos1.Proyecto1.Results;

import java.io.IOException;

import com.Datos1.Proyecto1.GameBoard.LinkedList;
import com.Datos1.Proyecto1.Results.Results.ResultsCanvas;

public class Results4IL extends Results{

	public Results4IL(LinkedList results) throws IOException {
		super(results);
		ResultsCanvas canvas = new ResultsCanvas(results,"images/results4IL.png");
		add(canvas);
		setVisible(true);
	}

}
