package com.Datos1.Proyecto1.FourInLine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard4IL extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String player1,player2;
	public Circles[][] circlesArray=new Circles[7][7];
	private JLabel playersLabel=new JLabel();
	private JLabel turnLabel=new JLabel();
	
	public static boolean gameEnded;
	public static boolean playerOne;
	public static int columnInPlay;
	
	public Color lightYellow;
	
	public GameBoard4IL(String player1, String player2) {
		this.player1=player1;
		this.player2=player2;
		lightYellow=new Color(250, 249, 222);
		setBackground(lightYellow);
		instantiateCircles(circlesArray);
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//drawCircles(circlesArray,g2d,Color.white);
		setCircles(circlesArray);
		
	}
	
	private void instantiateCircles(Circles[][] circles) {
		for (int i=0; i<circles.length;i++) {
			for (int j=0;j<circles[i].length;j++) {
				circles[i][j]=new Circles(i,j);
			}
		}
		
	}
	private void drawCircles(Circles[][] circles,Graphics g, Color color) {
		for (int i=0; i<circles.length;i++) {
			for (int j=0;j<circles[i].length;j++) {
				//circles[i][j].draw(g, color);;
			}
		}
		
	}
	public void setCircles(Circles[][] c) {
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		String playersText = "<html><body><font size=6>Player 1: "+player1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; It's "+player1+"'s turn.<br>Player 2: "+player2+" </font></body></html>";
		playersLabel.setText(playersText);
		playersLabel.setForeground(Color.black);
		
		String turn="<html><body><font size=6>It's "+player1+"'s turn. </font></body></html>";
		turnLabel.setText(turn);
		turnLabel.setForeground(Color.white);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(playersLabel)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][0]).addComponent(c[1][0]).addComponent(c[2][0]).addComponent(c[3][0]).addComponent(c[4][0]).addComponent(c[5][0]).addComponent(c[6][0]))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][1]).addComponent(c[1][1]).addComponent(c[2][1]).addComponent(c[3][1]).addComponent(c[4][1]).addComponent(c[5][1]).addComponent(c[6][1]))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][2]).addComponent(c[1][2]).addComponent(c[2][2]).addComponent(c[3][2]).addComponent(c[4][2]).addComponent(c[5][2]).addComponent(c[6][2]))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][3]).addComponent(c[1][3]).addComponent(c[2][3]).addComponent(c[3][3]).addComponent(c[4][3]).addComponent(c[5][3]).addComponent(c[6][3]))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][4]).addComponent(c[1][4]).addComponent(c[2][4]).addComponent(c[3][4]).addComponent(c[4][4]).addComponent(c[5][4]).addComponent(c[6][4]))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][5]).addComponent(c[1][5]).addComponent(c[2][5]).addComponent(c[3][5]).addComponent(c[4][5]).addComponent(c[5][5]).addComponent(c[6][5]))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(c[0][6]).addComponent(c[1][6]).addComponent(c[2][6]).addComponent(c[3][6]).addComponent(c[4][6]).addComponent(c[5][6]).addComponent(c[6][6]))
								))
				
				);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(playersLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[0][0]).addComponent(c[0][1]).addComponent(c[0][2]).addComponent(c[0][3]).addComponent(c[0][4]).addComponent(c[0][5]).addComponent(c[0][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[1][0]).addComponent(c[1][1]).addComponent(c[1][2]).addComponent(c[1][3]).addComponent(c[1][4]).addComponent(c[1][5]).addComponent(c[1][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[2][0]).addComponent(c[2][1]).addComponent(c[2][2]).addComponent(c[2][3]).addComponent(c[2][4]).addComponent(c[2][5]).addComponent(c[2][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[3][0]).addComponent(c[3][1]).addComponent(c[3][2]).addComponent(c[3][3]).addComponent(c[3][4]).addComponent(c[3][5]).addComponent(c[3][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[4][0]).addComponent(c[4][1]).addComponent(c[4][2]).addComponent(c[4][3]).addComponent(c[4][4]).addComponent(c[4][5]).addComponent(c[4][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[5][0]).addComponent(c[5][1]).addComponent(c[5][2]).addComponent(c[5][3]).addComponent(c[5][4]).addComponent(c[5][5]).addComponent(c[5][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c[6][0]).addComponent(c[6][1]).addComponent(c[6][2]).addComponent(c[6][3]).addComponent(c[6][4]).addComponent(c[6][5]).addComponent(c[6][6]))
				
				);
		
		
		
		
		
		
	}
	
}
