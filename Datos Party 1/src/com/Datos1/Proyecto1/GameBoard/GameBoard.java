package com.Datos1.Proyecto1.GameBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import com.Datos1.Proyecto1.GameBoard.LinkedCircularList.Node;

public class GameBoard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String[] players;
	private Color lightYellow = new Color(250, 249, 222);
	private LinkedCircularList mainLinkedList = new LinkedCircularList();
	private LinkedList phaseA = new LinkedList();

	public GameBoard() {
		setBackground(lightYellow);
		createLinkedCircularList();
		createPhaseA();
	}

	public void createLinkedCircularList() {
		Box first = new BlueBox();
		mainLinkedList.insertHead(first, 0);
		for (int i = 1; i < 44; i++) {
			Box box = new BlueBox();
			mainLinkedList.insertEnd(box, i);

		}

	}

	public void createPhaseA() {
		Box head = new GreenBox();
		phaseA.insertHead(head, 0);
		for (int i = 1; i <= 10; i++) {
			Box box = new GreenBox();
			phaseA.insertEnd(box, i);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		try {
			setBoxes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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
						.addComponent(mainLinkedList.get(35)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(2))
						.addComponent(mainLinkedList.get(34)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(3))
						.addComponent(mainLinkedList.get(33)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(4))
						.addComponent(mainLinkedList.get(16)).addComponent(mainLinkedList.get(17))
						.addComponent(mainLinkedList.get(18)).addComponent(mainLinkedList.get(32)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(5))
						.addComponent(mainLinkedList.get(15)).addComponent(mainLinkedList.get(19))
						.addComponent(mainLinkedList.get(31)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(6))
						.addComponent(mainLinkedList.get(14)).addComponent(mainLinkedList.get(20))
						.addComponent(mainLinkedList.get(30)))
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
						.addComponent(phaseA.get(5)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(phaseA.get(2))
						.addComponent(phaseA.get(3)).addComponent(phaseA.get(4)))

		);

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
						.addComponent(mainLinkedList.get(18)).addComponent(mainLinkedList.get(19))
						.addComponent(mainLinkedList.get(20)).addComponent(mainLinkedList.get(21))
						.addComponent(mainLinkedList.get(22)).addComponent(mainLinkedList.get(23))
						.addComponent(phaseA.get(6)).addComponent(phaseA.get(5)).addComponent(phaseA.get(4)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(39))
						.addComponent(mainLinkedList.get(24)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(38))
						.addComponent(mainLinkedList.get(25)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(37))
						.addComponent(mainLinkedList.get(26)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainLinkedList.get(27))
						.addComponent(mainLinkedList.get(28)).addComponent(mainLinkedList.get(29))
						.addComponent(mainLinkedList.get(30)).addComponent(mainLinkedList.get(31))
						.addComponent(mainLinkedList.get(32)).addComponent(mainLinkedList.get(33))
						.addComponent(mainLinkedList.get(34)).addComponent(mainLinkedList.get(35))
						.addComponent(mainLinkedList.get(36)))

		);
	}

}