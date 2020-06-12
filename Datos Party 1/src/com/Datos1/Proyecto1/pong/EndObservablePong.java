package com.Datos1.Proyecto1.pong;

import java.util.Observable;

public class EndObservablePong extends Observable {

    private boolean end;
    public EndObservablePong (boolean end) {
        this.end = end;
    }

    public boolean getEnd() {
        return this.end;
    }

    public void setEnd(boolean end) {
        this.end = end;
        setChanged();
        notifyObservers();
    }

}
