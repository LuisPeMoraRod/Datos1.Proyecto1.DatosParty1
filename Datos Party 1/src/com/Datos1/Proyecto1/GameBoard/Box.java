package com.Datos1.Proyecto1.GameBoard;

import java.awt.Color;

public interface Box{
	 public static final Color yellow = new Color (226, 232, 56);
	 public static final Color green = new Color (73, 173, 76);
	 public static final Color red = new Color (217, 11, 11);
	 public static final Color blue = new Color (15, 121, 191);
	
	/**
	 * Interface that uses factory pattern design and is used by the
	 * classes that will describe the different types of boxes or squares that
	 * compose the game board. These boxes differ by their colors.
	 */
	Square getBox();
	Square getEdgedBox();
}
