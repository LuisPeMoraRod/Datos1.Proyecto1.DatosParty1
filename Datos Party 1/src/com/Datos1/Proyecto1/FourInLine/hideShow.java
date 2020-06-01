package com.Datos1.Proyecto1.FourInLine;

public class hideShow extends Thread {
	int[][] line;

	public hideShow(int[][] line) {
		this.line = line;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (true) {
			while (GameBoard4IL.gameEnded) {
					try {
						int i1 = line[0][0];
						int j1 = line[0][1];
						int i2 = line[1][0];
						int j2 = line[1][1];
						int i3 = line[2][0];
						int j3 = line[2][1];
						int i4 = line[3][0];
						int j4 = line[3][1];
						GameBoard4IL.circlesArray[i1][j1].hide();
						GameBoard4IL.circlesArray[i2][j2].hide();
						GameBoard4IL.circlesArray[i3][j3].hide();
						GameBoard4IL.circlesArray[i4][j4].hide();
						Thread.sleep(400);
						GameBoard4IL.circlesArray[i1][j1].show();
						GameBoard4IL.circlesArray[i2][j2].show();
						GameBoard4IL.circlesArray[i3][j3].show();
						GameBoard4IL.circlesArray[i4][j4].show();
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}
	}

}