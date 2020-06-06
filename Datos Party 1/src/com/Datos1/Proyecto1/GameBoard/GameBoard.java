package com.Datos1.Proyecto1.GameBoard;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener {
	/**
	 * Public class. Represents the structure of the game's GUI
	 * 
	 * @author Luis Pedro Morales Rodriguez
	 * @version 25/3/2020
	 */

	private static final long serialVersionUID = 1L;
	static CircularLinkedList mainLinkedList = new CircularLinkedList();
	static LinkedList phaseA = new LinkedList();
	static LinkedList phaseB = new LinkedList();
	static DoublyLinkedList phaseC = new DoublyLinkedList();
	static CircularDoublyLinkedList phaseD = new CircularDoublyLinkedList();
	static CircularDoublyLinkedList players = new CircularDoublyLinkedList();
	public static Node playerInTurn;

	public static Node movingPointer; // Pointer that moves to the next nodes of each player's until they get to the
	// correct node

	private GameThread thread;
	public static boolean moving;
	public static boolean twoPaths1;
	public static boolean twoPaths2;
	private boolean disappears;
	private boolean appears;
	public static boolean throwAgain;
	public static int movingCont;// indicates through how many nodes the sprite has moved
	public static Dice dice1, dice2;
	public LeftRightArrow leftArrow, rightArrow;
	public UpDownArrow upArrow, downArrow;

	Timer timer;
	private int transparency = 10;

	public GameBoard() {

		setBackground(Color.white);
		createLinkedCircularList();
		createPhaseA();
		createPhaseB();
		createPhaseC();
		createPhaseD();
		dice1 = new Dice();
		dice2 = new Dice();
		leftArrow = LeftRightArrow.builder().left().build();
		rightArrow = LeftRightArrow.builder().right().build();
		upArrow = UpDownArrow.builder().up().build();
		downArrow = UpDownArrow.builder().down().build();

		//players.insertHead(new Player("P1", 1));
		//players.insertEnd(new Player("P2", 2));
		// players.insertEnd(new Player("P2", 3));
		// players.insertEnd(new Player("P4", 4));
		players.insertHead(new Player("P1", 1));

		players.insertEnd(new Player("P2", 2));
		// players.insertEnd(new Player("P2", 3));
		// players.insertEnd(new Player("P4", 4));

		playerInTurn = players.start;
		setDices(this);

		timer = new Timer(10, this);
		timer.start();

	}

	/**
	 * Creates the linked circular list which is the main path of the game. Uses i &
	 * j as indexes of an imaginary matrix where all the components are located in
	 * the matrix
	 */
	public void createLinkedCircularList() {
		int i = 0, j = 0;
		Box first = new BlueBox();
		mainLinkedList.insertHead(first, i, j);
		j++;

		for (int j1 = j; j1 < 10; j1++) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i, j1);
			j = j1;
		}
		i++;
		Box box1 = new BlueBox();
		mainLinkedList.insertEnd(box1, i, j);
		i++;

		for (int j1 = j; j1 > 3; j1--) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i, j1);
			j = j1;
		}

		i++;
		Box box2 = new BlueBox();
		mainLinkedList.insertEnd(box2, i, j);
		i++;
		for (int j1 = j; j1 < 10; j1++) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i, j1);
			j = j1;
		}
		i++;
		for (int i1 = i; i1 < 9; i1++) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i1, j);
			i = i1;
		}
		j--;
		for (int j1 = j; j1 >= 0; j1--) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i, j1);
			j = j1;
		}
		i--;
		for (int i1 = i; i1 > 0; i1--) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i1, j);
			i = i1;
		}
		mainLinkedList.printIndexes();
	}

	/**
	 * Creates phase A: a simple linked list
	 */
	public void createPhaseA() {
		int i = 2;
		int j = 10;
		Box head = new GreenBox();
		phaseA.insertHead(head, i, j);
		j++;
		Box box1 = new GreenBox();
		phaseA.insertEnd(box1, i, j);
		j++;
		for (int i1 = i; i1 <= 3; i1++) {
			Box box = new GreenBox();
			phaseA.insertEnd(box, i1, j);
			i = i1;
		}
		i++;
		for (int j1 = j; j1 > 9; j1--) {
			Box box = new GreenBox();
			phaseA.insertEnd(box, i, j1);
			j = j1;
		}
	}

	/**
	 * Creates phase B: a simple linked list
	 */
	public void createPhaseB() {
		int i = 7;
		int j = 6;
		Box head = new GreenBox();
		phaseB.insertHead(head, i, j);
		i--;
		Box box = new GreenBox();
		phaseB.insertEnd(box, i, j);
		j--;
		for (int j1 = j; j1 > 0; j1--) {
			Box box1 = new GreenBox();
			phaseB.insertEnd(box1, i, j1);
			j = j1;
		}
	}

	/**
	 * Creates phase C: a doubly linked list
	 */
	public void createPhaseC() {
		int i = 4;
		int j = 1;
		Box head = new YellowBox();
		phaseC.insertHead(head, i, j);
		j++;
		while (j < 5) {
			Box box = new YellowBox();
			phaseC.insertEnd(box, i, j);
			j++;
		}
	}

	/**
	 * Creates phase D: a doubly circular linked list
	 */
	public void createPhaseD() {
		int i = 6;
		int j = 11;
		Box first = new RedBox();
		phaseD.insertHead(first, i, j);
		j++;
		for (int j1 = j; j1 < 17; j1++) {
			Box newBox = new RedBox();
			phaseD.insertEnd(newBox, i, j1);
			j = j1;
		}
		i++;
		Box box = new RedBox();
		phaseD.insertEnd(box, i, j);
		i++;
		for (int j1 = j; j1 > 10; j1--) {
			Box newBox = new RedBox();
			phaseD.insertEnd(newBox, i, j1);
			j = j1;
		}
		i--;
		Box box1 = new RedBox();
		phaseD.insertEnd(box1, i, j);
	}

	/**
	 * Paints static images such as the black holes or arrows in the canvas
	 * 
	 * @param g : Graphics2D
	 */
	public void setImages(Graphics2D g) {
		Point pos = mainLinkedList.getNode(16).getIndex();
		pos.x = (pos.x * 80) + 2;
		pos.y = (pos.y * 83) + 2;
		BufferedImage blackHole = getSprite("images/blackHole.png"); // black hole image
		g.drawImage(blackHole, pos.x, pos.y, this); // places black hole in node 16 of main linked list
		pos = phaseD.getNode(13).getIndex();
		pos.x = (pos.x * 80) + 2;
		pos.y = (pos.y * 83) + 2;
		g.drawImage(blackHole, pos.x, pos.y, this); // places black hole in node 13 of phase D

		pos = mainLinkedList.getNode(18).getIndex();
		pos.x = (pos.x * 80) + 14;
		pos.y = (pos.y * 83) + 12;
		BufferedImage leftArrow = getSprite("images/leftArrow2.png");
		g.drawImage(leftArrow, pos.x, pos.y, this); // draws left arrow in node 18 of main linked list

		pos = mainLinkedList.getNode(30).getIndex();
		pos.x = (pos.x * 80) + 10;
		pos.y = (pos.y * 83) + 13;
		BufferedImage upArrow = getSprite("images/upArrow2.png");
		g.drawImage(upArrow, pos.x, pos.y, this); // draws up arrow in node 30 of main linked list

		pos = mainLinkedList.getNode(40).getIndex();
		pos.x = (pos.x * 80) + 9;
		pos.y = (pos.y * 83) + 10;
		BufferedImage rightArrow = getSprite("images/rightArrow2.png");
		g.drawImage(rightArrow, pos.x, pos.y, this); // draws right arrow in node 40 of main linked list

		if (throwAgain) { // draws message of throwing dices again after falling in the black hole
			Point p1 = new Point(Window.width * 9 / 12, Window.height / 4);
			g.drawImage(getSprite("images/throwAgain.png"), p1.x + 30, p1.y + 20, this);
		}

	}

	public void setDices(JPanel canvas) {
		this.setLayout(null);
		dice1.setBounds(Window.width * 6 / 8 + 20, 30, 96, 96);
		dice2.setBounds(Window.width * 6 / 7, 30, 96, 96);

		canvas.add(dice1);
		canvas.add(dice2);
	}

	/**
	 * Public method. Locates all the components of the JPanel in the canvas.
	 * 
	 * @throws Exception
	 */
	public void setBoxes() throws Exception {

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(0))
						.addComponent(mainLinkedList.get(43)).addComponent(mainLinkedList.get(42))
						.addComponent(mainLinkedList.get(41)).addComponent(mainLinkedList.get(40))
						.addComponent(mainLinkedList.get(39)).addComponent(mainLinkedList.get(38))
						.addComponent(mainLinkedList.get(37)).addComponent(mainLinkedList.get(36)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(1))
						.addComponent(phaseC.get(0)).addComponent(phaseB.get(6)).addComponent(mainLinkedList.get(35)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(2))
						.addComponent(phaseC.get(1)).addComponent(phaseB.get(5)).addComponent(mainLinkedList.get(34)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(3))
						.addComponent(phaseC.get(2)).addComponent(phaseB.get(4)).addComponent(mainLinkedList.get(33)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(4))
						.addComponent(mainLinkedList.get(16)).addComponent(mainLinkedList.get(17))
						.addComponent(mainLinkedList.get(18)).addComponent(phaseB.get(3))
						.addComponent(mainLinkedList.get(32)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(5))
						.addComponent(mainLinkedList.get(15)).addComponent(mainLinkedList.get(19))
						.addComponent(phaseB.get(2)).addComponent(mainLinkedList.get(31)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(6))
						.addComponent(mainLinkedList.get(14)).addComponent(mainLinkedList.get(20))
						.addComponent(phaseB.get(1)).addComponent(phaseB.get(0)).addComponent(mainLinkedList.get(30)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(7))
						.addComponent(mainLinkedList.get(13)).addComponent(mainLinkedList.get(21))
						.addComponent(mainLinkedList.get(29)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(8))
						.addComponent(mainLinkedList.get(12)).addComponent(mainLinkedList.get(22))
						.addComponent(mainLinkedList.get(28)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(9))
						.addComponent(mainLinkedList.get(10)).addComponent(mainLinkedList.get(11))
						.addComponent(mainLinkedList.get(23)).addComponent(mainLinkedList.get(24))
						.addComponent(mainLinkedList.get(25)).addComponent(mainLinkedList.get(26))
						.addComponent(mainLinkedList.get(27)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseA.get(0))
						.addComponent(phaseA.get(6)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseA.get(1))
						.addComponent(phaseA.get(5)).addComponent(phaseD.get(0)).addComponent(phaseD.get(13))
						.addComponent(phaseD.get(12)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseA.get(2))
						.addComponent(phaseA.get(3)).addComponent(phaseA.get(4)).addComponent(phaseD.get(1))
						.addComponent(phaseD.get(11)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseD.get(2))
						.addComponent(phaseD.get(10)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseD.get(3))
						.addComponent(phaseD.get(9)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseD.get(4))
						.addComponent(phaseD.get(8)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseD.get(5))
						.addComponent(phaseD.get(6)).addComponent(phaseD.get(7))));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(0))
						.addComponent(mainLinkedList.get(1)).addComponent(mainLinkedList.get(2))
						.addComponent(mainLinkedList.get(3)).addComponent(mainLinkedList.get(4))
						.addComponent(mainLinkedList.get(5)).addComponent(mainLinkedList.get(6))
						.addComponent(mainLinkedList.get(7)).addComponent(mainLinkedList.get(8))
						.addComponent(mainLinkedList.get(9)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(43))
						.addComponent(mainLinkedList.get(10)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(42))
						.addComponent(mainLinkedList.get(16)).addComponent(mainLinkedList.get(15))
						.addComponent(mainLinkedList.get(14)).addComponent(mainLinkedList.get(13))
						.addComponent(mainLinkedList.get(12)).addComponent(mainLinkedList.get(11))
						.addComponent(phaseA.get(0)).addComponent(phaseA.get(1)).addComponent(phaseA.get(2)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(41))
						.addComponent(mainLinkedList.get(17)).addComponent(phaseA.get(3)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(40))
						.addComponent(phaseC.get(0)).addComponent(phaseC.get(1)).addComponent(phaseC.get(2))
						.addComponent(mainLinkedList.get(18)).addComponent(mainLinkedList.get(19))
						.addComponent(mainLinkedList.get(20)).addComponent(mainLinkedList.get(21))
						.addComponent(mainLinkedList.get(22)).addComponent(mainLinkedList.get(23))
						.addComponent(phaseA.get(6)).addComponent(phaseA.get(5)).addComponent(phaseA.get(4)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(39))
						.addComponent(mainLinkedList.get(24)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(38))
						.addComponent(phaseB.get(6)).addComponent(phaseB.get(5)).addComponent(phaseB.get(4))
						.addComponent(phaseB.get(3)).addComponent(phaseB.get(2)).addComponent(phaseB.get(1))
						.addComponent(mainLinkedList.get(25)).addComponent(phaseD.get(0)).addComponent(phaseD.get(1))
						.addComponent(phaseD.get(2)).addComponent(phaseD.get(3)).addComponent(phaseD.get(4))
						.addComponent(phaseD.get(5)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(37))
						.addComponent(phaseB.get(0)).addComponent(mainLinkedList.get(26)).addComponent(phaseD.get(13))
						.addComponent(phaseD.get(6)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(27))
						.addComponent(mainLinkedList.get(28)).addComponent(mainLinkedList.get(29))
						.addComponent(mainLinkedList.get(30)).addComponent(mainLinkedList.get(31))
						.addComponent(mainLinkedList.get(32)).addComponent(mainLinkedList.get(33))
						.addComponent(mainLinkedList.get(34)).addComponent(mainLinkedList.get(35))
						.addComponent(mainLinkedList.get(36)).addComponent(phaseD.get(12)).addComponent(phaseD.get(11))
						.addComponent(phaseD.get(10)).addComponent(phaseD.get(9)).addComponent(phaseD.get(8))
						.addComponent(phaseD.get(7)))

		);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		setImages(g2d); // sets images like black hole and throw again message

		if (dice1.thrown && dice2.thrown) {
			startMovement();
		}
		if (moving) {
			this.remove(rightArrow);this.remove(leftArrow);this.remove(downArrow);this.remove(upArrow);
			for (int i = 0; i < players.getSize(); i++) {// paints all players when one of them is moving
				playerInTurn = playerInTurn.getPrev();
				Point actualPos = playerInTurn.getPlayer().getLocation();
				g2d.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
			}

		} else if (twoPaths1) {// if flag is set
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				Point actualPos = playerInTurn.getPlayer().getLocation();
				g2d.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
			}
			paintRLArrows(g2d);// paint arrows to chose path (left or right)
		} else if (twoPaths2) {// if flag is set
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				Point actualPos = playerInTurn.getPlayer().getLocation();
				g2d.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
			}
			paintUDArrows(g2d);// paint arrows to chose path (up or down)
		} else if (disappears) {
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				if (playerInTurn.getPlayer().getPointer().equals(phaseD.getNode(13))) {
					Point actualPos = new Point(mainLinkedList.getNode(16).getIndex()); // change for 16
					actualPos.x = (actualPos.x * 80) + 20;
					actualPos.y = (actualPos.y * 83) + 25;
					spriteDisappears(g2d, actualPos);
				} else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(16))) {// change for 16
					Point actualPos = phaseD.getNode(13).getIndex();
					actualPos.x = (actualPos.x * 80) + 20;
					actualPos.y = (actualPos.y * 83) + 25;
					spriteDisappears(g2d, actualPos);

				} else {
					Point actualPos = playerInTurn.getPlayer().getLocation();
					g2d.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
				}
			}

		} else if (appears) {
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				if (playerInTurn.getPlayer().getPointer().equals(phaseD.getNode(13))) {
					Point actualPos = phaseD.getNode(13).getIndex();
					actualPos.x = (actualPos.x * 80) + 20;
					actualPos.y = (actualPos.y * 83) + 25;
					spriteAppears(g2d, actualPos);
				} else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(16))) {// change for 16
					Point actualPos = mainLinkedList.getNode(16).getIndex();// change for 16
					actualPos.x = (actualPos.x * 80) + 20;
					actualPos.y = (actualPos.y * 83) + 25;
					spriteAppears(g2d, actualPos);

				} else {
					Point actualPos = playerInTurn.getPlayer().getLocation();
					g2d.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
				}
			}
		} else {
			setPlayers(g2d);

		}

		try {
			setBoxes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startMovement() {
		if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(11))) {// sets flag twoPaths when player
																						// starts to move and
			// it is located in node 11 (bifurcation)
			twoPaths1 = true;
			moving = false;
			movingCont--; // this fixes counting bug
		}

		// get out of phase A
		else if (playerInTurn.getPlayer().getPointer().equals(phaseA.getNode(6))) {
			movingPointer = mainLinkedList.getNode(23);
			playerInTurn.getPlayer().setPointer(movingPointer);// pointer to the next corresponding node in the
																// mainLinkedList
			moving = true;
		}

		// get in phase B
		else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(30))) {
			movingPointer = phaseB.getNode(0);
			playerInTurn.getPlayer().setPointer(movingPointer);
			moving = true;
		}
		// get out of phase B
		else if (playerInTurn.getPlayer().getPointer().equals(phaseB.getNode(6))) {
			movingPointer = mainLinkedList.getNode(38);
			playerInTurn.getPlayer().setPointer(movingPointer);
			moving = true;
		}
		// if players finish its turn in node 18, point to node 2 in phase C
		else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(18))) {
			movingPointer = phaseC.getNode(2);
			playerInTurn.getPlayer().setPointer(movingPointer);
			playerInTurn.getPlayer().setClockWise(false); // moves to the left in phase C
			moving = true;
		}
		// if players finish its turn in node 40, point to node in 0 phase C
		else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(40))) {
			movingPointer = phaseC.getNode(0);
			playerInTurn.getPlayer().setPointer(movingPointer);
			playerInTurn.getPlayer().setClockWise(true);// moves to the right in phase C
			moving = true;
		} else if (playerInTurn.getPlayer().getPointer().equals(phaseD.getNode(13))) {
			System.out.println("phase D");
			twoPaths2 = true;
			moving = false;
		}

		else {// if player is located in any other place
			movingPointer = playerInTurn.getPlayer().getPointer();
			movingPointer = movingPointer.getNext();
			playerInTurn.getPlayer().setPointer(movingPointer);// Player pointer points to next node
			moving = true;
		}

		

		dice1.thrown = false;
		dice2.thrown = false;
	}

	/**
	 * Sets players in the canvas when no one needs to move
	 * 
	 * @param g2d
	 */
	public void setPlayers(Graphics2D g2d) {
		for (int i = 0; i < players.getSize(); i++) {
			playerInTurn = playerInTurn.getPrev();// pointer of the player in turn to the previous node. This is
													// necessary to paint the sprites in order so that the player in
													// turn appears in front of the rest
			Node pointer = playerInTurn.getPlayer().getPointer();
			Point pt = new Point(pointer.getIndex());
			pt.x = (pt.x * 80) + 20;
			pt.y = (pt.y * 83) + 25;

			g2d.drawImage(playerInTurn.getPlayer().getSprite(), pt.x, pt.y, this);// draws player's sprite in canvas
			playerInTurn.getPlayer().setLocation(pt);// sets actual location of the sprite
			// playerInTurn = playerInTurn.getNext();// pointer to the next player in turn
		}

	}

	/**
	 * Routine in charge of moving the players. The sprite keeps moving node by node
	 * until it reaches the indicated by the number of the thrown dices
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (moving) {

			Point newPos = playerInTurn.getPlayer().getPointer().getIndex();// Gets the location of the next node where
																			// the player is moving (in terms of the
																			// matrix index)
			// changes the indexes to a location in screen
			newPos.x = (newPos.x * 80) + 20;
			newPos.y = (newPos.y * 83) + 25;

			Point actualPos = playerInTurn.getPlayer().getLocation();// Gets the actual location of the sprite

			if (actualPos.x == newPos.x && actualPos.y == newPos.y) {// when the sprite reaches the position of the next
																		// node:
				movingCont++;// Increments counter that indicates through how many nodes the sprite has moved
				System.out.println(movingCont + " " + (dice1.number + dice2.number));

				if (movingCont == dice1.number + dice2.number) {// if the sprite reached the correct node
					
					// if players falls in black hole in main linked list path
					if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(16))) {
						movingPointer = phaseD.getNode(13);
						playerInTurn.getPlayer().setPointer(movingPointer);// pointer to the first node of the phase D
																			// list
						newPos = playerInTurn.getPlayer().getPointer().getIndex();// resets new position
						System.out.println(newPos);
						newPos.x = (newPos.x * 80) + 20;
						newPos.y = (newPos.y * 83) + 25;

						actualPos.x = newPos.x;// gives the sprite the new position
						actualPos.x = newPos.y;
						playerInTurn.getPlayer().setLocation(actualPos);// this is necessary to paint the sprite in the
																		// right place
						disappears = true;
						movingCont = 0;// resets counter
						moving = false;// stops moving routine

					} else if (playerInTurn.getPlayer().getPointer().equals(phaseD.getNode(13)))// if player falls in
																								// the black hole
																								// located in phase D
					{
						movingPointer = mainLinkedList.getNode(16);
						playerInTurn.getPlayer().setPointer(movingPointer);// pointer to the first node of the phase D
																			// list
						newPos = playerInTurn.getPlayer().getPointer().getIndex();// resets new position
						System.out.println(newPos);
						newPos.x = (newPos.x * 80) + 20;
						newPos.y = (newPos.y * 83) + 25;

						actualPos.x = newPos.x;// gives the sprite the new position
						actualPos.x = newPos.y;
						playerInTurn.getPlayer().setLocation(actualPos);// this is necessary to paint the sprite in the
																		// right place
						disappears = true;
						movingCont = 0;// resets counter
						moving = false;// stops moving routine
					} else {
						movingCont = 0;// resets counter
						moving = false;// stops moving routine
						playerInTurn = playerInTurn.getNext();// pointer to the next player in turn
					}

				}

				else if (playerInTurn.getPlayer().getPointer().getId() == 11) {// if player reaches 11th node, set
																				// twoPaths flag
					twoPaths1 = true;
					moving = false;

				} else if (playerInTurn.getPlayer().getPointer().equals(phaseA.getNode(6))) {// if players reaches the
																								// last node of the
																								// phase A, pointer to
																								// corresponding next
																								// node in main path
					movingPointer = mainLinkedList.getNode(23);
					playerInTurn.getPlayer().setPointer(movingPointer);// pointer to the next node
				}
				// if player reaches node 2 of phase C and moves clockwise, sets next pointer to
				// node 18 in main path
				else if (playerInTurn.getPlayer().getPointer().equals(phaseC.getNode(2))
						&& !playerInTurn.getPlayer().getClockWise()) {

					movingPointer = mainLinkedList.getNode(18);
					playerInTurn.getPlayer().setPointer(movingPointer);
				}
				// if player reaches node 0 of phase C and moves counterclockwise, sets next
				// pointer to
				// node 40 in main path
				else if (playerInTurn.getPlayer().getPointer().equals(phaseC.getNode(0))
						&& playerInTurn.getPlayer().getClockWise()) {

					movingPointer = mainLinkedList.getNode(40);
					playerInTurn.getPlayer().setPointer(movingPointer);
					playerInTurn.getPlayer().setClockWise(true);
				}
				// if player reaches the last node of phase B, point to node 38 in main path
				else if (playerInTurn.getPlayer().getPointer().equals(phaseB.getNode(6))) {
					movingPointer = mainLinkedList.getNode(38);
					playerInTurn.getPlayer().setPointer(movingPointer);

				}

				else {
					if (!playerInTurn.getPlayer().getClockWise()) { // if clockwise == false, pointer to the previous
																	// node
						movingPointer = movingPointer.getPrev();
						playerInTurn.getPlayer().setPointer(movingPointer);// pointer to the previous node
					} else {
						movingPointer = movingPointer.getNext();
						playerInTurn.getPlayer().setPointer(movingPointer);// pointer to the next node
					}
				}
			}
			if (actualPos.x < newPos.x) {
				actualPos.x += 1;
			} else if (actualPos.x > newPos.x) {
				actualPos.x -= 1;
			} else if (actualPos.y < newPos.y) {
				actualPos.y += 1;
			} else if (actualPos.y > newPos.y) {
				actualPos.y -= 1;
			}
			playerInTurn.getPlayer().setLocation(actualPos);// this is necessary to paint the sprite in the right place
			repaint();
		}

	}

	/**
	 * Adds the left and right arrow objects to the canvas so that the player can
	 * choose the path
	 * 
	 * @param g : Graphics2D
	 */
	public void paintRLArrows(Graphics2D g) {
		leftArrow.setBounds(leftArrow.getsLocation().x, leftArrow.getsLocation().y, 108, 105);
		rightArrow.setBounds(rightArrow.getsLocation().x, rightArrow.getsLocation().y, 108, 105);
		this.add(leftArrow);
		this.add(rightArrow);
		Point p1 = new Point(Window.width * 9 / 12, Window.height / 4);
		g.drawImage(getSprite("images/leftOrRight.png"), p1.x + 10, p1.y + 20, this);
		leftArrow.paintsArrow(g);
		rightArrow.paintsArrow(g);
		
	}

	/**
	 * Adds the up and down arrow objects to the canvas so that the player can
	 * choose the path
	 * 
	 * @param g : Graphics2D
	 */
	public void paintUDArrows(Graphics2D g) {
		upArrow.setBounds(upArrow.getsLocation().x, upArrow.getsLocation().y, 108, 105);
		downArrow.setBounds(downArrow.getsLocation().x, downArrow.getsLocation().y, 108, 105);
		this.add(upArrow);
		this.add(downArrow);
		Point p1 = new Point(Window.width * 9 / 12, Window.height / 4);
		g.drawImage(getSprite("images/upOrDown.png"), p1.x + 10, p1.y + 20, this);
		upArrow.paintsArrow(g);
		downArrow.paintsArrow(g);
	}

	/**
	 * Sprite disappears slowly when it reaches the black hole
	 * 
	 * @param g
	 */
	public void spriteDisappears(Graphics2D g, Point actualPos) {

		float alpha = (float) ((transparency) * 0.1f);
		AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g.setComposite(alcom);
		g.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, null);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		transparency--;
		if (transparency == 0) {
			disappears = false;
			appears = true;
		}

	}

	/**
	 * Sprite appears slowly in phase D after being abducted by the black hole
	 * 
	 * @param g
	 */
	public void spriteAppears(Graphics2D g, Point actualPos) {

		float alpha = (float) ((transparency) * 0.1f);
		AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g.setComposite(alcom);
		g.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		transparency++;
		if (transparency == 11) {
			transparency = 10;
			appears = false;
			throwAgain = true;
		}
	}

	/**
	 * } Public method. Returns BufferedImage
	 * 
	 * @param path
	 * @return sprite : getSprite
	 */
	public BufferedImage getSprite(String path) {
		BufferedImage sprite = null;
		try {
			sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sprite;
	}
}