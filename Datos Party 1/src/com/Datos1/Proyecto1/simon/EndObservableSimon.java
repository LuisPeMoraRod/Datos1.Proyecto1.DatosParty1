package com.Datos1.Proyecto1.simon;

import java.util.Observable;

public class EndObservableSimon extends Observable {

    private boolean end;
    public EndObservableSimon (boolean end) {
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
