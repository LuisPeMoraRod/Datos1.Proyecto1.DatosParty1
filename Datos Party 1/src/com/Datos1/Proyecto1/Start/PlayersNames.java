package com.Datos1.Proyecto1.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayersNames extends JFrame {

    private final int width = 1400, height = 800;

    private JPanel canvas = new JPanel();
    JTextField tfPLayer1 = new JTextField("Hola",30);
    JLabel jl = new JLabel();



    public PlayersNames(){
        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        canvas.add(tfPLayer1);

        tfPLayer1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String namePlayer = tfPLayer1.getText();
                jl.setText(namePlayer);
            }
        });

        canvas.add(jl);
        add(canvas);

    }


    public static void main(String[] args) {

        PlayersNames playersNames = new PlayersNames();
        playersNames.setVisible(true);


    }



}
