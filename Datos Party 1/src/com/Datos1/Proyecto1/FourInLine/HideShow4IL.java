package com.Datos1.Proyecto1.FourInLine;

public class HideShow4IL extends Thread {
	private int[][] line;
	private EndObservable4IL observable;
	private int cont;
	private GameBoard4IL canvas;
	private Circles4IL [][] circlesArray;

	public HideShow4IL(GameBoard4IL canvas, int[][] line, EndObservable4IL observable, Circles4IL[][] circlesArray) {
		this.line = line;
		this.observable = observable;
		this.canvas = canvas;
		this.circlesArray = circlesArray;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (!GameBoard4IL.gameEnded) {
			canvas.repaint();
		}
		if (GameBoard4IL.gameEnded) {
			cont = 0;
			while (cont < 3) {
				try {
					int i1 = line[0][0];
					int j1 = line[0][1];
					int i2 = line[1][0];
					int j2 = line[1][1];
					int i3 = line[2][0];
					int j3 = line[2][1];
					int i4 = line[3][0];
					int j4 = line[3][1];
					circlesArray[i1][j1].hide();
					circlesArray[i2][j2].hide();
					circlesArray[i3][j3].hide();
					circlesArray[i4][j4].hide();
					Thread.sleep(400);
					circlesArray[i1][j1].show();
					circlesArray[i2][j2].show();
					circlesArray[i3][j3].show();
					circlesArray[i4][j4].show();
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cont++;
			}
			
			observable.setEnd(true);
		}
	}

}