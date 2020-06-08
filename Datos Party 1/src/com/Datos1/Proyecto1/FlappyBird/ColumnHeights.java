package com.Datos1.Proyecto1.FlappyBird;

import java.util.Random;

public class ColumnHeights {
	/**
	 * Public class that implements a Singleton pattern design to create an array of
	 * random int numbers that will represent the heights of the set of columns
	 * created
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 4/1/2020
	 */

	private static ColumnHeights columns = null;
	public int[] heights;
	private Random random;
	/**
	 * Private constructor method. Creates an array of 100 int numbers. Each of them are declared using the Random class
	 * {@link Random#nextInt(int)}
	 */
	private ColumnHeights() {
		heights = new int[100];
		random = new Random();
		for (int i = 0; i < heights.length; i++) {
			int height = (int) (WindowFB.frameHeight*0.05+random.nextInt((int) (WindowFB.frameHeight*0.45)));
			heights[i] = height;
		}

	}
	
	/**
	 * Public static method that returns the unique instance of the class. Uses thread safety
	 */
	public static synchronized ColumnHeights getInstance() {
		if (columns == null) {
			columns = new ColumnHeights();
		}
		return columns;
	}

}
