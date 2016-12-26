import controller.BaseController;
import controller.GameSetting;
import controller.Planecontroller;
import controller.Starcontroller;
import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import model.BackGround;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Dell on 17/12/2016.
 */
public class Pilot extends Frame implements Runnable {
    Image background;
    Starcontroller starcontroller;

    BufferedImage backbuffer;
    Planecontroller planecontroller;
    ControllerManager controllerManager;
    private static BackGround bg1, bg2;
    Vector<BaseController> baseControllers ;

    public Pilot() {
        baseControllers = new Vector<>();
        setVisible(true);
        setSize(GameSetting.instance.getWidth(), GameSetting.instance.getHeight());
        ///background
        background = Utils.loadImage("resources/background1.png");
        bg1 = new BackGround(0,0);
        bg2 = new BackGround(2300, 0);

        //
//        baseControllers.add(Planecontroller.instance);

        planecontroller = Planecontroller.instance;

        controllerManager = new ControllerManager();

        starcontroller = new Starcontroller(
                new Model(200, 200, 64, 60),
                new SingleView(Utils.loadImage("resources/island.png"))
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
//        backbuffergraphic.drawImage(background, 0, 0, 800, 600, null);
        backbuffergraphic.drawImage(background, bg1.getBgX(), bg1.getBgY(),2300,600, null);
        backbuffergraphic.drawImage(background, bg2.getBgX(), bg2.getBgY(),2300,600, null);
        starcontroller.draw(backbuffergraphic);
        planecontroller.draw(backbuffergraphic);
        controllerManager.draw(backbuffergraphic);
        //
        backbuffergraphic.drawString("HP : "+planecontroller.getModel().getHp(), 100,100);
        backbuffergraphic.drawString("Score : " +planecontroller.getScore() , 100,120);
//        backbuffergraphic.drawString("num of bomb : " + ControllerManager.instance.controllers.size() , 100,130);
    // update background



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

                //
                bg1.update();
                bg2.update();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
