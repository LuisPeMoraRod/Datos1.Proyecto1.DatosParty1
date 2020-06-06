package com.Datos1.Proyecto1.SpaceRace;

import java.awt.*;

public abstract class Sprite {

    private Image image;
    private boolean onScreen;

    protected int x;
    protected int y;

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isOnScreen() {
        return onScreen;
    }

    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }


    protected int dy;
    protected int dx;

    public abstract void move();

    public Sprite(){
        this.onScreen = false;
    }

    public void die(){
        this.onScreen = true;
    }

}
