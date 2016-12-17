import controller.Planecontroller;
import jdk.nashorn.internal.ir.WhileNode;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by Dell on 17/12/2016.
 */
public class MonkeyPilot extends Frame implements Runnable {
    Image background;
    Image star;
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

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

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
                Thread.sleep(17);
                this.repaint();
                planecontroller.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
