package com.Datos1.Proyecto1.simon;

import javax.swing.*;
import java.awt.*;

/**
 * SimonRender class
 *
 * It renders the game twice to avoid that some ticks are skipped
 * when multiPle actions are taking place.
 *
 * @author Luis Pedro Morales Rodriguez
 *
 * @version 4/29/2020
 */

public class SimonRenderer extends JPanel {


    public SimonRenderer() {
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (Simon.simon!=null){

            Simon.simon.paint((Graphics2D)g);
        }
    }
}
