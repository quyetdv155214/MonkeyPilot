import controller.Planecontroller;
import jdk.nashorn.internal.ir.WhileNode;
import util.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;

/**
 * Created by Dell on 17/12/2016.
 */
public class MonkeyPilot extends Frame implements Runnable {
    Image background;
    Image star;
    boolean turn = false;

    BufferedImage backbuffer;
    Planecontroller planecontroller;
    public MonkeyPilot(){
        planecontroller = Planecontroller.creat(300,300);
        setVisible(true);
        setSize(800,600);
        background = Utils.loadimage("resources/background.png");
        star = Utils.loadimage("resources/island.png");
        backbuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                turn =true;
            }

            @Override
            public void keyPressed(KeyEvent e) {
<<<<<<< HEAD
                if(e.getKeyCode()== KeyEvent.VK_SPACE) {
                    planecontroller.setN(1);
                }
                System.out.println("1");

=======
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Planecontroller.deg++;
                    planecontroller.run();
                }
>>>>>>> 4ef89fbb49251cb2031a036ff4f578f5093c90cc
            }

            @Override
            public void keyReleased(KeyEvent e) {
<<<<<<< HEAD
                planecontroller.setN(0);
                System.out.println("2");
=======
                turn =false;

>>>>>>> 4ef89fbb49251cb2031a036ff4f578f5093c90cc
            }
        });
    }



    public void update(Graphics g){
       Graphics backbuffergraphic = backbuffer.getGraphics();
       backbuffergraphic.drawImage(background,0,0,800,600,null);
       backbuffergraphic.drawImage(star,500,400,64,60,null);
        planecontroller.draw(backbuffergraphic);

       g.drawImage(backbuffer,0,0,800,600,null);
    }

    public void run(){
        while (true){
            try {
<<<<<<< HEAD
                Thread.sleep(17);
                planecontroller.run();
                this.repaint();
=======
                Thread.sleep(10);
                this.repaint();
                if(!turn){
                    planecontroller.run();
                }
>>>>>>> 4ef89fbb49251cb2031a036ff4f578f5093c90cc
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
