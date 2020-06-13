package com.Datos1.Proyecto1.pong;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 *
 * PongPallets represents the pallets that are used by the players to avoid that the ball collides on each one of their sides
 * of the board. It contains the methods that are necessary to control move the pallets up and down.
 *
 * @author moniwaterhouse
 * @version 1.0
 *
 */

public class PongPallets {

    private int x, y;
    private final int width, height;

    public PongPallets(int x, int y){

        this.x = x;
        this.y = y;

        width = 20;
        height = 100;

    }

    /**
     *
     * @return Rectangle2D object that gives the graphic representation of the pallet
     */

    public Rectangle2D getPallet(){
        return new Rectangle2D.Double(x,y,width,height);
    }

    /**
     * This method moves the left pallet up and down
     *
     * @param limits gives the limits to restrict the pallet movements
     */

    public void movePallet1(Rectangle limits){

        if (PalletEvent.w && y>limits.getMinY()){
            y--;
        }

        else if(PalletEvent.s && y < limits.getMaxY()-height){
            y++;
        }

    }

    /**
     * This method moves the right pallet up and down
     *
     * @param limits gives the limits to restrict the pallet movements
     */

    public void movePallet2(Rectangle limits){

        if (PalletEvent.up && y>limits.getMinY()){
            y--;
        }

        else if(PalletEvent.down && y < limits.getMaxY()-height){
            y++;
        }

    }
}
