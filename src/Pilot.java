import controller.BaseController;
import controller.GameSetting;
import controller.Planecontroller;
import controller.Starcontroller;
import controller.item.ItemManager;
import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import controller.managers.MeteoManager;
import model.BackGround;
import util.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Dell on 17/12/2016.
 */
public class Pilot extends Frame implements Runnable {
    Image background;

    BufferedImage backbuffer;
    private static BackGround bg1, bg2;
    Vector<BaseController> baseControllers;

    public Pilot() {
        baseControllers = new Vector<>();
        baseControllers.add(new MeteoManager());
        baseControllers.add(ControllerManager.explosion);
        baseControllers.add(new ControllerManager());
        baseControllers.add(Starcontroller.instance);
        baseControllers.add(Planecontroller.instance);
        baseControllers.add(BodyManager.instance);
        baseControllers.add(new ItemManager());
        setVisible(true);
        setSize(GameSetting.instance.getWidth(), GameSetting.instance.getHeight());
        ///background
        background = Utils.loadImage("resources/background1.png");
        bg1 = new BackGround(0, 0);
        bg2 = new BackGround(2300, 0);


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
                    Planecontroller.instance.setN(1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Planecontroller.instance.setN(0);
            }
        });
    }

    private void init() {

    }


    public void update(Graphics g) {
        Graphics bbg = backbuffer.getGraphics();
        bbg.drawImage(background, bg1.getBgX(), bg1.getBgY(), 2300, 600, null);
        bbg.drawImage(background, bg2.getBgX(), bg2.getBgY(), 2300, 600, null);

        if (Planecontroller.instance.getModel().isAlive()) {
            for (BaseController b : this.baseControllers) {
                b.draw(bbg);
            }
            Font font = new Font("Bauhaus 93", Font.BOLD, 20);
            bbg.setFont(font);
            bbg.drawString("HP : " + Planecontroller.instance.getModel().getHp(), 100, 100);
            bbg.drawString("Score : " + Planecontroller.instance.getScore(), 100, 120);
            Planecontroller.instance.getModel().drawHealthBar(bbg, 100, 140);
        } else {
            bbg.drawImage(Utils.loadImage("resources/gameOver.png"), 0, 0,
                    GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);

        }


        g.drawImage(backbuffer, 0, 0, 800, 600, null);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                this.repaint();


                for (BaseController b : baseControllers) {
                    b.run();
                }
                //
                bg1.update();
                bg2.update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
