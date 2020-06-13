package com.Datos1.Proyecto1.FlappyBird;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;

import com.Datos1.Proyecto1.GameBoard.CircularDoublyLinkedList;

public class WindowFB extends JFrame {
	/**
	 * Public class that creates the window where the game develops
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */
	private static final long serialVersionUID = 1L;

	private int width, height;
	public static int frameWidth = 490, frameHeight = 375;// 615 503
	public static GameBoardFB canvas1, canvas2, canvas3, canvas4;

	JDesktopPane desk;
	public static JInternalFrame frame1, frame2, frame3, frame4;
	Dimension sizeInternalFrame;
	public int playersSize;

	/**
	 * Constructor method. Creates an amount of internal frames depending on the
	 * number of players
	 * 
	 * @param players {@link WindowFB#setWindowSize(int)}
	 *                {@link WindowFB#createWindow(int)}
	 */
	public WindowFB(CircularDoublyLinkedList players) {
		this.playersSize = players.getSize();
		desk = new JDesktopPane();
		setTitle("Flappy Bird");
		setWindowSize(players.getSize());
		setLocationRelativeTo(null);
		setResizable(false);
		handleKeyEvent(this);
		// setUndecorated(true);
		for (int i = 1 ; i<=players.getSize();i++) {
			createWindow(i,players);
		}
		

	}

	/**
	 * Public method that sets the size of the window depending on the number of
	 * players
	 * 
	 * @param players : int
	 */
	public void setWindowSize(int players) {
		if (players == 1) {
			width = frameWidth;// 555
			height = frameHeight;
			setSize(width, height);
		}
		if (players == 2) {
			width = frameWidth * 2;
			height = frameHeight;
			setSize(width, height);
		}
		if (players == 3) {
			width = frameWidth * 2;
			height = frameHeight * 2 + 39;
			setSize(width, height);
		}
		if (players == 4) {
			width = frameWidth * 2;
			height = frameHeight * 2 + 39;// 889
			setSize(width, height);
		}
	}

	/**
	 * Public method that creates the internal frames for each player. The maximum
	 * amount of players is 4
	 * 
	 * @param players : int
	 */
	public void createWindow(int player, CircularDoublyLinkedList players) {

		if (player == 1) {
			frame1 = new JInternalFrame("Frame1", true, true, true, true);
			frame1.setVisible(true);
			frame1.setSize(frameWidth, frameHeight);
			frame1.setLocation(0, 0);
			int x = frame1.getX();
			int y = frame1.getY();
			internalFrameProps(frame1, x, y);
			desk.add(frame1);
			canvas1 = new GameBoardFB(players.getNode(player-1).getPlayer(),1);

			// canvas.setFocusable(true);
			// canvas.requestFocusInWindow();
			frame1.add(canvas1);
		}
		if (player == 2) {
			frame2 = new JInternalFrame("Frame2", true, true, true, true);
			frame2.setVisible(true);
			frame2.setSize(frameWidth, frameHeight);
			frame2.setLocation(frameWidth, 0);
			int x = frame2.getX();
			int y = frame2.getY();
			internalFrameProps(frame2, x, y);
			desk.add(frame2);
			canvas2 = new GameBoardFB(players.getNode(player-1).getPlayer(),2);

			frame2.add(canvas2);
		}
		if (player == 3) {
			frame3 = new JInternalFrame("Frame3", true, true, true, true);
			frame3.setVisible(true);
			frame3.setSize(frameWidth, frameHeight);
			if (playersSize == 3) {
				frame3.setLocation(frameWidth * 2 / 4, frameHeight);
			}
			if (playersSize == 4) {
				frame3.setLocation(0, frameHeight);
			}
			int x = frame3.getX();
			int y = frame3.getY();
			internalFrameProps(frame3, x, y);
			desk.add(frame3);
			canvas3 = new GameBoardFB(players.getNode(player-1).getPlayer(),3);

			frame3.add(canvas3);
		}
		if (player == 4) {
			frame4 = new JInternalFrame("Frame4", true, true, true, true);
			frame4.setVisible(true);
			frame4.setSize(frameWidth, frameHeight);
			frame4.setLocation(frameWidth, frameHeight);
			int x = frame4.getX();
			int y = frame4.getY();
			// frame4.setMaximizable(false);
			internalFrameProps(frame4, x, y);
			desk.add(frame4);
			canvas4 = new GameBoardFB(players.getNode(player-1).getPlayer(),4);
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

				frame.setLocation(x, y);
			}
		});

	}

	/**
	 * Public method that handles key events used to control the characters of the
	 * game
	 * 
	 * @param frame : JFrame
	 */
	public void handleKeyEvent(JFrame frame) {
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_W) {
					try {
						if (!canvas1.gameOn && !canvas1.gameOver) {// w key pressed
							canvas1.gameOn = true;
						}
						canvas1.jump();

					} catch (Exception e2) {
						// TODO: handle exception
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {// space bar pressed
					try {
						if (!canvas2.gameOn && !canvas2.gameOver) {
							canvas2.gameOn = true;
						}
						canvas2.jump();

					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_P) {// p key pressed
					try {
						if (!canvas3.gameOn && !canvas3.gameOver) {
							canvas3.gameOn = true;
						}
						canvas3.jump();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				if (e.getKeyCode() == 38) { // up key pressed
					try {
						if (!canvas4.gameOn && !canvas4.gameOver) {
							canvas4.gameOn = true;
						}
						canvas4.jump();

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
