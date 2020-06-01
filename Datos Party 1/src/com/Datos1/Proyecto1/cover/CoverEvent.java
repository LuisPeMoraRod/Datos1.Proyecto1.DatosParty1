package com.Datos1.Proyecto1.cover;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CoverEvent extends KeyAdapter {

    static boolean cover;
    static boolean instructions;
    public static boolean closeCover;

    CoverEvent(){
        this.cover = true;
        this.instructions = false;
        this.closeCover= false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int id = e.getKeyCode();

        if (id == KeyEvent.VK_ENTER){
            cover = false;
            instructions = true;
        }
        if(id == KeyEvent.VK_SPACE && !cover){
            instructions = false;
            closeCover = true;

        }
    }
}
