package com.Datos1.Proyecto1.GameBoard;

import java.util.Random;

public class EventQueue {

    private LinkedList eventList;
    private LinkedList eventsQueue;

    private Random random;

    public EventQueue(){
        this.random = new Random();
        eventsQueue = new LinkedList();
        eventList = new LinkedList();
    }

    public void shuffleEvents(){
        int eventNumber;
        eventNumber=random.nextInt(eventList.getSize());
        eventsQueue.insertHead(eventList.getNode(eventNumber).getEvent());
        eventList.deleteElement(eventNumber);

        while(eventList.getSize()!=0){
            eventNumber = random.nextInt(eventList.getSize());
            enqueue(eventNumber);
            eventList.deleteElement(eventNumber);
        }

    }
    public void createEventList() {

		eventList.insertHead(new Events(1));

		for (int i = 0; i < 3; i++) {
			eventList.insertEnd(new Events(2));
		}
		for (int i = 0; i < 3; i++) {
			eventList.insertEnd(new Events(3));
		}
		for (int i = 0; i < 10; i++) {
			eventList.insertEnd(new Events(4));
		}
		for (int i = 0; i < 10; i++) {
			eventList.insertEnd(new Events(4));
		}
		for (int i = 0; i < 10; i++) {
			eventList.insertEnd(new Events(5));
		}

		eventList.insertEnd(new Events(6));
		eventList.insertEnd(new Events(7));

		for (int i = 0; i < 10; i++) {
			eventList.insertEnd(new Events(8));
		}

		for (int i = 0; i < 10; i++) {
			eventList.insertEnd(new Events(9));
		}
		Node pointer = eventList.getHead();
		for (int i = 0; i<eventList.size; i++) {
			System.out.println(pointer.getEvent().eventID);
			pointer = pointer.getNext();
		}

	}

    public void enqueue(int i){
        this.eventsQueue.insertEnd(eventList.getNode(i).getEvent());
    }

    public Events dequeue(){
        Events event = eventsQueue.getHead().getEvent();
        eventsQueue.deleteFirst();
        return event;
    }



}
