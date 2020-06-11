package com.Datos1.Proyecto1.GameBoard;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import com.Datos1.Proyecto1.Results.*;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
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
	public static CircularDoublyLinkedList players = new CircularDoublyLinkedList();
	public static Node playerInTurn;
	private BufferedImage heyYou, plus7, minus7;

	private Box green;
	private Box red;
	private Box yellow;
	private Box blue;
	private Point imagesPos;

	private Node pointerToStar;
	private float alpha;
	private boolean newStarFlag; //flag that tells when to create a new star
	
	private AlphaComposite alcom;
	private float alphaP;
	private AlphaComposite alcomP;
	private int timerStar;
	private boolean congrats;//draw congratulations message
	private int contCongrats; //counter that helps to display the congratulations message
	private boolean sorry;//draw sorry message

	public static boolean drawCoins;
	public static boolean staticCoins;
	private int xCoins, yCoins, dxCoins, dyCoins;// position and size of the +-7 coins images
	public static Node movingPointer; // Pointer that moves to the next nodes of each player's until they get to the
	// correct node

	private GameThread thread;
	private Random random;

	public static boolean moving; // indicates if a player is moving
	public static boolean twoPaths1; // tells if left/right message should appear
	public static boolean twoPaths2;// tells if up/down message should appear
	private boolean disappears;// sprite disappears
	private boolean appears;// sprite appears
	public static boolean throwAgain;// player must throwo dices again (after blackhole)
	public static int movingCont;// indicates through how many nodes the sprite has moved
	private int roundsCont;// tells how many rounds have been played
	public static Dice dice1, dice2;
	public LeftRightArrow leftArrow, rightArrow;
	public UpDownArrow upArrow, downArrow;

	Timer timer;
	private int transparencyPlayers;// sprites transparency (10 is completely solid)
	private int transparencyStar;
	public GameBoard(CircularDoublyLinkedList players) {
		random = new Random();

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

		heyYou = getSprite("images/heyYou.png");
		plus7 = getSprite("images/plus7.png");
		minus7 = getSprite("images/minus7.png");

		GameBoard.players = players;
		
		transparencyPlayers = 10;

		setPlayersInitialNode();

		GameBoard.playerInTurn = GameBoard.players.getStart();
		setDices(this);

		green = new GreenBox();
		red = new RedBox();
		yellow = new YellowBox();
		blue = new BlueBox();

		
		transparencyStar = 10;
		timerStar = 6;

		imagesPos = new Point();

		timer = new Timer(10, this);
		timer.start();
	}

	/**
	 * Creates the linked circular list which is the main path of the game. Uses i &
	 * j as indexes of an imaginary matrix where all the components are located in
	 * the matrix
	 */
	public void createLinkedCircularList() {
		// Creates nodes and its position indexes
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

		// sets the yellow boxes in the list (events)
		int cont = 0;
		Node pointer;
		while (cont < 5) {

			int randomInt = random.nextInt(9) + 8 * cont;
			pointer = mainLinkedList.getNode(randomInt);
			if (randomInt != 16) {
				Box box = new YellowBox();
				pointer.setBox(box);
				cont++;
			}
		}

		cont = 0;
		// sets red boxes
		while (cont < 7) {
			int randomInt = random.nextInt(6) + 6 * cont;
			pointer = mainLinkedList.getNode(randomInt);
			if (randomInt != 16 && pointer.getBox().getClass().equals(first.getClass())) {
				Box box = new RedBox();
				pointer.setBox(box);
				cont++;
			}
		}

		cont = 0;
		// sets green boxes
		while (cont < 7) {
			int randomInt = random.nextInt(6) + 6 * cont;
			pointer = mainLinkedList.getNode(randomInt);
			if (randomInt != 16 && pointer.getBox().getClass().equals(first.getClass())) {
				Box box = new GreenBox();
				pointer.setBox(box);
				cont++;
			}

		}
		mainLinkedList.getNode(0).setBox(new BlueBox());// first box is always blue

	}

	/**
	 * Creates phase A: a simple linked list
	 */
	public void createPhaseA() {
		// Creates nodes and its position indexes
		int i = 2;
		int j = 10;
		Box head = new BlueBox();
		phaseA.insertHead(head, i, j);
		j++;
		Box box1 = new BlueBox();
		phaseA.insertEnd(box1, i, j);
		j++;
		for (int i1 = i; i1 <= 3; i1++) {
			Box box = new BlueBox();
			phaseA.insertEnd(box, i1, j);
			i = i1;
		}
		i++;
		for (int j1 = j; j1 > 9; j1--) {
			Box box = new BlueBox();
			phaseA.insertEnd(box, i, j1);
			j = j1;
		}

		// sets color of boxes
		Box green = new GreenBox();
		Box red = new RedBox();
		Box yellow = new YellowBox();
		int cont = 0;
		int randInt;
		Node pointer;

		while (cont < 3) {
			switch (cont) {
			case 0: {
				randInt = random.nextInt(7);
				pointer = phaseA.getNode(randInt);
				pointer.setBox(green);
				cont++;
				break;
			}
			case 1:
				randInt = random.nextInt(7);
				pointer = phaseA.getNode(randInt);
				if (pointer.getBox().getClass().equals(head.getClass())) {
					pointer.setBox(red);
					cont++;
				}
				break;
			case 2:
				randInt = random.nextInt(7);
				pointer = phaseA.getNode(randInt);
				if (pointer.getBox().getClass().equals(head.getClass())) {
					pointer.setBox(yellow);
					cont++;
				}
				break;
			default:
				break;
			}
		}

	}

	/**
	 * Creates phase B: a simple linked list
	 */
	public void createPhaseB() {
		int i = 7;
		int j = 6;
		// Creates nodes and its position indexes
		Box head = new YellowBox();
		phaseB.insertHead(head, i, j);
		i--;
		Box box = new YellowBox();
		phaseB.insertEnd(box, i, j);
		j--;
		for (int j1 = j; j1 > 0; j1--) {
			Box box1 = new YellowBox();
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
		// Creates nodes and its position indexes
		phaseC.insertHead(null, i, j);
		j++;
		while (j < 5) {
			phaseC.insertEnd(null, i, j);
			j++;
		}
		// sets color of boxes
		phaseC.getNode(0).setBox(new GreenBox());
		phaseC.getNode(1).setBox(new YellowBox());
		phaseC.getNode(2).setBox(new RedBox());
	}

	/**
	 * Creates phase D: a doubly circular linked list
	 */
	public void createPhaseD() {
		int i = 6;
		int j = 11;

		// Creates nodes and its position indexes
		Box first = new BlueBox();
		phaseD.insertHead(first, i, j);
		j++;
		for (int j1 = j; j1 < 17; j1++) {
			Box newBox = new BlueBox();
			phaseD.insertEnd(newBox, i, j1);
			j = j1;
		}
		i++;
		Box box = new BlueBox();
		phaseD.insertEnd(box, i, j);
		i++;
		for (int j1 = j; j1 > 10; j1--) {
			Box newBox = new BlueBox();
			phaseD.insertEnd(newBox, i, j1);
			j = j1;
		}
		i--;
		Box box1 = new BlueBox();
		phaseD.insertEnd(box1, i, j);

		// sets color of boxes
		// sets the yellow boxes in the list (events)
		int cont = 0;
		Node pointer;
		int randomInt;
		while (cont < 2) {

			randomInt = random.nextInt(13);
			pointer = phaseD.getNode(randomInt);
			if (randomInt != 16) {
				Box yellow = new YellowBox();
				pointer.setBox(yellow);
				cont++;
			}
		}

		cont = 0;
		// sets red boxes
		while (cont < 3) {
			randomInt = random.nextInt(13);
			pointer = phaseD.getNode(randomInt);
			if (pointer.getBox().getClass().equals(first.getClass())) {
				Box red = new RedBox();
				pointer.setBox(red);
				cont++;
			}
		}

		cont = 0;
		// sets green boxes
		while (cont < 3) {
			randomInt = random.nextInt(13);
			pointer = phaseD.getNode(randomInt);
			if (pointer.getBox().getClass().equals(first.getClass())) {
				Box green = new GreenBox();
				pointer.setBox(green);
				cont++;
			}

		}

	}

	/**
	 * Paints static images such as the black holes or arrows in the canvas
	 * 
	 * @param g : Graphics2D
	 * @throws InterruptedException 
	 */
	public void setImages(Graphics2D g, Graphics2D g2) throws InterruptedException {
		imagesPos = mainLinkedList.getNode(16).getIndex();
		imagesPos.x = (imagesPos.x * 80) + 2;
		imagesPos.y = (imagesPos.y * 83) + 2;
		BufferedImage blackHole = getSprite("images/blackHole.png"); // black hole image
		g.drawImage(blackHole, imagesPos.x, imagesPos.y, this); // places black hole in node 16 of main linked list
		imagesPos = phaseD.getNode(13).getIndex();
		imagesPos.x = (imagesPos.x * 80) + 2;
		imagesPos.y = (imagesPos.y * 83) + 2;
		g.drawImage(blackHole, imagesPos.x, imagesPos.y, this); // places black hole in node 13 of phase D

		imagesPos = mainLinkedList.getNode(18).getIndex();
		imagesPos.x = (imagesPos.x * 80) + 14;
		imagesPos.y = (imagesPos.y * 83) + 12;
		BufferedImage leftArrow = getSprite("images/leftArrow2.png");
		g.drawImage(leftArrow, imagesPos.x, imagesPos.y, this); // draws left arrow in node 18 of main linked list

		imagesPos = mainLinkedList.getNode(30).getIndex();
		imagesPos.x = (imagesPos.x * 80) + 10;
		imagesPos.y = (imagesPos.y * 83) + 13;
		BufferedImage upArrow = getSprite("images/upArrow2.png");
		g.drawImage(upArrow, imagesPos.x, imagesPos.y, this); // draws up arrow in node 30 of main linked list

		imagesPos = mainLinkedList.getNode(40).getIndex();
		imagesPos.x = (imagesPos.x * 80) + 9;
		imagesPos.y = (imagesPos.y * 83) + 10;
		BufferedImage rightArrow = getSprite("images/rightArrow2.png");
		g.drawImage(rightArrow, imagesPos.x, imagesPos.y, this); // draws right arrow in node 40 of main linked list

		if (throwAgain) { // draws message of throwing dices again after falling in the black hole
			imagesPos.x = Window.width * 9 / 12;
			imagesPos.y = Window.height / 4;
			g.drawImage(getSprite("images/throwAgain.png"), imagesPos.x + 30, imagesPos.y + 20, this);
		}

		// paints Star
		if (roundsCont >= 1) {
			imagesPos = pointerToStar.getIndex();
			imagesPos.x = (imagesPos.x * 80) + 12;
			imagesPos.y = (imagesPos.y * 83) + 10;

			if (timerStar < 6 && !drawCoins) {// blinking star
				if (transparencyStar == 10) {
					transparencyStar = 0;
				} else {
					transparencyStar = 10;
				}
				alpha = (float) ((transparencyStar) * 0.1f);
				alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
				g2.setComposite(alcom);
				g2.drawImage(getSprite("images/star.png"), imagesPos.x, imagesPos.y, this);
				timerStar++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (!newStarFlag){
				alpha = (float) ((transparencyStar) * 0.1f);
				alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
				g2.setComposite(alcom);
				g2.drawImage(getSprite("images/star.png"), imagesPos.x, imagesPos.y, this);
			}

		}
		
		if (congrats) {
			imagesPos.x = Window.width * 9 / 12;
			imagesPos.y = Window.height / 4;
			g.drawImage(getSprite("images/congrats.png"), imagesPos.x-20, imagesPos.y -10, this);
			if (contCongrats>=1) {
				Thread.sleep(2500);
				congrats = false;
				contCongrats=0;
			}else {
				contCongrats++;
			}
			
			
		}else if (sorry) {
			imagesPos.x = Window.width * 5 / 12;
			imagesPos.y = Window.height / 4;
			g.drawImage(getSprite("images/sorry.png"), imagesPos.x, imagesPos.y + 50, this);
		}

	}

	public void setDices(JPanel canvas) {
		this.setLayout(null);
		dice1.setBounds(Window.width * 6 / 8 + 70, 30, 96, 96);
		dice2.setBounds(Window.width * 7 / 8, 30, 96, 96);

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
		Graphics2D g2d2 = (Graphics2D) g.create();
		stats(g2d);

		try {
			setImages(g2d, g2d2);// sets images like black hole, star messages or throw again message
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} 

		if (dice1.thrown && dice2.thrown) {
			startMovement();
		}
		if (moving) {
			this.remove(rightArrow);
			this.remove(leftArrow);
			this.remove(downArrow);
			this.remove(upArrow);
			for (int i = 0; i < players.getSize(); i++) {// paints all players when one of them is moving
				playerInTurn = playerInTurn.getPrev();
				imagesPos = playerInTurn.getPlayer().getLocation();
				g2d.drawImage(playerInTurn.getPlayer().getSprite(), imagesPos.x, imagesPos.y, this);
			}

		} else if (twoPaths1) {// if flag is set
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				imagesPos = playerInTurn.getPlayer().getLocation();
				g2d.drawImage(playerInTurn.getPlayer().getSprite(), imagesPos.x, imagesPos.y, this);
			}
			paintRLArrows(g2d);// paint arrows to chose path (left or right)
		} else if (twoPaths2) {// if flag is set
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				imagesPos = playerInTurn.getPlayer().getLocation();
				g2d.drawImage(playerInTurn.getPlayer().getSprite(), imagesPos.x, imagesPos.y, this);
			}
			paintUDArrows(g2d);// paint arrows to chose path (up or down)
		} else if (disappears) {
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				if (playerInTurn.getPlayer().getPointer().equals(phaseD.getNode(13))) {
					imagesPos = mainLinkedList.getNode(16).getIndex(); // change for 16
					imagesPos.x = (imagesPos.x * 80) + 20;
					imagesPos.y = (imagesPos.y * 83) + 25;
					spriteDisappears(g2d, imagesPos);
				} else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(16))) {// change for 16
					Point actualPos = phaseD.getNode(13).getIndex();
					actualPos.x = (actualPos.x * 80) + 20;
					actualPos.y = (actualPos.y * 83) + 25;
					spriteDisappears(g2d, actualPos);

				} else {
					imagesPos = playerInTurn.getPlayer().getLocation();
					g2d.drawImage(playerInTurn.getPlayer().getSprite(), imagesPos.x, imagesPos.y, this);
				}
			}

		} else if (appears) {
			for (int i = 0; i < players.getSize(); i++) {// paints all players
				playerInTurn = playerInTurn.getPrev();
				if (playerInTurn.getPlayer().getPointer().equals(phaseD.getNode(13))) {
					imagesPos = phaseD.getNode(13).getIndex();
					imagesPos.x = (imagesPos.x * 80) + 20;
					imagesPos.y = (imagesPos.y * 83) + 25;
					spriteAppears(g2d, imagesPos);
				} else if (playerInTurn.getPlayer().getPointer().equals(mainLinkedList.getNode(16))) {// change for 16
					imagesPos = mainLinkedList.getNode(16).getIndex();// change for 16
					imagesPos.x = (imagesPos.x * 80) + 20;
					imagesPos.y = (imagesPos.y * 83) + 25;
					spriteAppears(g2d, imagesPos);

				} else {
					imagesPos = playerInTurn.getPlayer().getLocation();
					g2d.drawImage(playerInTurn.getPlayer().getSprite(), imagesPos.x, imagesPos.y, this);
				}
			}
		} else {

			setPlayers(g2d);
		}

		if (drawCoins) {
			try {
				drawCoins(g2d);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			if (!playerInTurn.getPlayer().getClockWise()) {
				movingPointer = movingPointer.getPrev();
			} else {
				movingPointer = movingPointer.getNext();
			}
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
		// Message: hey, you, throw the dices
		g2d.drawImage(heyYou, Window.width * 5 / 9 + 45, 30, this);
		g2d.drawImage(playerInTurn.getPlayer().getSprite(), Window.width * 6 / 9 + 90, 23, this);

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
				buyStar();
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

						checksNewBox(playerInTurn);// activates event depending on new position
						

						playerInTurn = playerInTurn.getNext();// pointer to the next player in turn
						sorry = false;
						if (playerInTurn.equals(players.getStart())) { // increments counter when round finishes
							roundsCont++;
							if (roundsCont == 1) {
								newStar();
							}
						}
						if (newStarFlag) {
							newStar();
							newStarFlag = false;
						}
						
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
						&& playerInTurn.getPlayer().getClockWise()) {

					movingPointer = mainLinkedList.getNode(18);
					playerInTurn.getPlayer().setPointer(movingPointer);
				}
				// if player reaches node 0 of phase C and moves counterclockwise, sets next
				// pointer to
				// node 40 in main path
				else if (playerInTurn.getPlayer().getPointer().equals(phaseC.getNode(0))
						&& !playerInTurn.getPlayer().getClockWise()) {

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

		alphaP = (float) ((transparencyPlayers) * 0.1f);
		alcomP = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaP);
		g.setComposite(alcomP);
		g.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, null);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		transparencyPlayers--;
		if (transparencyPlayers == 0) {
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

		alphaP = (float) ((transparencyPlayers) * 0.1f);
		alcomP = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaP);
		g.setComposite(alcomP);
		g.drawImage(playerInTurn.getPlayer().getSprite(), actualPos.x, actualPos.y, this);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		transparencyPlayers++;
		if (transparencyPlayers == 11) {
			transparencyPlayers = 10;
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

	/**
	 * Sets pointer of all the players to the first node of the main path
	 */
	public void setPlayersInitialNode() {
		Node pointer = players.getStart();

		for (int i = 0; i < players.getSize(); i++) {

			pointer.getPlayer().setPointer(mainLinkedList.start);
			pointer = pointer.getNext();
		}
	}

	/**
	 * Public method. Activates events depending on the box where the player falls
	 * 
	 * @param pointer : Node
	 */
	public void checksNewBox(Node pointer) {
		/**
		 * Node ptr = players.getStart(); for (int i = 0; i < players.getSize(); i++) {
		 * ptr = ptr.getNext();
		 * 
		 * }
		 */

		Box box = pointer.getPlayer().getPointer().getBox();

		if (box.getClass().equals(green.getClass())) {
			pointer.getPlayer().incrementCoins(7);
			xCoins = 1150;
			yCoins = 300;
			dxCoins = 75;
			dyCoins = 45;
			drawCoins = true;

		} else if (box.getClass().equals(red.getClass())) {
			pointer.getPlayer().decrementsCoins(7);
			xCoins = 1150;
			yCoins = 250;
			dxCoins = 150;
			dyCoins = 120;
			drawCoins = true;

		} else if (box.getClass().equals(yellow.getClass())) {
			System.out.println("yellow");
		} else {
			System.out.println("blue");

		}
	}

	/**
	 * Draws coins and moves them while changing the image size
	 * 
	 * @param g
	 * @throws InterruptedException
	 */
	public void drawCoins(Graphics2D g) throws InterruptedException {
		Box box = playerInTurn.getPrev().getPlayer().getPointer().getBox();

		if (box.getClass().equals(green.getClass())) {
			if (staticCoins) {
				g.drawImage(plus7, xCoins, yCoins, dxCoins, dyCoins, this);// static image
				Thread.sleep(1000);
				staticCoins = false;
				drawCoins = false;
			} else {
				g.drawImage(plus7, xCoins, yCoins, dxCoins, dyCoins, this);
				yCoins--;
				dxCoins++;
				dyCoins++;
				Thread.sleep(7);
				if (dxCoins >= 140) {
					staticCoins = true;
				}
			}

		} else if (box.getClass().equals(red.getClass())) {
			if (staticCoins) {
				g.drawImage(minus7, xCoins, yCoins, dxCoins, dyCoins, this);// static image
				Thread.sleep(1000);
				staticCoins = false;
				drawCoins = false;
			} else {
				g.drawImage(minus7, xCoins, yCoins, dxCoins, dyCoins, this);
				yCoins++;
				dxCoins--;
				dyCoins--;
				Thread.sleep(7);
				if (dxCoins <= 80) {
					staticCoins = true;
				}
			}
		}

	}

	/**
	 * Sets new random position of the star
	 */
	public void newStar() {
		int newNodeId;
		Node lastStar = pointerToStar;
		timerStar = 0;
		boolean correctPosition = false;
		while (!correctPosition) {
			correctPosition = true;
			newNodeId = random.nextInt(75);
			System.out.println(newNodeId);
			Node playerPtr = playerInTurn;

			if (newNodeId < 44) {
				switch (newNodeId) { // not allowed positions for star
				case 0:
					correctPosition = false;
					break;
				case 11:
					correctPosition = false;
					break;
				case 16:
					correctPosition = false;
					break;
				case 18:
					correctPosition = false;
					break;
				case 30:
					correctPosition = false;
					break;
				case 40:
					correctPosition = false;
					break;
				default:
					break;
				}
				pointerToStar = mainLinkedList.getNode(newNodeId);
			} else if (newNodeId < 51) {
				newNodeId -= 44;
				pointerToStar = phaseA.getNode(newNodeId);
			} else if (newNodeId < 58) {
				newNodeId -= 51;
				pointerToStar = phaseB.getNode(newNodeId);
			} else if (newNodeId < 61) {
				newNodeId -= 58;
				pointerToStar = phaseC.getNode(newNodeId);
			} else {
				newNodeId -= 61;
				if (newNodeId == 13) {//not allowed position for star
					correctPosition = false;
				}
				pointerToStar = phaseD.getNode(newNodeId);
			}
			System.out.println(newNodeId);
			for (int i = 0; i < players.getSize(); i++) {//checks if the position isn't occupied by a player
				if (playerPtr.getPlayer().getPointer().equals(pointerToStar)) {
					correctPosition = false;
				}
				playerPtr = playerPtr.getNext();
			}
			
			if (pointerToStar.equals(lastStar)) { // must be a different node than the last one
				correctPosition = false;
			}
		}
	}
	

	/**
	 * Public void, if player passes through a star and has enough money, then buys it.
	 */
	public void buyStar() {
		Player player = playerInTurn.getPlayer();
		int coins = player.getCoins();
		if (player.getPointer().equals(pointerToStar) && coins>=25) {
			player.incremenentStar(1);
			player.decrementsCoins(25);
			System.out.println(player.getCoins());
			newStarFlag = true;
			congrats = true;
			
		}else if (player.getPointer().equals(pointerToStar) && coins<25) {
			sorry = true;
		}
	}
	
	/**
	 * Draws statistics: amount of stars and coins
	 * @param g : Graphics2D 
	 */
	public void stats(Graphics2D g) {
		Node playerNode = players.getStart();
		Player player;
		imagesPos.x = 90;
		imagesPos.y = 30;
		for (int i = 0; i < players.getSize(); i++) {// paints all players
			player = playerNode.getPlayer();
			imagesPos.y+=65;
			g.setFont(new Font("Arial", 1, 18));
			drawString(g,": "+player.getCoins()+" coins, "+player.getStar()+" stars", imagesPos.x+40, imagesPos.y+5);
			g.drawImage(player.getSprite(), imagesPos.x, imagesPos.y, this);
			playerNode = playerNode.getNext();
		}
		
	}
	
	public void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
}