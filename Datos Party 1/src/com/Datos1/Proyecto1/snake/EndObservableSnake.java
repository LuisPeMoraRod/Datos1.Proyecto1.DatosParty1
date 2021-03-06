package com.Datos1.Proyecto1.snake;

import java.util.Observable;

/**
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class EndObservableSnake extends Observable {

    private boolean end;

    public EndObservableSnake (boolean end) {
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
