package com.Datos1.Proyecto1.simon;

import java.util.Observable;

/**
 * @author moniwaterhouse
 * @version 1.0
 */

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
