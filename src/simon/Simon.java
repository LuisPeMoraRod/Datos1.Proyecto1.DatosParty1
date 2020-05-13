package simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Simon implements ActionListener, MouseListener {

    public static Simon simon;

    public SimonRenderer simonRenderer;

    public static final int WIDTH=900, HEIGHT= 600;

    public int flashed = 0;

    public int ticks, dark, clickCounts;

    public int reference=1, indexPattern, round=1;

    public boolean creatingPattern = true;

    public ArrayList<Integer> pattern;

    public Random random;


    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth()/2 - WIDTH / 2));
    int y = (int) ((dimension.getHeight()/2 - HEIGHT / 2));


    public Simon(){


        JFrame frame = new JFrame();
        Timer timer = new Timer(20,this);


        simonRenderer = new SimonRenderer();
        frame.add(simonRenderer);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(x, y);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        start();
        timer.start();

    }

    public void start(){

        random = new Random();
        pattern =new ArrayList<Integer>();
    }


    public static void main(String[] args) {

        simon = new Simon();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        ticks++;
        if(ticks%20 ==0){

            flashed=0;

            if (creatingPattern && dark<=0){
                if (reference >pattern.size()){

                    flashed = 1 + random.nextInt(6);
                    pattern.add(flashed);
                    creatingPattern = false;
                    indexPattern=0;
                    clickCounts = 0;

                }
                else{

                    flashed = pattern.get(indexPattern);
                    indexPattern++;

                    if (indexPattern == pattern.size()){
                        reference++;
                    }
                }

                dark = 2;
            }

            dark--;

        }

        simonRenderer.repaint();

    }

    public void paint(Graphics2D g) {

        g.setColor(new Color(34, 50, 64));
        g.fillRect(0,0,WIDTH-WIDTH/2-110,HEIGHT);

        g.setColor(new Color(23, 32, 39));
        g.fillRect(WIDTH/2-110,0,WIDTH-WIDTH/3,HEIGHT);

        if(flashed == 1){
            g.setColor(new Color(231, 44, 187));
        }
        else{
            g.setColor(new Color(139, 28, 113));
        }
        g.fillRoundRect(WIDTH/2,HEIGHT/4, 100,100,10,10);

        if (flashed == 2){
            g.setColor(new Color(107, 233, 39));
        }
        else{
            g.setColor(new Color(106, 131, 25));
        }
        g.fillRoundRect(WIDTH/2+120,HEIGHT/4, 100,100,10,10);

        if(flashed == 3){
            g.setColor(new Color(48, 241, 247));
        }
        else{
            g.setColor(new Color(28, 136, 139));
        }
        g.fillRoundRect(WIDTH/2+240,HEIGHT/4, 100,100,10,10);

        if(flashed==4){
            g.setColor(new Color(255, 144, 41));
        }
        else{
            g.setColor(new Color(141, 80, 24));
        }
        g.fillRoundRect(WIDTH/2,HEIGHT/4+120, 100,100,10,10);

        if(flashed == 5){
            g.setColor(new Color(227, 250, 42));
        }
        else{
            g.setColor(new Color(128, 141, 24));
        }
        g.fillRoundRect(WIDTH/2+120,HEIGHT/4+120, 100,100,10,10);

        if(flashed == 6){
            g.setColor(new Color(141, 40, 237));
        }
        else{
            g.setColor(new Color(77, 22, 129));
        }
        g.fillRoundRect(WIDTH/2+240,HEIGHT/4+120, 100,100,10,10);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",1,40));
        g.drawString("Round " + round, 540,100);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX(), mouseY = e.getY();

        if(!creatingPattern && clickCounts< reference){

                if (mouseX>WIDTH/2 && mouseX<WIDTH/2+100 && mouseY > HEIGHT/4 && mouseY<HEIGHT/4+100){
                    flashed = 1;
                    ticks=1;
                    clickCounts++;

                }
                else if (mouseX>WIDTH/2 + 120 && mouseX<WIDTH/2+220 && mouseY > HEIGHT/4 && mouseY<HEIGHT/4+100){
                    flashed = 2;
                    ticks=1;
                    clickCounts++;
                }
                else if(mouseX>WIDTH/2 + 240 && mouseX<WIDTH/2+340 && mouseY > HEIGHT/4 && mouseY<HEIGHT/4+100){
                    flashed = 3;
                    ticks=1;
                    clickCounts++;
                }
                else if(mouseX>WIDTH/2 && mouseX<WIDTH/2+100 && mouseY > HEIGHT/4 +120 && mouseY<HEIGHT/4+220){
                    flashed = 4;
                    ticks=1;
                    clickCounts++;
                }
                else if(mouseX>WIDTH/2 +120 && mouseX<WIDTH/2+220 && mouseY > HEIGHT/4 +120 && mouseY<HEIGHT/4+220){
                    flashed = 5;
                    ticks=1;
                    clickCounts++;
                }
                else if(mouseX>WIDTH/2 + 240 && mouseX<WIDTH/2+340 && mouseY > HEIGHT/4 +120 && mouseY<HEIGHT/4+220){
                    flashed = 6;
                    ticks=1;
                    clickCounts++;
                }



                if (clickCounts== reference){
                creatingPattern = true;
                round++;
                dark=2;
            }

        }




    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
