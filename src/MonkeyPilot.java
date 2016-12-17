import controller.Planecontroller;
import controller.Starcontroller;
import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import jdk.nashorn.internal.ir.WhileNode;
import model.Model;
import util.Utils;
import view.View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by Dell on 17/12/2016.
 */
public class MonkeyPilot extends Frame implements Runnable {
    Image background;
    Starcontroller starcontroller;

    BufferedImage backbuffer;
    Planecontroller planecontroller;
    ControllerManager controllerManager;

    public MonkeyPilot() {
        planecontroller = Planecontroller.creat(300, 300);
        controllerManager = new ControllerManager();
        setVisible(true);
        setSize(800, 600);
        background = Utils.loadimage("resources/background.png");
        starcontroller = new Starcontroller(
                new Model(200, 200, 64, 60),
                new View(Utils.loadimage("resources/island.png"))
        );
        backbuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planecontroller.setN(1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                planecontroller.setN(0);
            }
        });
    }

        private void init(){
            //

        }
    public void update(Graphics g) {
        Graphics backbuffergraphic = backbuffer.getGraphics();
        backbuffergraphic.drawImage(background, 0, 0, 800, 600, null);
        starcontroller.draw(backbuffergraphic);
        planecontroller.draw(backbuffergraphic);
        controllerManager.draw(backbuffergraphic);
        //
        backbuffergraphic.drawString("HP : "+planecontroller.getModel().getHp(), 100,100);
        backbuffergraphic.drawString("Score : " +planecontroller.getScore() , 100,120);
        backbuffergraphic.drawString("num of bomb : " + controllerManager.controllers.size() , 100,130);


        g.drawImage(backbuffer, 0, 0, 800, 600, null);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                this.repaint();
                planecontroller.run();

                BodyManager.instance.checkContact();
                controllerManager.run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
