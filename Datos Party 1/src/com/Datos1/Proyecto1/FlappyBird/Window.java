package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;

public class Window extends JFrame {
	/**
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	private static final long serialVersionUID = 1L;

	private int width, height;
	GameBoard board;

	JDesktopPane desk;
	JInternalFrame frame1, frame2, frame3, frame4;
	JFrame frame;
	Dimension sizeInternalFrame;
	public int players;

	public Window(int players) {
		this.players = players;
		desk = new JDesktopPane();
		setTitle("Flappy Bird");
		setWindowSize(players);
		setLocationRelativeTo(null);
		setResizable(false);
		// setUndecorated(true);
		for (int i = 0; i < players; i++) {
			createWindow(i);
		}

	}
	/*
	 * public void createWindow(int player) { board = new GameBoard(player);
	 * add(board);
	 * 
	 * }
	 */

	public void setWindowSize(int players) {
		if (players == 1) {
			width = 555;
			height = 445;
			setSize(width, height);
		}
		if (players == 2) {
			width = 1116;
			height = 445;
			setSize(width, height);
		}
		if (players == 3) {
			width = 1666;
			height = 445;
			setSize(width, height);
		}
		if (players == 4) {
			width = 1116;
			height = 889;
			setSize(width, height);
		}
	}

	public void createWindow(int player) {

		if (player == 0) {
			frame1 = new JInternalFrame("Frame1", true, true, true, true);
			frame1.setVisible(true);
			frame1.setSize(550, 425);
			frame1.setLocation(0, 0);
			int x = frame1.getX();
			int y = frame1.getY();
			internalFrameProps(frame1, x, y);
			desk.add(frame1);

		}
		if (player == 1) {
			frame2 = new JInternalFrame("Frame2", true, true, true, true);
			frame2.setVisible(true);
			frame2.setSize(550, 425);
			frame2.setLocation(550, 0);
			int x = frame2.getX();
			int y = frame2.getY();
			internalFrameProps(frame2, x, y);
			desk.add(frame2);
		}
		if (player == 2) {
			frame3 = new JInternalFrame("Frame3", true, true, true, true);
			frame3.setVisible(true);
			frame3.setSize(550, 425);
			if (players == 3) {
				frame3.setLocation(1100, 0);
			}
			if (players == 4) {
				frame3.setLocation(0, 425);
			}
			int x = frame3.getX();
			int y = frame3.getY();
			internalFrameProps(frame3, x, y);
			desk.add(frame3);
		}
		if (player == 3) {
			frame4 = new JInternalFrame("Frame4", true, true, true, true);
			frame4.setVisible(true);
			frame4.setSize(550, 425);
			frame4.setLocation(550, 425);
			int x = frame4.getX();
			int y = frame4.getY();
			// frame4.setMaximizable(false);
			internalFrameProps(frame4, x, y);
			desk.add(frame4);

		}

		add(desk);

	}

	public void internalFrameProps(JInternalFrame frame, int x, int y) {
		frame.setClosable(false);
		frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentMoved(java.awt.event.ComponentEvent evt) {
				formComponentMoved(evt);
			}

			private void formComponentMoved(ComponentEvent evt) {
				// TODO Auto-generated method stub

				frame.setLocation(x, y);
			}
		});

	}

}
