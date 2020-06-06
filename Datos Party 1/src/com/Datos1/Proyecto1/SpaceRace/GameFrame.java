package com.Datos1.Proyecto1.SpaceRace;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    public int players;
    private GamePanel gamePanel1;

    public GameFrame() throws IOException {
        super("SpaceRace");
        gamePanel1 = new GamePanel();
        start();
    }
    public void start(){
        add(gamePanel1);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        }

    }

