package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;

public class Window extends JFrame {
	/**
	 * Public class that creates the window where the game develops
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	private static final long serialVersionUID = 1L;

	private int width, height;
	public static int frameWidth = 550, frameHeight = 425;
	public static GameBoard canvas1, canvas2, canvas3, canvas4;

	JDesktopPane desk;
	public static JInternalFrame frame1, frame2, frame3, frame4;
	Dimension sizeInternalFrame;
	public int players;

	/**
	 * Constructor method. Creates an amount of internal frames depending on the
	 * number of players
	 * 
	 * @param players {@link Window#setWindowSize(int)}
	 *                {@link Window#createWindow(int)}
	 */
	public Window(int players) {
		this.players = players;
		desk = new JDesktopPane();
		setTitle("Flappy Bird");
		setWindowSize(players);
		setLocationRelativeTo(null);
		setResizable(false);
		handleKeyEvent(this);
		// setUndecorated(true);
		for (int i = 1; i <= players; i++) {
			createWindow(i);
		}
		// public void createWindow(int player) { board = new GameBoard(player);
		// add(board);
	}

	/**
	 * Public method that sets the size of the window depending on the number of
	 * players
	 * 
	 * @param players : int
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

	/**
	 * Public method that creates the internal frames for each player. The maximum
	 * amount of players is 4
	 * 
	 * @param player : int
	 */
	public void createWindow(int player) {

		if (player == 1) {
			frame1 = new JInternalFrame("Frame1", true, true, true, true);
			frame1.setVisible(true);
			frame1.setSize(frameWidth, frameHeight);
			frame1.setLocation(0, 0);
			int x = frame1.getX();
			int y = frame1.getY();
			internalFrameProps(frame1, x, y);
			desk.add(frame1);
			canvas1=new GameBoard(player);
			//canvas.setFocusable(true);
			//canvas.requestFocusInWindow();
			frame1.add(canvas1);	
		}
		if (player == 2) {
			frame2 = new JInternalFrame("Frame2", true, true, true, true);
			frame2.setVisible(true);
			frame2.setSize(frameWidth, frameHeight);
			frame2.setLocation(550, 0);
			int x = frame2.getX();
			int y = frame2.getY();
			internalFrameProps(frame2, x, y);
			desk.add(frame2);
			canvas2=new GameBoard(player);
			frame2.add(canvas2);	
		}
		if (player == 3) {
			frame3 = new JInternalFrame("Frame3", true, true, true, true);
			frame3.setVisible(true);
			frame3.setSize(frameWidth, frameHeight);
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
			canvas3=new GameBoard(player);
			frame3.add(canvas3);	
		}
		if (player == 4) {
			frame4 = new JInternalFrame("Frame4", true, true, true, true);
			frame4.setVisible(true);
			frame4.setSize(frameWidth, frameHeight);
			frame4.setLocation(550, 425);
			int x = frame4.getX();
			int y = frame4.getY();
			// frame4.setMaximizable(false);
			internalFrameProps(frame4, x, y);
			desk.add(frame4);
			canvas4=new GameBoard(player);
			frame4.add(canvas4);	
		}
		add(desk);
	}

	/**
	 * Public method that sets the internal frames as undecorated (without the frame
	 * border, maximum button, minimum button) and also prevents the internal frames
	 * from being moved
	 * 
	 * @param frame : JInternalFrame
	 * @param x     : int
	 * @param y     : int
	 */
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
	public void handleKeyEvent(JFrame frame) {
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_W) {
					try {
						canvas1.print();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				if (e.getKeyCode()==KeyEvent.VK_SPACE) {
					try {
						canvas2.print();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				if (e.getKeyCode()==KeyEvent.VK_P) {
					try {
						canvas3.print();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				if (e.getKeyCode()==38) {
					try {
						canvas4.print();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	}

}
