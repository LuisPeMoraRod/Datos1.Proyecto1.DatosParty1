package com.Datos1.Proyecto1.Results;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Datos1.Proyecto1.GameBoard.LinkedList;

abstract class Results extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 600, height = 375;
	protected LinkedList results;

	public Results(LinkedList results) throws IOException {
		this.results = results;
		setSize(width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			     int id = e.getKeyCode();
				 if(id == KeyEvent.VK_SPACE){
					 System.out.println("leave");
					 chao();
			        }
				
			}
		});

		
	}

	public class ResultsCanvas extends JPanel{
		private static final long serialVersionUID = 1L;
		protected BufferedImage wallpaper;
		private String path;
		protected String resultsString="Resultados";

		public ResultsCanvas(LinkedList results,String path) throws IOException {
			// TODO Auto-generated constructor stub
			this.path= path;
			wallpaper = getWallpaper();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(wallpaper, 0, 0, this);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 1, 25));
			g.drawString(resultsString, 30, 30);
			
		}

		public BufferedImage getWallpaper() {
			try {
				wallpaper = ImageIO.read(new File(path));

			} catch (IOException e) {
				e.printStackTrace();
			}
			return wallpaper;
		}
	}
	
	public void chao() {
		this.dispose();
	}
}