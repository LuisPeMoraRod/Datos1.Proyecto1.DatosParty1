package com.Datos1.Proyecto1.Start;

import javax.swing.*;
import java.awt.*;

public class StartBoard extends JPanel {

    public StartBoard(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(200,200,200,200);
    }
}
