package simon;

import javax.swing.*;
import java.awt.*;

public class SimonRenderer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (Simon.simon!=null){

            Simon.simon.paint((Graphics2D)g);
        }
    }
}
