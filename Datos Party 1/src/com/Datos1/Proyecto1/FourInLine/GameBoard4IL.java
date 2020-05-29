package com.Datos1.Proyecto1.FourInLine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard4IL extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String player1, player2, currentPlayer;
	public static Circles[][] circlesArray = new Circles[7][7];
	private JLabel playersLabel = new JLabel();

	private JLabel turnLabel = new JLabel();

	public static boolean gameEnded;
	public static boolean draw;
	public static boolean playerOne = true;
	public static int columnInPlay;
	public static int rowToken;
	public int[][] line4 = new int[4][2];

	public Color lightYellow;
	public Thread thread;
	public Timer timer;

	public GameBoard4IL(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		lightYellow = new Color(250, 249, 222);
		setBackground(lightYellow);
		instantiateCircles(circlesArray);
		timer = new Timer(300, this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// drawCircles(circlesArray,g2d,Color.white);
		if (Circles.fallingToken) {
			timer.start();
		} else {
			setCircles(circlesArray);
		}

	}

	private void instantiateCircles(Circles[][] circles) {
		for (int i = 0; i < circles.length; i++) {
			for (int j = 0; j < circles[i].length; j++) {
				circles[i][j] = new Circles(i, j);
			}
		}

	}

	private void printArray(Circles[][] c) {
		System.out.println("  ");
		for (int i = 0; i < c.length; i++) {
			int element = c[i][0].player;
			System.out.print(element);
			for (int j = 1; j < c[i].length; j++) {
				int element1 = c[i][j].player;
				if (j == c[i].length - 1) {
					System.out.println(" " + element1);
				} else {
					System.out.print(" " + element1);
				}

			}
		}

	}

	public void setCircles(Circles[][] c) {
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		if (playerOne) {
			currentPlayer = player1;
		} else {
			currentPlayer = player2;
		}
		String turn;
		if (!GameBoard4IL.gameEnded) {
			turn = "It's " + currentPlayer + "'s turn.";
		} else if (draw) {
			turn = "Game ended in draw";
		} else {
			turn = "Winner: " + currentPlayer;
		}
		String playersText = "<html><body><font size=6>Player 1: " + player1
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + turn + "<br>Player 2: "
				+ player2 + " </font></body></html>";
		playersLabel.setText(playersText);
		playersLabel.setForeground(Color.black);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(playersLabel)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][0])
								.addComponent(c[1][0]).addComponent(c[2][0]).addComponent(c[3][0]).addComponent(c[4][0])
								.addComponent(c[5][0]).addComponent(c[6][0]))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][1])
								.addComponent(c[1][1]).addComponent(c[2][1]).addComponent(c[3][1]).addComponent(c[4][1])
								.addComponent(c[5][1]).addComponent(c[6][1]))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][2])
								.addComponent(c[1][2]).addComponent(c[2][2]).addComponent(c[3][2]).addComponent(c[4][2])
								.addComponent(c[5][2]).addComponent(c[6][2]))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][3])
								.addComponent(c[1][3]).addComponent(c[2][3]).addComponent(c[3][3]).addComponent(c[4][3])
								.addComponent(c[5][3]).addComponent(c[6][3]))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][4])
								.addComponent(c[1][4]).addComponent(c[2][4]).addComponent(c[3][4]).addComponent(c[4][4])
								.addComponent(c[5][4]).addComponent(c[6][4]))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][5])
								.addComponent(c[1][5]).addComponent(c[2][5]).addComponent(c[3][5]).addComponent(c[4][5])
								.addComponent(c[5][5]).addComponent(c[6][5]))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][6])
								.addComponent(c[1][6]).addComponent(c[2][6]).addComponent(c[3][6]).addComponent(c[4][6])
								.addComponent(c[5][6]).addComponent(c[6][6]))))

		);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(playersLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[0][0])
						.addComponent(c[0][1]).addComponent(c[0][2]).addComponent(c[0][3]).addComponent(c[0][4])
						.addComponent(c[0][5]).addComponent(c[0][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[1][0])
						.addComponent(c[1][1]).addComponent(c[1][2]).addComponent(c[1][3]).addComponent(c[1][4])
						.addComponent(c[1][5]).addComponent(c[1][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[2][0])
						.addComponent(c[2][1]).addComponent(c[2][2]).addComponent(c[2][3]).addComponent(c[2][4])
						.addComponent(c[2][5]).addComponent(c[2][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[3][0])
						.addComponent(c[3][1]).addComponent(c[3][2]).addComponent(c[3][3]).addComponent(c[3][4])
						.addComponent(c[3][5]).addComponent(c[3][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[4][0])
						.addComponent(c[4][1]).addComponent(c[4][2]).addComponent(c[4][3]).addComponent(c[4][4])
						.addComponent(c[4][5]).addComponent(c[4][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[5][0])
						.addComponent(c[5][1]).addComponent(c[5][2]).addComponent(c[5][3]).addComponent(c[5][4])
						.addComponent(c[5][5]).addComponent(c[5][6]))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(c[6][0])
						.addComponent(c[6][1]).addComponent(c[6][2]).addComponent(c[6][3]).addComponent(c[6][4])
						.addComponent(c[6][5]).addComponent(c[6][6]))

		);

	}

	/**
	 * Public method that sets the token's player.
	 * 
	 * @param c : Circles
	 */
	public void setToken(Circles c) {
		if (playerOne) {
			c.player = 1;
		} else {
			c.player = 2;
		}
	}

	/**
	 * Public method that checks in the array of Circles objects if there's already
	 * a token in the next position of the column where the token is falling. When
	 * the token finds another token or gets to the last row, it sets the new
	 * 
	 * @param c : Circles
	 * @return boolean
	 */
	public boolean isToken(Circles c) {
		if (c.player > 0 && c.i == 1) {
			return true;
		} else if (c.player > 0 && c.i > 1) {
			setToken(circlesArray[rowToken - 1][columnInPlay]);

			return true;
		} else if (c.i == 6) {
			setToken(c);

			return true;
		} else {
			return false;
		}
	}

	public boolean checksWin(Circles[][] c) {
		int cont = 0;
		int player = 0;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				if (c[i][j].player == player && player != 0) {
					line4[cont][0] = i;
					line4[cont][1] = j - 1;
					if (j - 1 >= 0) {
						cont++;

					} else {
						cont = 0;

					}
					if (cont == 3) {
						line4[cont][0] = i;
						line4[cont][1] = j;
						return true;
					}
				} else if (c[i][j].player != player) {
					player = c[i][j].player;
					cont = 0;
				}
			}
		}
		for (int j = 0; j < c.length; j++) {
			for (int i = 0; i < c[j].length; i++) {
				if (c[i][j].player == player && player != 0) {
					line4[cont][0] = i - 1;
					line4[cont][1] = j;
					if (i - 1 >= 1) {
						cont++;

					} else {
						cont = 0;

					}
					if (cont == 3) {
						line4[cont][0] = i;
						line4[cont][1] = j;
						return true;
					}
				} else if (c[i][j].player != player) {
					player = c[i][j].player;
					cont = 0;
				}
			}
		}

		if (checksDiagUp1(4, 0, 4, 0, 0, 0, c) || checksDiagUp2(6, 1, 6, 1, 0, 0, c)) {
			return true;
		}
		if (checksDiagDown1(4, 6, 4, 6, 0, 0, c) || checksDiagDown2(6, 5, 6, 5, 0, 0, c)) {
			return true;
		}
		return false;
	}

	public boolean checksDiagUp1(int i0, int j0, int i, int j, int cont, int player, Circles[][] c) {
		if (i0 > 6) {
			return false;
		} else if (i < 1) {
			return checksDiagUp1(i0 + 1, j0, i0 + 1, 0, 0, player, c);
		} else if (c[i][j].player == player && player != 0) {
			line4[cont][0] = i + 1;
			line4[cont][1] = j - 1;
			if (i + 1 <= 6 && j - 1 >= 0) {
				cont++;

			} else {
				cont = 0;

			}
			if (cont == 3) {
				line4[cont][0] = i;
				line4[cont][1] = j;
				return true;
			} else {
				return checksDiagUp1(i0, j0, i - 1, j + 1, cont, player, c);
			}
		} else if (c[i][j].player != player) {
			player = c[i][j].player;
			cont = 0;
			return checksDiagUp1(i0, j0, i - 1, j + 1, cont, player, c);
		} else {
			return checksDiagUp1(i0, j0, i - 1, j + 1, cont, player, c);
		}

	}

	public boolean checksDiagUp2(int i0, int j0, int i, int j, int cont, int player, Circles[][] c) {
		if (j0 > 3) {
			return false;
		} else if (j > 6) {
			return checksDiagUp2(i0, j0 + 1, i0, j0 + 1, 0, player, c);
		} else if (c[i][j].player == player && player != 0) {
			line4[cont][0] = i + 1;
			line4[cont][1] = j - 1;
			if (i + 1 <= 6 && j - 1 >= 0) {
				cont++;

			} else {
				cont = 0;

			}
			if (cont == 3) {
				line4[cont][0] = i;
				line4[cont][1] = j;
				return true;
			} else {
				return checksDiagUp2(i0, j0, i - 1, j + 1, cont, player, c);
			}
		} else if (c[i][j].player != player) {
			player = c[i][j].player;
			cont = 0;
			return checksDiagUp2(i0, j0, i - 1, j + 1, cont, player, c);
		} else {
			return checksDiagUp2(i0, j0, i - 1, j + 1, cont, player, c);
		}

	}

	public boolean checksDiagDown1(int i0, int j0, int i, int j, int cont, int player, Circles[][] c) {
		if (i0 > 6) {
			return false;
		} else if (i < 1) {
			return checksDiagDown1(i0 + 1, j0, i0 + 1, 6, 0, player, c);
		} else if (c[i][j].player == player && player != 0) {
			line4[cont][0] = i + 1;
			line4[cont][1] = j + 1;
			if (i + 1 <= 6 && j + 1 <= 6) {
				cont++;

			} else {
				cont = 0;

			}
			if (cont == 3) {
				line4[cont][0] = i;
				line4[cont][1] = j;
				return true;
			} else {
				return checksDiagDown1(i0, j0, i - 1, j - 1, cont, player, c);
			}
		} else if (c[i][j].player != player) {
			player = c[i][j].player;
			cont = 0;
			return checksDiagDown1(i0, j0, i - 1, j - 1, cont, player, c);
		} else {
			return checksDiagDown1(i0, j0, i - 1, j - 1, cont, player, c);
		}

	}

	public boolean checksDiagDown2(int i0, int j0, int i, int j, int cont, int player, Circles[][] c) {
		if (j0 < 3) {
			return false;
		} else if (j < 0) {
			return checksDiagDown2(i0, j0 - 1, i0, j0 - 1, 0, player, c);
		} else if (c[i][j].player == player && player != 0) {
			line4[cont][0] = i + 1;
			line4[cont][1] = j + 1;
			if (i + 1 <= 6 && j + 1 <= 6) {
				cont++;

			} else {
				cont = 0;

			}
			if (cont == 3) {
				line4[cont][0] = i;
				line4[cont][1] = j;
				return true;
			} else {
				return checksDiagDown2(i0, j0, i - 1, j - 1, cont, player, c);
			}
		} else if (c[i][j].player != player) {
			player = c[i][j].player;
			cont = 0;
			return checksDiagDown2(i0, j0, i - 1, j - 1, cont, player, c);
		} else {
			return checksDiagDown2(i0, j0, i - 1, j - 1, cont, player, c);
		}

	}

	public boolean isDraw(Circles[][] c) {
		for (int i = 1; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[i][j].player == 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		rowToken++;
		boolean stops = isToken(circlesArray[rowToken][columnInPlay]);
		setCircles(circlesArray);
		// System.out.println(circlesArray[rowToken][columnInPlay].player);
		if (stops) {
			rowToken = 0;
			Circles.fallingToken = false;
			timer.stop();
			printArray(circlesArray);
			gameEnded = checksWin(circlesArray);
			draw = isDraw(circlesArray);
			System.out.println(gameEnded);
			print4(line4);
			if (!gameEnded && !draw) {
				playerOne = !playerOne;
			} else if (draw) {
				gameEnded = true;
			} else {

				thread = new hideShow(line4);
				thread.start();

				// thread = new hideShow(line4);
				// thread.start();

			}

		}

	}

	public void print4(int[][] c) {
		System.out.println("  ");
		for (int i = 0; i < c.length; i++) {
			int element = c[i][0];
			System.out.print(element);
			for (int j = 1; j < c[i].length; j++) {
				int element1 = c[i][j];
				if (j == c[i].length - 1) {
					System.out.println(" " + element1);
				} else {
					System.out.print(" " + element1);
				}

			}
		}

	}

}