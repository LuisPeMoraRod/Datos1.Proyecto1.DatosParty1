package com.Datos1.Proyecto1.FlappyBird;

import java.util.Random;

public class ColumnHeights {
	/**
	 * Public class that implements a Singleton pattern design to create an array of
	 * random int numbers that will represent the heights of the set of columns
	 * created
	 */

	private static ColumnHeights columns = null;
	public int[] heights;
	private Random random;

	private ColumnHeights() {
		heights = new int[100];
		random = new Random();
		for (int i = 0; i < heights.length; i++) {
			int height = 50 + random.nextInt(260);
			heights[i] = height;
		}

	}

	public static synchronized ColumnHeights getInstance() {
		if (columns == null) {
			columns = new ColumnHeights();
		}
		return columns;
	}

}
