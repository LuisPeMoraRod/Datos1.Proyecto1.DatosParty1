package com.Datos1.Proyecto1.SpaceRace;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    public int players;
    public static GamePanel panel_1, panel_2 ,panel_3 ,panel_4;
    public JDesktopPane mainPane;
    public static JInternalFrame iframe1, iframe2, iframe3, iframe4;

    public GameFrame(int players) throws IOException {
        super("SpaceRace");
        this.players = players;
        mainPane = new JDesktopPane();
        start();
    }

    public void start() throws IOException {
        pack();
        setVisible(true);
        setFrameSize(players);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        for(int i = 1; i<= players; i++){
            createGamePanel(i);
        }


    }

    public void setFrameSize(int players){
        if(players == 1) {
            this.setPreferredSize(new Dimension(350, 350));
        }else if(players == 2){
            this.setPreferredSize(new Dimension(350*2, 350));
        }else if(players == 3) {
            this.setPreferredSize(new Dimension(350 * 2, 350*2));
        }else if(players == 4) {
            this.setPreferredSize(new Dimension(350 * 2, 350 * 2));
        }
    }

    public void createGamePanel(int player) throws IOException {
        if(player == 1){
            iframe1 = new JInternalFrame();
            iframe1.setVisible(true);
            iframe1.setSize(350,350);
            iframe1.setLocation(-5,-0); //-5,-30
            mainPane.add(iframe1);
            panel_1 = new GamePanel(player);
            iframe1.add(panel_1);
        }if(player == 2){
            iframe2 = new JInternalFrame();
            iframe2.setVisible(true);
            iframe2.setSize(350,350);
            iframe2.setLocation(335,-30);
            mainPane.add(iframe2);
            panel_2 = new GamePanel(player);
            iframe2.add(panel_2);
        }if(player == 3) {
            iframe3 = new JInternalFrame();
            iframe3.setVisible(true);
            iframe3.setSize(350, 350);
            if(players == 3){
                iframe3.setLocation(335/2, 310);
            }else if(players == 4){
                iframe3.setLocation(-5,310);
            }
            mainPane.add(iframe3);
            panel_3 = new GamePanel(player);
            iframe3.add(panel_3);
        }if(player == 4) {
            iframe4 = new JInternalFrame();
            iframe4.setVisible(true);
            iframe4.setSize(350, 350);
            iframe4.setLocation(335, 310);
            mainPane.add(iframe4);
            panel_4 = new GamePanel(player);
            iframe4.add(panel_4);
        }
        add(mainPane);
    }

    public void iFrameProps(JInternalFrame frame, int x, int y){
        frame.setClosable(false);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

    }
}

