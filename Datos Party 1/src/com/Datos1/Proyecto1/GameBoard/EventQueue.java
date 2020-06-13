package com.Datos1.Proyecto1.GameBoard;

import java.util.Random;

public class EventQueue {

    private LinkedList eventList;
    private LinkedList eventsQueue;

    private Random random;

    public EventQueue(LinkedList eventList){
        this.eventList = eventList;
        this.random = new Random();
        eventsQueue = new LinkedList();

    }

    public LinkedList shuffleEvents(){
        int eventNumber;
        eventNumber=random.nextInt(eventList.getSize());
        eventsQueue.insertHead(eventList.getNode(eventNumber).getEvent());
        eventList.deleteElement(eventNumber);

        while(eventList.getSize()!=0){
            eventNumber = random.nextInt(eventList.getSize());
            enqueue(eventNumber);
            eventList.deleteElement(eventNumber);
        }

        return this.eventsQueue;
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
