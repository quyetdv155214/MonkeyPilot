package controller.scenes.icon;

import controller.scenes.GameScene;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static util.Utils.loadImage;

/**
 * Created by quyet on 1/2/2016.
 */
public class Start extends GameScene implements IconGame {
    private Image start;
    private int x;
    private int y;
    boolean mousedrag= true;

    public static final int WIDTH = 200;
    public static final int HEIGHT = 95;

    public Start(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean checkMouse() {
//        System.out.println(Utils.point.getX() + " " + Utils.point.getY());
        if (Utils.point.getX() >= x
                && Utils.point.getX() <= x + WIDTH
                && Utils.point.getY() <= y + HEIGHT
                && Utils.point.getY() >= y) {

            return true;
        }
        return false;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == e.BUTTON1_MASK){

            start = loadImage("resources/icon/start/button-start-3.png");
        }


    }

    @Override
    public void update(Graphics g) {
        if(checkMouse()) {
            start = loadImage("resources/icon/start/button-start-2.png");
            if (mousedrag)
            Utils.playSound("resources/sound/menu/startButton.wav",false);
            mousedrag =false;
        }
        else {
            start = loadImage("resources/icon/start/button-start-1.png");
            mousedrag =true;
        }
        g.drawImage(start, x, y, WIDTH, HEIGHT, null);
    }

    @Override
    public void run() {
        checkMouse();
    }



    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
