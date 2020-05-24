package com.Datos1.Proyecto1.FourInLine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.Datos1.Proyecto1.TicTacToe.GameBoard;

public class Circles extends Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int i, j;
	public Color yellow,lightYellow,blue,red;
	public boolean filledCircle;
	public static boolean fallingToken;
	
	public int player;
	
	public Circles(int i, int j) {
		this.i = i;
		this.j = j;
		prepareColumn();
		releaseToken();
		
		lightYellow=new Color(250, 249, 222);
		yellow= new Color (217, 186, 63);
		blue=new Color(63, 212, 217);
		red = new Color(227, 93, 149);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (player==0) {
			if (i == 0) {
				if (GameBoard4IL.columnInPlay == j && !fallingToken && !GameBoard4IL.gameEnded) {
					if (GameBoard4IL.playerOne) {
						g2d.setColor(blue);
					}else {
						g2d.setColor(red);
					}
				} else {
					g2d.setColor(lightYellow);
				}
			} else if(GameBoard4IL.rowToken == i && GameBoard4IL.columnInPlay == j && fallingToken && !GameBoard4IL.gameEnded){
				if (GameBoard4IL.playerOne) {
					g2d.setColor(blue);
				}else {
					g2d.setColor(red);
				}
			}else {
		
				g2d.setColor(yellow);
			}
		}else if (player==1) {
			g2d.setColor(blue);
		}else if (player==2) {
			g2d.setColor(red);
		}

		Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, Window4IL.width / 9, Window4IL.width / 9);
		g2d.fill(circle);
	}

	public void prepareColumn() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				if (!GameBoard4IL.gameEnded && !fallingToken) {
					GameBoard4IL.columnInPlay = j;
				}
			}
		});

	}
	
	public void releaseToken() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (!GameBoard4IL.gameEnded && GameBoard4IL.circlesArray[1][GameBoard4IL.columnInPlay].player==0) {//sets flag only if the game hasn't ended and the column isn't allready filled with tokens
					fallingToken=true;
					
				}
			}
		});
	}
	

}