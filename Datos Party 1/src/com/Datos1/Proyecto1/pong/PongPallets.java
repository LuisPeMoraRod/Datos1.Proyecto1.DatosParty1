package com.Datos1.Proyecto1.pong;

import java.awt.*;
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

    public void movePallet1(Rectangle limits){

        if (PalletEvent.w && y>limits.getMinY()){
            y--;
        }

        else if(PalletEvent.s && y < limits.getMaxY()-200){
            y++;
        }

    }

    public void movePallet2(Rectangle limits){

        if (PalletEvent.up && y>limits.getMinY()){
            y--;
        }

        else if(PalletEvent.down && y < limits.getMaxY()-200){
            y++;
        }

    }
}
