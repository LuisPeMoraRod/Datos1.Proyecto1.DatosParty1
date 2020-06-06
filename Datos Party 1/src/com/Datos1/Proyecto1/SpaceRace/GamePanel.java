package com.Datos1.Proyecto1.SpaceRace;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;

public class GamePanel extends JPanel {
    public int players;
    private Ship ship1;
    private Timer timer;
    //BufferedImage ship1 = ImageIO.read(new File("images/Ship1.png"));


    public GamePanel() throws IOException {
        super();
        start();

    }
    public void start() throws IOException {
        this.setPreferredSize(new Dimension(350,350));
        this.setVisible(true);
        this.setBackground(Color.black);
        this.ship1 = new Ship();
        addKeyListener(new GameEventListener(this));
        setFocusable(true);
        this.timer = new Timer(10, new GameLoop(this));
        this.timer.start();

    }
    public void doLoop(){
        update();
        repaint();

    }
    public void update(){
        this.ship1.move();
    }

    private void drawShip(Graphics g){
        g.drawImage(ship1.getImage(), ship1.getX(), ship1.getY(), this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);


    }

    private void doDrawing(Graphics g) {
        drawShip(g);
    }

    public void keyReleased(KeyEvent e){
        this.ship1.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.ship1.keyPressed(e);
    }
}

