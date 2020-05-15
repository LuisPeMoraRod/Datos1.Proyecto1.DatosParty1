package com.Datos1.Proyecto1.pong;

import java.awt.geom.Rectangle2D;

public class PongPallets {

    private int x, y;
    private final int width = 20, height=200;

    public PongPallets(int x, int y){
        this.x = x;
        this.y = y;

    }

    public Rectangle2D getPallet(){
        return new Rectangle2D.Double(x,y,width,height);
    }
}
