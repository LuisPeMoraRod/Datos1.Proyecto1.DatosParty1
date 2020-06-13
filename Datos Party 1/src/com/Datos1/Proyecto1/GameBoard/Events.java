package com.Datos1.Proyecto1.GameBoard;

import java.awt.*;

public class Events extends Component {

	protected int eventID;

	protected boolean winFiveStars;
	protected boolean winTwoStars;
	protected boolean stealStar;
	protected boolean duel;
	protected boolean stealCoins;
	protected boolean giveCoins;
	protected boolean looseStar;
	protected boolean teleport;
	protected boolean switchPlaces;
	protected LinkedList eventList;

	public Events(int eventID) {

		this.eventID = eventID;
		this.eventList = new LinkedList();
		setEvent();
	}

	public void setEvent() {

		switch (eventID) {
		case 1:
			this.winFiveStars = true;
			break;
		case 2:
			this.winTwoStars = true;
			break;
		case 3:
			this.stealStar = true;
			break;
		case 4:
			this.duel = true;
			break;
		case 5:
			this.stealCoins = true;
			break;
		case 6:
			this.giveCoins = true;
			break;
		case 7:
			this.looseStar = true;
			break;
		case 8:
			this.teleport = true;
			break;
		case 9:
			this.switchPlaces = true;
			break;
		default:
			break;
		}

	}

	

}
